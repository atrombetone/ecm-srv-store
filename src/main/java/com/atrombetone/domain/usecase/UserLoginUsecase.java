package com.atrombetone.domain.usecase;

import com.atrombetone.application.domain.usecase.IUserLoginUsecase;
import com.atrombetone.application.out.provider.IUserProvider;
import com.atrombetone.domain.model.UserModel;
import io.smallrye.jwt.build.Jwt;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.Claims;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashSet;

@ApplicationScoped
public class UserLoginUsecase implements IUserLoginUsecase {
    
    @Inject
    IUserProvider userProvider;
    
    @Override
    public UserModel doLogin(UserModel userModel) {
        UserModel user = userProvider.findByLoginAndPassword(userModel.getMail(), userModel.getPassword());
        
        String token =
                Jwt.issuer("https://example.com/issuer")
                        .upn(user.getMail())
                        .expiresAt(tokenExpireAt())
                        .groups(new HashSet<>(user.getRoles().stream().map(Enum::name).toList()))
                        .claim(Claims.full_name.name(), user.getName())
                        .claim("userId", user.getId())
                        .sign();
        
        user.setToken(token);
        return user;
    }
    
    private Long tokenExpireAt() {
        LocalDateTime dt = LocalDateTime.now().plusDays(30);
        ZonedDateTime zdt = dt.atZone(ZoneId.of("America/Sao_Paulo"));
        return zdt.toInstant().toEpochMilli();
    }
}
