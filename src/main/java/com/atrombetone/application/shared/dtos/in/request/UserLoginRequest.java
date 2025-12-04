package com.atrombetone.application.shared.dtos.in.request;

public record UserLoginRequest(
        String mail,
        String password
) {
}
