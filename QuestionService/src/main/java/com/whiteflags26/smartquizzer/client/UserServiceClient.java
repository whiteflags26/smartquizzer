package com.whiteflags26.smartquizzer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "auth-service")
public interface UserServiceClient {
    
    @GetMapping("/api/auth/users/{id}")
    Object getUserById(@PathVariable("id") Long id);
    
    @GetMapping("/api/auth/users/exists/{username}")
    boolean userExists(@PathVariable("username") String username);
}
