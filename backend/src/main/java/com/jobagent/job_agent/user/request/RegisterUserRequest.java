package com.jobagent.job_agent.user.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.openxmlformats.schemas.drawingml.x2006.main.STPositiveFixedPercentageDecimal;

@Getter
@Setter
public class RegisterUserRequest {

    @NotBlank
    private String fullName;

    @Email
    private String email;

    @NotBlank
    private String password;
}
