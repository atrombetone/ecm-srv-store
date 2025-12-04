package com.atrombetone.application.shared.mappers;

import com.atrombetone.adapter.out.provider.entity.UserEntity;
import com.atrombetone.application.shared.dtos.in.request.UserLoginRequest;
import com.atrombetone.application.shared.dtos.in.response.UserLoginResponse;
import com.atrombetone.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    UserModel toModel(UserEntity entity);
    
    UserModel toModel(UserLoginRequest dto);
    
    UserEntity toEntity(UserModel model);
    
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name", target = "userFullName")
    @Mapping(source = "mail", target = "userMail")
    UserLoginResponse toResponse(UserModel model);
}
