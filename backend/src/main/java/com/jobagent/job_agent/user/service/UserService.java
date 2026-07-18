package com.jobagent.job_agent.user.service;

import com.jobagent.job_agent.user.request.RegisterUserRequest;
import com.jobagent.job_agent.user.response.UserResponse;

public interface UserService {

    UserResponse register(RegisterUserRequest request);

}
