class GameController:
    def __init__(self, model, view):
        self.model = model
        self.view = view

        # Connect the buttons to actions
        self.view.play_button.clicked.connect(self.play_round)
        self.view.reset_button.clicked.connect(self.reset_game)
        self.view.close_button.clicked.connect(self.view.close)

    # Play a single round of the game
    def play_round(self):
        player_choice = self.view.spinbox.value()
        result, player_choice, computer_choice = self.model.evaluate_round(player_choice)

        # Update the view
        self.update_view(result, player_choice, computer_choice)

    # Update the view to reflect the game state
    def update_view(self, result, player_choice, computer_choice):
        self.view.round_value.setText(str(self.model.rounds))
        self.view.player_score_value.setText(str(self.model.player_score))
        self.view.computer_score_value.setText(str(self.model.computer_score))
        self.view.last_move_label.setText(
            f'Spieler [{self.model.choice_to_string(player_choice)}], Computer [{self.model.choice_to_string(computer_choice)}] ({result})'
        )

    def reset_game(self):
        # Setzt den Spielzustand zurück
        self.model.reset_game()

        # Aktualisiert die GUI mit den Anfangswerten
        self.view.round_value.setText('0')
        self.view.player_score_value.setText('0')
        self.view.computer_score_value.setText('0')
        self.view.last_move_label.setText('Spieler [-], Computer [-]')