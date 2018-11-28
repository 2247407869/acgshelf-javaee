package com.lls.springboot.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
public class User {
    @Id
    private Long id;
    private String username;
    private String email;
    private String avatar;
    private String roles;
    private String password;
}
