import sys
 
# import PyQt5 widgets
from PyQt5.QtWidgets import QMainWindow, QApplication, QWidget

from myinterface import Ui_Form

class Main(QMainWindow, Ui_Form):
    def __init__(self, parent=None):
        super(Main, self).__init__(parent)
        # define central widget for QWidget use in QMainWindow
        self.central_widget = QWidget()
        self.setCentralWidget(self.central_widget)
        self.setupUi()

if __name__ == '__main__':
    # every Qt application need this argument
    app = QApplication(sys.argv)
    execute = Main()
    sys.exit(app.exec_())