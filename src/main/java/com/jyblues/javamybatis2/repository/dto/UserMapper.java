package com.jyblues.javamybatis2.repository.dto;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {
//    @Select("select * from users")
    List<User> getUsers();

    User findUserById(String id);
}