package com.atrombetone.domain.usecase;

import com.atrombetone.application.domain.usecase.IUserLoginUsecase;
import com.atrombetone.application.out.provider.IUserProvider;
import com.atrombetone.domain.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class UserLoginUsecase implements IUserLoginUsecase {
    
    @Inject
    IUserProvider userProvider;
    
    @Override
    public UserModel doLogin(UserModel userModel) {
        UserModel user = userProvider.findByLoginAndPassword(userModel.getMail(), userModel.getPassword());
        user.setToken("Future implementation");
        return user;
    }
}
