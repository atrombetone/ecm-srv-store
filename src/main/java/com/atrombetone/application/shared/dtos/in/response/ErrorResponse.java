package com.atrombetone.application.shared.dtos.in.response;

public record ErrorResponse(
        String message,
        String path,
        int status
) {
}
