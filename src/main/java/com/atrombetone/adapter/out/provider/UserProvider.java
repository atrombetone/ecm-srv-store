package com.atrombetone.adapter.out.provider;

import com.atrombetone.adapter.out.provider.entity.UserEntity;
import com.atrombetone.application.out.provider.IUserProvider;
import com.atrombetone.application.shared.mappers.UserMapper;
import com.atrombetone.domain.model.UserModel;
import com.atrombetone.infrastructure.exceptions.EntityNotFoundException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class UserProvider implements IUserProvider {
    
    @Inject
    UserMapper mapper;
    
    @Override
    public UserModel findByLoginAndPassword(String login, String password) {
        List<UserEntity> users = UserEntity.findByMailAndPassword(login, password);
        
        if (users == null || users.size() < 1)
            throw new EntityNotFoundException("User not found!");
        
        return mapper.toModel(users.get(0));
    }
}
