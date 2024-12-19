package com.elibrarian.demo.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.elibrarian.demo.model.UsersEntity;

public interface UsersRepository extends JpaRepository<UsersEntity, Integer> {
	
	@Query(value= "select * from e_users where username like ?1", nativeQuery=true)
	Optional<UsersEntity> findByUsername(String username);
}
