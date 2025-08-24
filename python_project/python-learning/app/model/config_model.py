from pydantic import BaseModel

class ConfigSetting(BaseModel):
    val1: str
    val2: int