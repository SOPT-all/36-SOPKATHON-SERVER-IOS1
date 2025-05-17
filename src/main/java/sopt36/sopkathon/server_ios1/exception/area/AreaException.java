package sopt36.sopkathon.server_ios1.exception.area;

import sopt36.sopkathon.server_ios1.exception.CustomException;
import sopt36.sopkathon.server_ios1.exception.ErrorCode;

public class AreaException extends CustomException {
    public AreaException(ErrorCode code) {
        super(code);
    }
}
