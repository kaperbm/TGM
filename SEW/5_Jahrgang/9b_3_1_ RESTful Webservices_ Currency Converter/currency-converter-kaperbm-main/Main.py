# main.py
import sys
from PyQt6.QtWidgets import QApplication
from Model import Model
from View import View
from Controller import Controller

if __name__ == '__main__':
    app = QApplication(sys.argv)

    Model = Model()
    View = View()
    Controller = Controller(Model, View)

    View.show()
    sys.exit(app.exec())
