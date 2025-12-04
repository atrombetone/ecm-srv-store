package com.atrombetone.adapter.out.provider.entity;

import com.atrombetone.application.shared.enums.GenderType;
import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "tb_users")
@Table(
        name = "tb_users",
        uniqueConstraints = @UniqueConstraint(columnNames = "mail")
)
public class UserEntity extends PanacheEntity {
    public Long id;

    @Column(length = 100)
    @Size(max = 100)
    public String name;

    @Column(length = 100)
    @Size(max = 100)
    public String password;

    @Column(nullable = false, unique = true, length = 250)
    @Size(max = 250)
    public String mail;

    @Column(length = 20)
    @Size(max = 20)
    public String phone;
    
    public LocalDate birthday;
    
    @Column(length = 200)
    @Size(max = 200)
    public String hash_lost_pwd;

    public LocalDateTime hash_expiration;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Size(max = 20)
    public GenderType genderType;
    
    public static List<UserEntity> findByMailAndPassword(String mail, String password) {
        return find("LOWER(mail) = ?1 AND LOWER(password) = ?2", mail, password).list();
    }
}
