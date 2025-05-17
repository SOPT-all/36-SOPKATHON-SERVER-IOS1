package sopt36.sopkathon.server_ios1.dto.global;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import sopt36.sopkathon.server_ios1.exception.ErrorCode;

@Getter
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"statusCode","errorCode", "message", "data"})
public class ResponseDto<T> {
    private final int statusCode;
    private final String errorCode;
    private final String message;
    private T data;

    public static <T> ResponseDto<T> success(final String message, final T data) {
        return new ResponseDto<>(HttpStatus.OK.value(), null, message, data);
    }

    public static <T> ResponseDto<T> created(final String message, final T data) {
        return new ResponseDto<>(HttpStatus.CREATED.value(), null, message, data);
    }

    public static <T> ResponseDto<T> fail(ErrorCode code) {
        return new ResponseDto<>(
                code.getStatus().value(),
                code.getErrorCode(),
                code.getMessage(),
                null
        );
    }

    public static <T> ResponseDto<T> fail(ErrorCode code, String message) {
        return new ResponseDto<>(
                code.getStatus().value(),
                code.getErrorCode(),
                message,
                null
        );
    }
}
