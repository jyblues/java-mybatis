package com.jyblues.javamybatis2.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Request {

    public static class User {
        @Getter
        @Setter
        public static class SignUp {
            private String name;
            private String email;
            private String password;
            private String phone;

            public String toString() {
                return "name=" + this.name + " email=" + this.email + " phone=" + this.phone + " password=" + this.password;
            }
        }
        
        @Getter
        @Setter
        public static class SignIn {
            private String email;
            private String password;
        }

        @Setter
        @Getter
        public static class ModifyProfile {
            private long id;
            private String name;
            private String phone;
        }

        @Setter
        @Getter
        public static class CheckPassword {
            private long id;
            private String password;
        }

        @Setter
        @Getter
        public static class ModifyPassword {
            private long id;
            private String new_password;
        }
    }
}

