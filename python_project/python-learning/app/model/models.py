from sqlalchemy import Column, Integer, String
from sqlalchemy.ext.declarative import declarative_base

Base = declarative_base()

class Role(Base):
    __tablename__ = "roles"

    role_id = Column(Integer, autoincrement=False, primary_key=True)
    role_name = Column(String(50), nullable=False)