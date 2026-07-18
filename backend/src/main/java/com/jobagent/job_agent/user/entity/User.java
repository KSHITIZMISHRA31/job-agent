package com.jobagent.job_agent.user.entity;


import com.jobagent.job_agent.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @NotBlank
    @Column(nullable = false)
    private String fullName;

    @Email
    @Column(nullable = false,unique = true)
    private String email;

    @NotBlank
    @Column(nullable = false)
    private String password;
}
