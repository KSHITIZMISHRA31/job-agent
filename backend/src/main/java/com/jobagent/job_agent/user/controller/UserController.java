package com.jobagent.job_agent.user.controller;

import com.jobagent.job_agent.user.request.RegisterUserRequest;
import com.jobagent.job_agent.user.response.UserResponse;
import com.jobagent.job_agent.user.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping("/register")
    public UserResponse register(
            @Valid @RequestBody RegisterUserRequest request) {
        return userService.register(request);
    }

}
