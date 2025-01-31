import sys
from PyQt6.QtWidgets import QApplication
from model import GameModel
from View import GameView
from Controller import GameController

def main():
    app = QApplication(sys.argv)

    # Initialize MVC components
    model = GameModel()
    view = GameView()
    controller = GameController(model, view)

    # Show the GUI
    view.show()
    sys.exit(app.exec())

if __name__ == '__main__':
    main()
