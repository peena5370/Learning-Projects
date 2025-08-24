from sqlalchemy.ext.asyncio import create_async_engine, AsyncSession
from sqlalchemy.orm import sessionmaker
from config.pydantic_config import get_settings

settings = get_settings()

DB_URL = (f"mariadb+aiomysql://{settings.database_user}:"
          f"{settings.database_password.get_secret_value()}"
          f"@{settings.database_host}:{settings.database_port}/"
          f"{settings.database_name}")

engine = create_async_engine(DB_URL, echo=True)
AsyncSessionLocal = sessionmaker(
    bind=engine,
    expire_on_commit=False,
    class_=AsyncSession
) # type: ignore

async def get_db_session() -> AsyncSession:
    async with AsyncSessionLocal() as session: # type: ignore
        yield session