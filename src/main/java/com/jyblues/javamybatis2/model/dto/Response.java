package com.jyblues.javamybatis2.model.dto;

import com.jyblues.javamybatis2.model.ErrorCode;
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
    public static class Error extends Base {
        private ErrorCode errorCode;
        private String errorMessage;

        public Error(ErrorCode errorCode) {
            super();

            this.errorCode = errorCode;
            this.errorMessage = "";
        }
        public Error(ErrorCode errorCode, String errorMessage) {
            super();

            this.errorCode = errorCode;
            this.errorMessage = errorMessage;
        }
    }

    public static class Ok extends Base {
        private String errorCode;
    }

    public static class User extends Base {
        @Getter
        @Setter
        @NoArgsConstructor
        public static class Info extends Base {
            private long id;
            private String name;
            private String email;
            private String phone;
        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class Created extends Info {

        }

        @Getter
        @Setter
        @NoArgsConstructor
        public static class ModifyPassword extends Ok {

        }
    }


}
