from datetime import datetime
from typing import List, Optional
from sqlalchemy.ext.asyncio import AsyncSession
from sqlalchemy.future import select
from model.models import Role

class AsyncRoleService:
    async def create_role(self, db: AsyncSession, role_name: str) -> Role:
        db_role = Role(role_id=999999999, role_name=role_name)
        db.add(db_role)
        await db.commit()
        await db.refresh(db_role)
        return db_role

    async def get_roles(self, db: AsyncSession) -> List[Role]:
        result = await db.execute(select(Role))
        return result.scalars().all()

    async def get_role_by_id(self, db: AsyncSession, role_id: int) -> Optional[Role]:
        result = await db.execute(select(Role).filter(Role.role_id == role_id))
        return result.scalar_one_or_none()

    async def update_role(self, db: AsyncSession, role_id: int, role_name: str) -> Optional[Role]:
        db_role = await self.get_role_by_id(db, role_id)
        if db_role:
            db_role.role_name = role_name
            await db.commit()
            await db.refresh(db_role)
        return db_role

    async def delete_role(self, db: AsyncSession, role_id: int) -> bool:
        db_role = await self.get_role_by_id(db, role_id)
        if db_role:
            await db.delete(db_role)
            await db.commit()
            return True
        return False