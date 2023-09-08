package com.jyblues.javamybatis2.domain.service;


import com.jyblues.javamybatis2.repository.dto.User;

import java.util.List;

public interface UserService {
    int createAnUser(String name, String password, String email, String phone);

    List<User> getUsers();

    User findUserById(String id);
}
