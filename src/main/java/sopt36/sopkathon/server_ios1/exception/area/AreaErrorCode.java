package sopt36.sopkathon.server_ios1.exception.area;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import sopt36.sopkathon.server_ios1.exception.ErrorCode;

@Getter
@RequiredArgsConstructor
public enum AreaErrorCode implements ErrorCode {

    NOT_FOUND_AREA_EXCEPTION(HttpStatus.NOT_FOUND, "AREA_001", "존재하지 않는 지역입니다.");

    private final HttpStatus status;
    private final String errorCode;
    private final String message;
}
