package com.fnh.users.repository;

import com.fnh.users.model.UserKeycloak;
import com.fnh.users.model.UserNotAdmin;

import java.util.List;

public interface IKeycloakRepository {

    List<UserNotAdmin> findByGroups();

    UserKeycloak findByUsername(String username);

    UserKeycloak findByUserId(String userId);

}
