from common.abstract_class import AbstractUtilClass

class InheritUtilClass(AbstractUtilClass):
    def __init__(self, name: str, breed: str):
        super().__init__(name)
        self.breed = breed
    
    def speak(self) -> str:
        return "miao"

    def print_child_and_parent_class_method(self):
        super().print_parent_class_msg()
        print("printline from inherit class")

    def override_parent_class(self):
        print("hahaha from child class")