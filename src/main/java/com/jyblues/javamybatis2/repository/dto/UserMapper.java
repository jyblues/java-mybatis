package com.jyblues.javamybatis2.repository.dto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
    int createOne(String name, String password, String email, String phone);

    List<User> getAll();

    User findOneById(String id);

    User getCustomOneById(List<String> customFields);

    void modifyPassword(long id, String newPassword);
}