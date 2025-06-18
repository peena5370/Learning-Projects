package com.elibrarian.demo.services;

import java.util.List;
import java.util.Optional;

import com.elibrarian.demo.model.UsersEntity;

public interface UsersService {
    UsersEntity addUser(UsersEntity user);

    List<UsersEntity> viewUsers();

    Optional<UsersEntity> viewUserById(Integer uId);

    Optional<UsersEntity> viewUserByUsername(String username);

    UsersEntity updateUser(UsersEntity user);

    Integer removeUser(Integer uId);
}
