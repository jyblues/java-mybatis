package com.jyblues.javamybatis2.domain.service;


import com.jyblues.javamybatis2.repository.dto.User;

import java.util.List;

public interface UserService {
    int createOne(String name, String password, String email, String phone);

    List<User> getAll();

    User findOneById(String id);

    User getCustomOneById(List<String> customFields);

    void modifyPassword(long id, String newPassword);
}
