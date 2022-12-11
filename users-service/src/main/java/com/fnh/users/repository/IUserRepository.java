package com.fnh.users.repository;

import com.fnh.users.model.User;

import java.util.Optional;

public interface IUserRepository {

  User validateAndGetUser(String username);

  Optional<User> getUserExtra(String username);

  User saveUserExtra(User userExtra);

}
