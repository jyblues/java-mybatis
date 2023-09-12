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
    public List<User> getAll() {
        return userMapper.getAll();
    }

    @Override
    public User findOneById(String id) {
        return userMapper.findOneById(id);
    }

    @Override
    public User getCustomOneById(List<String> customFields) {
        return userMapper.getCustomOneById(customFields);
    }

    @Override
    public void modifyPassword(long id, String newPassword)
    {
        userMapper.modifyPassword(id, newPassword);
    }
}
