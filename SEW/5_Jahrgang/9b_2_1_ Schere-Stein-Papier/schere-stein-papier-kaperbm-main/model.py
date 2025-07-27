import random
from collections import deque, Counter
from enum import IntEnum

# Using Enum for player/computer choices
class Move(IntEnum):
    SCHERE = 0
    STEIN = 1
    PAPIER = 2

class GameModel:
    def __init__(self):
        self.reset_game()

    def get_computer_choice(self):
        # Zählt die letzten Spielerzüge und prüft den häufigsten
        if len(self.player_moves) > 0:
            last_moves_counter = Counter(self.player_moves)
            likely_player_move = last_moves_counter.most_common(1)[0][0]

            # Computer wählt die optimale Gegenwahl, um den häufigsten Spielerzug zu schlagen
            counter_move = (likely_player_move + 1) % 3
            if random.random() < 0.7: # Zu 70% die Kounter-Wahl
                return counter_move
            else:
                return random.choice([Move.SCHERE, Move.STEIN, Move.PAPIER])
        else:
            # Keine Spielerhistorie vorhanden, wählt zufälligddf
            return random.choice([Move.SCHERE, Move.STEIN, Move.PAPIER])


    # Evaluate the round, update scores, and return result and moves
    def evaluate_round(self, player_choice):
        computer_choice = self.get_computer_choice()
        self.player_moves.append(player_choice)

        # Add a counter move to the computer's history
        counter_move = (player_choice + 1) % 3
        self.computer_counters.append(counter_move)

        if player_choice == computer_choice:
            result = 'Unentschieden'
        elif (player_choice - computer_choice) % 3 == 1:
            self.player_score += 1
            result = 'Spieler gewinnt'
        else:
            self.computer_score += 1
            result = 'Computer gewinnt'

        self.rounds += 1
        return result, player_choice, computer_choice

    # Reset game state
    def reset_game(self):
        self.player_score = 0
        self.computer_score = 0
        self.rounds = 0
        self.choices = ['Schere', 'Stein', 'Papier']
        self.player_moves = deque(maxlen=10)
        self.computer_counters = deque([Move.SCHERE, Move.STEIN, Move.PAPIER])

    # Convert choice to string
    def choice_to_string(self, choice):
        return self.choices[choice]
