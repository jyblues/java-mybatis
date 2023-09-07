package com.jyblues.javamybatis2.repository.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String id;
    private String user_id;
    private String user_nm;
    private String password;
    private String access_token;
    private String email;
    private String phone;
    private Timestamp created_at;
    private Timestamp updated_at;
    private Timestamp deleted_at;
}
