package com.jobagent.job_agent.user.response;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponse {

    private Long id;
    private String fullName;
    private String email;
}
