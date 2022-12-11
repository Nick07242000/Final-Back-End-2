package com.fnh.users.controller;

import com.fnh.users.model.User;
import com.fnh.users.model.UserKeycloak;
import com.fnh.users.model.UserNotAdmin;
import com.fnh.users.model.dto.UserRequest;
import com.fnh.users.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

  private final IUserService userService;
 //TODO  estos dos endpoints funcionaran cuando este configurada la seguridad en el proyecto

  @GetMapping("/me")
  public User getUserExtra(Principal principal) {
    return userService.validateAndGetUserExtra(principal.getName());
  }

  @PostMapping("/me")
  public User saveUserExtra(@Valid @RequestBody UserRequest updateUserRequest, Principal principal) {
    Optional<User> userOptional = userService.getUserExtra(principal.getName());
    User userExtra = userOptional.orElseGet(() -> new User(principal.getName()));
    userExtra.setAvatar(updateUserRequest.getAvatar());
    return userService.saveUserExtra(userExtra);
  }

  @GetMapping("/admin")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public List<UserNotAdmin> getNonAdminUsers() {
      return userService.findByGroups();
  }

  @GetMapping("/admin/{username}")
  @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_CLIENT')")
  public UserKeycloak findByUsername(@PathVariable String username) {
    return userService.findByUsername(username);
  }

  @GetMapping("/admin/findbyuserid/{userId}")
  @PreAuthorize("hasRole('ROLE_ADMIN')")
  public UserKeycloak findByUserId(@PathVariable String userId) {
    return userService.findByUserId(userId);
  }

}
