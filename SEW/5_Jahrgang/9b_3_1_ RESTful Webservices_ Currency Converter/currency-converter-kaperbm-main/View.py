# view.py
from PyQt6.QtWidgets import (
    QWidget, QVBoxLayout, QHBoxLayout, QLabel, QLineEdit,
    QDoubleSpinBox, QPushButton, QTextEdit, QStatusBar
)

class View(QWidget):
    """View-Klasse für die Erstellung und Anzeige der GUI auf Deutsch."""
    def __init__(self):
        super().__init__()
        self.init_ui()

    def init_ui(self):
        self.setWindowTitle("Währungsrechner")  # Fenster-Titel auf Deutsch
        main_layout = QVBoxLayout()
        input_layout = QHBoxLayout()

        # Eingabefelder
        self.amount_input = QDoubleSpinBox()
        self.amount_input.setRange(0.01, 1000000.00)
        self.amount_input.setValue(10.00)

        self.base_currency_input = QLineEdit("EUR")  # Standardwährung EUR
        self.target_currency_input = QLineEdit("USD,CHF")  # Zielwährungen
        self.result_display = QTextEdit()
        self.result_display.setReadOnly(True)

        # Buttons
        self.convert_button = QPushButton("Umrechnen")
        self.reset_button = QPushButton("Zurücksetzen")
        self.exit_button = QPushButton("Exit")
        self.status_bar = QStatusBar()

        # Layout und Beschriftungen auf Deutsch
        input_layout.addWidget(QLabel("Betrag:"))
        input_layout.addWidget(self.amount_input)
        input_layout.addWidget(QLabel("Währung:"))
        input_layout.addWidget(self.base_currency_input)
        input_layout.addWidget(QLabel("Zielwährungen:"))
        input_layout.addWidget(self.target_currency_input)

        main_layout.addLayout(input_layout)
        main_layout.addWidget(self.convert_button)
        main_layout.addWidget(self.result_display)
        main_layout.addWidget(self.reset_button)
        main_layout.addWidget(self.exit_button)
        main_layout.addWidget(self.status_bar)

        self.setLayout(main_layout)
