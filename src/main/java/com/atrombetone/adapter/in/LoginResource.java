package com.atrombetone.adapter.in;

import com.atrombetone.application.domain.usecase.IUserLoginUsecase;
import com.atrombetone.application.shared.dtos.in.request.UserLoginRequest;
import com.atrombetone.application.shared.dtos.in.response.UserLoginResponse;
import com.atrombetone.application.shared.mappers.UserMapper;
import com.atrombetone.domain.model.UserModel;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/login")
public class LoginResource {
    
    @Inject
    UserMapper userMapper;
    
    @Inject
    IUserLoginUsecase userLoginUsecase;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @PermitAll
    @Path("/login")
    public UserLoginResponse doLogin(UserLoginRequest request) throws Exception {
        UserModel userModel = userMapper.toModel(request);
        return userMapper.toResponse(userLoginUsecase.doLogin(userModel));
    }
}
