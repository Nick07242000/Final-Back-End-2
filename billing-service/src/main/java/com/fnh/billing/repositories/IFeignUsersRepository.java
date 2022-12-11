package com.fnh.billing.repositories;

import com.fnh.billing.models.dto.UserDTO;
import com.fnh.billing.config.FeignInterceptor;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name= "users-service", url = "http://users-service:8083", configuration = FeignInterceptor.class)
public interface IFeignUsersRepository {

    @GetMapping("users/admin/{username}")
    ResponseEntity<UserDTO> findByUsername(@PathVariable String username);
}
