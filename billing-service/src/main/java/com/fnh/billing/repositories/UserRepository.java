package com.fnh.billing.repositories;

import com.fnh.billing.models.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository implements IUserRepository{

    private final IFeignUsersRepository feignUsersRepository;

    @Autowired
    public UserRepository(IFeignUsersRepository feignUsersRepository) {
        this.feignUsersRepository = feignUsersRepository;
    }

    @Override
    public UserDTO findByUsername(String username) {
        ResponseEntity<UserDTO> response = feignUsersRepository.findByUsername(username);
        return response.getBody();
    };

}

