package com.fnh.users.repository;

import com.fnh.users.model.UserKeycloak;
import com.fnh.users.model.UserNotAdmin;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
public class KeyCloakRepository implements IKeycloakRepository {

    @Autowired
    private Keycloak keycloakClient;

    @Value("${kconfig.keycloak.realm}")
    private String realm;

    @Override
    public List<UserNotAdmin> findByGroups() {
        List<UserRepresentation> usersFromKeycloak = keycloakClient.realm(realm).users().list();
        List<UserRepresentation> usersEnabled = usersFromKeycloak.stream().
                filter(userRepresentation -> keycloakClient.realm(realm).users()
                        .get(userRepresentation.getId())
                        .groups().stream()
                        .noneMatch(s -> Objects.equals(s.getName(), "admin")))
                .collect(Collectors.toList());

        return usersEnabled.stream().map(this::toUserNotAdmin).collect(Collectors.toList());
    }

    private UserNotAdmin toUserNotAdmin(UserRepresentation userRepresentation) {
        return new UserNotAdmin(userRepresentation.getUsername(), userRepresentation.getEmail());
    }

    @Override
    public UserKeycloak findByUsername(String username) {
        UserRepresentation user = keycloakClient.realm(realm).users().search(username).get(0);
        return toUserKeycloak(user);
    }

    @Override
    public UserKeycloak findByUserId(String userId) {
        UserRepresentation user = keycloakClient.realm(realm).users().get(userId).toRepresentation();
        return toUserKeycloak(user);
    }

    private UserKeycloak toUserKeycloak(UserRepresentation userRepresentation) {
        return new UserKeycloak(userRepresentation.getUsername(), userRepresentation.getFirstName(), userRepresentation.getLastName(), userRepresentation.getEmail());
    }

}
