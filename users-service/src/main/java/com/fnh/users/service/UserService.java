package com.fnh.users.service;

import com.fnh.users.model.User;
import com.fnh.users.model.UserKeycloak;
import com.fnh.users.model.UserNotAdmin;
import com.fnh.users.repository.KeyCloakRepository;
import com.fnh.users.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

  private final UserRepository userRepository;
  private final KeyCloakRepository keycloakRepository;


  @Override
  public User validateAndGetUserExtra(String username) {
    return userRepository.validateAndGetUser(username);
  }

  @Override
  public Optional<User> getUserExtra(String username) {
    return userRepository.getUserExtra(username);
  }

  @Override
  public User saveUserExtra(User user) {
    return userRepository.saveUserExtra(user);
  }

  @Override
  public List<UserNotAdmin> findByGroups() {
    return keycloakRepository.findByGroups();
  }

  @Override
  public UserKeycloak findByUsername(String username) {
    return keycloakRepository.findByUsername(username);
  }

  @Override
  public UserKeycloak findByUserId(String userId) {
    return keycloakRepository.findByUserId(userId);
  }

}
