package com.atrombetone.adapter.out.provider.entity;

import com.atrombetone.application.shared.enums.UserRoleType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

@Entity(name = "tb_user_roles")
public class UserRolesEntity  extends PanacheEntity {
    
    public Long id;
    
    @Column(length = 100)
    @Size(max = 100)
    @Enumerated(EnumType.STRING)
    public UserRoleType user_role;
    
    public Boolean  is_active;
    
    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private UserEntity userEntity;
    
    public UserRolesEntity() {
    
    }
    
    public UserRolesEntity(UserRoleType user_role, Boolean is_active, UserEntity userEntity) {
        this.user_role = user_role;
        this.is_active = is_active;
        this.userEntity = userEntity;
    }
}
