package com.fnh.billing.repositories;

import com.fnh.billing.models.dto.UserDTO;

public interface IUserRepository {

    UserDTO findByUsername(String username);
}
