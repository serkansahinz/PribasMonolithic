package com.pribas.pribasmonolithic.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public enum ErrorType {

    INTERNAL_ERROR_SERVER(5100,"Server Error",HttpStatus.INTERNAL_SERVER_ERROR),
    BAD_REQUEST(4100,"Parameter Error",HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(4110, "No such user",HttpStatus.NOT_FOUND),
    ACCOUNT_NOT_ACTIVE(4111, "Account is not active",HttpStatus.BAD_REQUEST),
    INVALID_CODE(4112, "Invalid code",HttpStatus.BAD_REQUEST),
    ALREADY_ACTIVE(4113, "Already active account",HttpStatus.BAD_REQUEST),
    UNEXPECTED_ERROR(4114,"Unexpected error",HttpStatus.BAD_REQUEST),
    USERNAME_ALREADY_EXIST(4115,"Username already exist !!!",HttpStatus.BAD_REQUEST),
    DATA_INTEGRITY(4116, "wrong data",HttpStatus.BAD_REQUEST),
    LOGIN_ERROR(4117, "Wrong username or password !!!",HttpStatus.BAD_REQUEST),
    INVALID_TOKEN(4118, "Invalid Token !!!",HttpStatus.BAD_REQUEST),
    TOKEN_NOT_CREATED(4119, "Token cannot be created !!!",HttpStatus.BAD_REQUEST),


    ;


    private int code;
    private String message;
    HttpStatus httpStatus;


}
