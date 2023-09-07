package com.jyblues.javamybatis2.users.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseProtocol {
    @Getter
    @Setter
    public static class Base {
        public String success;
    }

    @Getter
    @Setter
    public static class User {
        public String id;
        public String user_id;
        public String user_nm;
        public String password;
        public String access_token;
        public String email;
        public String phone;
    }

    public static class CreateUser extends Base {
        public User user;
    }
}
