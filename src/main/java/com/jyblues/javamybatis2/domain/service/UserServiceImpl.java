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

    @Override
    public int createOne(String name, String password, String email, String phone) {
        return userMapper.createOne(name, password, email, phone);
    }

    @Override
    public void deleteOne(long id) {
        userMapper.deleteOne(id);
    }

    @Override
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User findOneById(long id) {
        return userMapper.findOneById(id);
    }

    public User findOneByEmail(String email) {
        return userMapper.findOneByEmail(email);
    }

    @Override
    public User getCustomOneById(long id, List<String> fields) {
        return userMapper.getCustomOneById(id, fields);
    }

    @Override
    public User getCustomOneByEmail(String email, List<String> fields) {
        return userMapper.getCustomOneByEmail(email, fields);
    }


    @Override
    public void modifyPassword(long id, String newPassword) {
        userMapper.modifyPassword(id, newPassword);
    }
}
