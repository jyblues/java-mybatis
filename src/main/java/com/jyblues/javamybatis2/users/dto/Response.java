package com.jyblues.javamybatis2.users.dto;

import lombok.*;

@Getter
@Setter
public class Response {
    @Getter
    @Setter
    @NoArgsConstructor
    public static class Base {
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Error extends Base{
        private String errorCode;
        private String errorMessage;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class User extends Base {
        private long id;
        private String name;
        private String email;
        private String phone;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    public static class CreateUser extends User {

    }

}
