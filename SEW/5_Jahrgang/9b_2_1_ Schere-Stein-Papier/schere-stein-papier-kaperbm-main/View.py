from PyQt6.QtWidgets import QMainWindow, QLabel, QGridLayout, QWidget, QPushButton, QSpinBox
from PyQt6.QtCore import Qt

class GameView(QMainWindow):
    def __init__(self):
        super().__init__()
        self.setWindowTitle('Schere Stein Papier')
        self.setGeometry(100, 100, 400, 300)  # Same layout and size as before
        self.setup_ui()

    def setup_ui(self):
        # Labels and GUI components
        self.round_label = QLabel('Aktuelle Runde')
        self.round_value = QLabel('0')
        self.score_label = QLabel('Aktueller Spielstand')
        self.last_move_label = QLabel('Spieler [-], Computer [-]')
        self.player_score_label = QLabel('Spieler')
        self.computer_score_label = QLabel('Computer')
        self.player_score_value = QLabel('0')
        self.computer_score_value = QLabel('0')

        # Styling for borders and sizes
        border_style = "border: 1px solid black; padding: 5px;"
        labels = [
            self.round_label, self.round_value, self.score_label,
            self.last_move_label, self.player_score_label,
            self.computer_score_label, self.player_score_value,
            self.computer_score_value
        ]
        for label in labels:
            label.setStyleSheet(border_style)
            label.setMinimumSize(150, 30)

        # SpinBox for player's choice (0 = Schere, 1 = Stein, 2 = Papier)
        self.spinbox = QSpinBox()
        self.spinbox.setRange(0, 2)
        self.spinbox.setPrefix('Spielzug ')

        # Buttons
        self.play_button = QPushButton('Ausführen')
        self.reset_button = QPushButton('Zurücksetzen')
        self.close_button = QPushButton('Schließen')

        # Styling buttons with border and dynamic sizing
        buttons = [self.play_button, self.reset_button, self.close_button]
        for button in buttons:
            button.setStyleSheet(border_style)
            button.setMinimumSize(150, 40)

        # Layout
        layout = QGridLayout()
        layout.addWidget(self.score_label, 0, 0, 1, 2, alignment=Qt.AlignmentFlag.AlignCenter)
        layout.addWidget(self.round_label, 1, 0)
        layout.addWidget(self.round_value, 1, 1)
        layout.addWidget(self.last_move_label, 2, 0, 1, 2)
        layout.addWidget(self.player_score_label, 3, 0)
        layout.addWidget(self.computer_score_label, 3, 1)
        layout.addWidget(self.player_score_value, 4, 0)
        layout.addWidget(self.computer_score_value, 4, 1)
        layout.addWidget(self.spinbox, 5, 0)
        layout.addWidget(self.play_button, 5, 1)
        layout.addWidget(self.reset_button, 6, 0)
        layout.addWidget(self.close_button, 6, 1)

        # Set the layout to a QWidget
        container = QWidget()
        container.setLayout(layout)
        self.setCentralWidget(container)
