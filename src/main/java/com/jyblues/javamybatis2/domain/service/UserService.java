package com.jyblues.javamybatis2.domain.service;


import com.jyblues.javamybatis2.repository.dto.User;

import java.util.List;

public interface UserService {
    int createOne(String name, String password, String email, String phone);

    void deleteOne(long id);

    List<User> getAll();

    User findOneById(long id);

    User findOneByEmail(String email);

    User getCustomOneById(long id, List<String> fields);

    void modifyPassword(long id, String newPassword);
}
