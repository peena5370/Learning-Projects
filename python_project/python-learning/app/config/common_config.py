import os

from dotenv import load_dotenv

class CommonConfig:
    @staticmethod
    def get_config_values():
        load_dotenv()

        config_val1 = os.getenv("config.val1")
        config_val2 = os.getenv("config.val2")

        print(f"config val1={config_val1}, val2={config_val2}")