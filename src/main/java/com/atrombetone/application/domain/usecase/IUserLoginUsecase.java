package com.atrombetone.application.domain.usecase;

import com.atrombetone.domain.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IUserLoginUsecase {
    
    UserModel doLogin(UserModel userModel);
}
