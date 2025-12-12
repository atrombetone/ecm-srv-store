package com.atrombetone.domain.model;

import com.atrombetone.application.shared.enums.GenderType;
import com.atrombetone.application.shared.enums.UserRoleType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class UserModel {
    
    private Long id;
    private String name;
    private String password;
    private String mail;
    private String phone;
    private LocalDate birthday;
    private String hash_lost_pwd;
    private LocalDateTime hash_expiration;
    private GenderType genderType;
    private String token;
    private List<UserRoleType> roles;
}
