package com.atrombetone.application.shared.mappers;

import com.atrombetone.adapter.out.provider.entity.UserEntity;
import com.atrombetone.adapter.out.provider.entity.UserRolesEntity;
import com.atrombetone.application.shared.dtos.in.request.UserLoginRequest;
import com.atrombetone.application.shared.dtos.in.response.UserLoginResponse;
import com.atrombetone.application.shared.enums.UserRoleType;
import com.atrombetone.domain.model.UserModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Mapper(componentModel = "cdi")
public interface UserMapper {
    
    @Mapping(source = "roles", target = "roles", qualifiedByName = "mapRoles")
    UserModel toModel(UserEntity entity);
    
    @Named("mapRoles")
    default List<UserRoleType> mapRoles(List<UserRolesEntity> roles) {
        if (roles == null || roles.isEmpty()) {
            return Collections.emptyList();
        }
        return roles.stream()
            .filter(Objects::nonNull)
            .map(r -> r.user_role)
            .filter(Objects::nonNull)
            .collect(Collectors.toList());
    }
    
    UserModel toModel(UserLoginRequest dto);
    
    UserEntity toEntity(UserModel model);
    
    @Mapping(source = "id", target = "userId")
    @Mapping(source = "name", target = "userFullName")
    @Mapping(source = "mail", target = "userMail")
    UserLoginResponse toResponse(UserModel model);
}
