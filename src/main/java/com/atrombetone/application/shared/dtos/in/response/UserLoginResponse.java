package com.atrombetone.application.shared.dtos.in.response;

public record UserLoginResponse(
        Long userId,
        String userFullName,
        String userMail,
        String token
) {
}
