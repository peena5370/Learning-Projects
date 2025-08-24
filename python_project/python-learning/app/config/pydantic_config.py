from functools import lru_cache
from pydantic import Field, SecretStr
from pydantic_settings import BaseSettings, SettingsConfigDict

from model.config_model import ConfigSetting

class EnvironmentSettings(BaseSettings):
    model_config = SettingsConfigDict(
        env_nested_delimiter="__", 
        env_file="../.env", 
        env_file_encoding="utf-8"
        )

    config: ConfigSetting

    database_host: str
    database_port: int
    database_user: str
    database_password: SecretStr
    database_name: str

@lru_cache
def get_settings() -> EnvironmentSettings:
    return EnvironmentSettings() # type: ignore