from typing import List, Optional
from sqlalchemy.orm import Session
from model.models import Role

class SyncRoleService:
    def create_role(self, db: Session, role_name: str) -> Role:
        db_role = Role(role_id=1234567890, role_name=role_name)
        db.add(db_role)
        db.commit()
        db.refresh(db_role)
        return db_role

    def get_roles(self, db: Session) -> List[Role]:
        return db.query(Role).all()

    def get_role_by_id(self, db: Session, role_id: int) -> Optional[Role]:
        return db.query(Role).filter(Role.role_id == role_id).first()

    def update_role(self, db: Session, role_id: int, role_name: str) -> Optional[Role]:
        db_role = self.get_role_by_id(db, role_id)
        if(db_role):
            db_role.role_name = role_name
            db.commit()
            db.refresh(db_role)
        
        return db_role
    
    def delete_role(self, db: Session, role_id: int) -> bool:
        db_role = self.get_role_by_id(db, role_id)
        if(db_role):
            db.delete(db_role)
            db.commit()
            return True
        
        return False