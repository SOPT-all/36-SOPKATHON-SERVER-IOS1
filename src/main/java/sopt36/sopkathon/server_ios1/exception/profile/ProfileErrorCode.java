package sopt36.sopkathon.server_ios1.exception.profile;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import sopt36.sopkathon.server_ios1.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum ProfileErrorCode implements ErrorCode {

    NOT_FOUND_PROFILE(HttpStatus.NOT_FOUND, "PROFILE_001", "존재하지 않는 프로필입니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
