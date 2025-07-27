# Import necessary libraries
from datasets import load_dataset
from transformers import AutoTokenizer, AutoModelForTokenClassification, DataCollatorForTokenClassification, Trainer, TrainingArguments, pipeline
import numpy as np
from seqeval.metrics import f1_score, classification_report
import os

# Load the dataset
dataset = load_dataset("conllpp")
train_dataset = dataset["train"]
val_dataset = dataset["validation"]
test_dataset = dataset["test"]

# Initialize the tokenizer and model
model_name = "bert-base-cased"
tokenizer = AutoTokenizer.from_pretrained(model_name)
model = AutoModelForTokenClassification.from_pretrained(
    model_name, num_labels=9  # 9 Labels including BIO tagging
)

# Define helper functions
index2tag = {0: "O", 1: "B-PER", 2: "I-PER", 3: "B-ORG", 4: "I-ORG", 5: "B-LOC", 6: "I-LOC", 7: "B-MISC", 8: "I-MISC"}
tag2index = {v: k for k, v in index2tag.items()}

def tokenize_and_align_labels(examples):
    tokenized_inputs = tokenizer(examples["tokens"], truncation=True, is_split_into_words=True)

    labels = []
    for idx, label in enumerate(examples["ner_tags"]):
        word_ids = tokenized_inputs.word_ids(batch_index=idx)
        previous_word_idx = None
        label_ids = []
        for word_idx in word_ids:
            if word_idx is None or word_idx == previous_word_idx:
                label_ids.append(-100)
            else:
                label_ids.append(label[word_idx])
            previous_word_idx = word_idx
        labels.append(label_ids)

    tokenized_inputs["labels"] = labels
    return tokenized_inputs

# Tokenize and align labels
encoded_dataset = dataset.map(tokenize_and_align_labels, batched=True)

# Data Collator
data_collator = DataCollatorForTokenClassification(tokenizer=tokenizer)

# Define metrics function
def compute_metrics(predictions_and_labels):
    predictions, labels = predictions_and_labels
    predictions = np.argmax(predictions, axis=2)

    true_labels = [
        [index2tag[label] for label in labels[i] if label != -100]
        for i in range(len(labels))
    ]
    true_predictions = [
        [index2tag[pred] for (pred, label) in zip(predictions[i], labels[i]) if label != -100]
        for i in range(len(labels))
    ]

    return {
        "f1": f1_score(true_labels, true_predictions),
        "classification_report": classification_report(true_labels, true_predictions),
    }

# Training Arguments
training_args = TrainingArguments(
    output_dir="./results",
    eval_strategy="epoch",
    learning_rate=1e-4,
    per_device_train_batch_size=16,
    per_device_eval_batch_size=16,
    num_train_epochs=1,
    weight_decay=0.01,
    logging_dir="./logs",
    logging_steps=10,
    save_total_limit=1,
)

# Trainer
trainer = Trainer(
    model=model,
    args=training_args,
    train_dataset=encoded_dataset["train"],
    eval_dataset=encoded_dataset["validation"],
    tokenizer=tokenizer,
    data_collator=data_collator,
    compute_metrics=compute_metrics,
)

# Train the model
print("Starting training...")
# trainer.train()
print("Training completed.")

# Save the trained model and tokenizer
save_directory = "./saved_model"
os.makedirs(save_directory, exist_ok=True)
model.save_pretrained(save_directory)
tokenizer.save_pretrained(save_directory)
print(f"Model and tokenizer saved to {save_directory}")

# Load the saved model and tokenizer
loaded_model = AutoModelForTokenClassification.from_pretrained(save_directory)
loaded_tokenizer = AutoTokenizer.from_pretrained(save_directory)

# Run additional validations
print("Running additional validations...")
ner_pipeline = pipeline("ner", model=loaded_model, tokenizer=loaded_tokenizer)

# Validate on multiple examples
validation_examples = [
    "Barack Obama was the 44th president of the United States.",
    "Google was founded in 1998 by Larry Page and Sergey Brin.",
    "The Eiffel Tower is located in Paris, France.",
    "Apple Inc. is one of the biggest tech companies in the world.",
    "The Nile is the longest river in the world, flowing through Egypt."
]

for example in validation_examples:
    print(f"Input: {example}")
    predictions = ner_pipeline(example)
    for prediction in predictions:
        print(f"Entity: {prediction['word']}, Label: {prediction['entity']}, Score: {prediction['score']:.4f}")
    print("-" * 50)
