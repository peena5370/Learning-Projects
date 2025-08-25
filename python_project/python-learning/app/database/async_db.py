from contextlib import asynccontextmanager
from typing import AsyncGenerator
from urllib.parse import quote_plus
from sqlalchemy.ext.asyncio import create_async_engine, AsyncSession
from sqlalchemy.orm import sessionmaker
from config.pydantic_config import get_settings

settings = get_settings()

encoded_password = quote_plus(settings.database_password.get_secret_value())

DB_URL = (f"mariadb+aiomysql://{settings.database_user}:"
          f"{encoded_password}"
          f"@{settings.database_host}:{settings.database_port}/"
          f"{settings.database_name}")

engine = create_async_engine(DB_URL, echo=True)
AsyncSessionLocal = sessionmaker(
    bind=engine,
    expire_on_commit=False,
    class_=AsyncSession
) # type: ignore

@asynccontextmanager # Use the decorator here
async def get_db_session():
    db = AsyncSessionLocal()
    try:
        yield db
    finally:
        await db.close()