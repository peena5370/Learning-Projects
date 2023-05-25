package com.elibrarian.demo.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrarian.demo.model.UsersEntity;
import com.elibrarian.demo.repos.UsersRepository;
import com.elibrarian.demo.services.UsersService;

@Service
public class UsersServiceImpl implements UsersService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Override
	public UsersEntity addUser(UsersEntity user) {
		UsersEntity savedEntity = usersRepository.save(user);
		usersRepository.flush();
		
		return savedEntity;
	}

	@Override
	public List<UsersEntity> viewUsers() {
		return usersRepository.findAll();
	}
	
	@Override
	public Optional<UsersEntity> viewUserById(Integer uId) {
		return usersRepository.findById(uId);
	}

	@Override
	public Optional<UsersEntity> viewUserByUsername(String username) {
		return usersRepository.findByUsername(username);
	}

	@Override
	public UsersEntity updateUser(UsersEntity user) {
		UsersEntity updatedEntity = usersRepository.save(user);
		usersRepository.flush();
		
		return updatedEntity;
	}

	@Override
	public Integer removeUser(Integer uId) {
		Integer row = 0;
		try {
			usersRepository.deleteById(uId);
			row = 1;
		} catch(IllegalArgumentException e) {
			e.printStackTrace();
			row = 0;
		}
		
		return row;
	}

}
