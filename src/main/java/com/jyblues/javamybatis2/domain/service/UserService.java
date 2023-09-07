package com.jyblues.javamybatis2.domain.service;


import com.jyblues.javamybatis2.repository.dto.User;

import java.util.List;

public interface UserService {
    public List<User> getUsers();
    public User findUserById(String id);
}
