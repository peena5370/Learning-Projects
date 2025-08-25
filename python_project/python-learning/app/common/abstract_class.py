from abc import ABC, abstractmethod

class AbstractUtilClass(ABC):
    def __init__(self, name: str):
        self.name = name

    @abstractmethod
    def speak(self) -> str:
        pass

    def print_parent_class_msg(self):
        print("printline from abstract class")

    def override_parent_class(self):
        print("hahaha from parent class")