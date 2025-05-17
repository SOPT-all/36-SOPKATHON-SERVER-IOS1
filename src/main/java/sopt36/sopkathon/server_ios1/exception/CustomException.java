package sopt36.sopkathon.server_ios1.exception;

import lombok.Getter;

@Getter
public abstract class CustomException extends RuntimeException{
    private final ErrorCode code;

    public CustomException(ErrorCode code) {
        super(code.getMessage());
        this.code = code;
    }
}
