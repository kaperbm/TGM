package org.example;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class JsonPersistenceStrategy {
    public void save(Rechtschreibtrainer trainer, String filePath) throws IOException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gesamteVersuche", trainer.getGesamteVersuche());
        jsonObject.put("richtig", trainer.getRichtigeVersuche());
        jsonObject.put("falsch", trainer.getFalscheVersuche());

        JSONArray jsonArray = new JSONArray();
        for (TrainingsDaten daten : trainer.getTrainingsDatenListe()) {
            JSONObject paarObject = new JSONObject();
            paarObject.put("wort", daten.getWort());
            paarObject.put("url", daten.getUrl().toString());
            jsonArray.put(paarObject);
        }
        jsonObject.put("trainingsDatenListe", jsonArray);

        try (FileWriter file = new FileWriter(filePath)) {
            file.write(jsonObject.toString(4));
        }
    }

    public Rechtschreibtrainer load(String filePath) throws Exception {
        Rechtschreibtrainer trainer = new Rechtschreibtrainer();
        File file = new File(filePath);
        String content = new String(Files.readAllBytes(file.toPath()));

        JSONObject jsonObject = new JSONObject(content);
        trainer.setGesamteVersuche(jsonObject.getInt("gesamteVersuche"));
        trainer.setRichtigeVersuche(jsonObject.getInt("richtig"));
        trainer.setFalscheVersuche(jsonObject.getInt("falsch"));

        JSONArray jsonArray = jsonObject.getJSONArray("trainingsDatenListe");
        List<TrainingsDaten> datenListe = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject paarObject = jsonArray.getJSONObject(i);
            String wort = paarObject.getString("wort");
            URL url = new URL(paarObject.getString("url"));
            datenListe.add(new TrainingsDaten(wort, url));
        }
        trainer.setTrainingsDatenListe(datenListe);

        return trainer;
    }
}
