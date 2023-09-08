package com.jyblues.javamybatis2.users.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Request {
    @Getter
    @Setter
    public static class CreateUser {
        private String name;
        private String email;
        private String password;
        private String phone;

        public String toString() {
            return "name=" + this.name + " email=" + this.email + " phone=" + this.phone + " password=" + this.password;
        }
    }
//
//    @Setter
//    @Getter
//    public static class ModifyUser {
//        private long id;
//        private String name;
//        private String phone;
//    }
//
//    @Setter
//    @Getter
//    public static class modifyPassword {
//        private long id;
//        private String new_password;
//    }
}

