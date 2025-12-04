package com.atrombetone.domain.model;

import com.atrombetone.application.shared.enums.GenderType;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

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
}
