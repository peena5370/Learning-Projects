from dataclasses import dataclass

@dataclass
class BookData:
    book_name: str
    book_serial: int
    publisher: str = "Empty publisher"
    is_published: bool = False
