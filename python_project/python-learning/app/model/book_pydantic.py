from pydantic import BaseModel

class BookPydantic(BaseModel):
    name: str
    serial: int
    publisher: str = "Empty publisher"
    is_published: bool = False