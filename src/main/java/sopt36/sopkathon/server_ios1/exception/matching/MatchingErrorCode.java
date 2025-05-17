package sopt36.sopkathon.server_ios1.exception.matching;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import sopt36.sopkathon.server_ios1.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum MatchingErrorCode implements ErrorCode {
    NOT_FOUND_MATCHING_USER(HttpStatus.NOT_FOUND, "MATCHING_001", "존재하지 않는 매칭 사용자입니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
