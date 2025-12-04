package com.atrombetone.application.out.provider;

import com.atrombetone.domain.model.UserModel;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public interface IUserProvider {
    
    UserModel findByLoginAndPassword(String login, String password);
}
