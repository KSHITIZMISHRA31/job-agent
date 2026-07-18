package com.jobagent.job_agent.user.service.impl;


import com.jobagent.job_agent.user.entity.User;
import com.jobagent.job_agent.common.exception.ResourceAlreadyExistsException;
import com.jobagent.job_agent.user.repository.UserRepository;
import com.jobagent.job_agent.user.request.RegisterUserRequest;
import com.jobagent.job_agent.user.response.UserResponse;
import com.jobagent.job_agent.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse register(RegisterUserRequest request){
        if(userRepository.existsByEmail(request.getEmail())){
            throw new ResourceAlreadyExistsException("Email already registered");
        }

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());

        User savedUser = userRepository.save(user);


        return UserResponse.builder()
                .id(savedUser.getId())
                .fullName(savedUser.getFullName())
                .email(savedUser.getEmail())
                .build();

    }


}
