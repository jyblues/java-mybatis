package com.jyblues.javamybatis2.domain.service;

import com.jyblues.javamybatis2.repository.dto.User;
import com.jyblues.javamybatis2.repository.dto.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public int createAnUser(String name, String password, String email, String phone) {
        return userMapper.createAnUser(name, password, email, phone);
    }

    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public User findUserById(String id) {
        return userMapper.findUserById(id);
    }
}
