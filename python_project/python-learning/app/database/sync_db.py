from urllib.parse import quote_plus
from sqlalchemy import create_engine
from sqlalchemy.orm import sessionmaker
from config.pydantic_config import get_settings

settings = get_settings()

encoded_password = quote_plus(settings.database_password.get_secret_value())

DB_URL = (f"mariadb+pymysql://{settings.database_user}:"
          f"{encoded_password}"
          f"@{settings.database_host}:{settings.database_port}/"
          f"{settings.database_name}")

engine = create_engine(DB_URL)
SessionLocal = sessionmaker(
    autocommit=False, 
    autoflush=False,
    bind=engine)

def get_db():
    db = SessionLocal()
    try:
        yield db
    except Exception as e:
        print(f"exception occured when establishing sb connection: {e}")
    finally:
        db.close()