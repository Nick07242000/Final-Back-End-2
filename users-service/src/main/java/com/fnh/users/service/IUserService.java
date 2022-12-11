package com.fnh.users.service;

import com.fnh.users.model.User;
import com.fnh.users.model.UserKeycloak;
import com.fnh.users.model.UserNotAdmin;

import java.util.List;
import java.util.Optional;

public interface IUserService {
  User validateAndGetUserExtra(String username);

  Optional<User> getUserExtra(String username);

  User saveUserExtra(User userExtra);

  List<UserNotAdmin> findByGroups();

  UserKeycloak findByUsername(String firstName);

  UserKeycloak findByUserId(String userId);
}
