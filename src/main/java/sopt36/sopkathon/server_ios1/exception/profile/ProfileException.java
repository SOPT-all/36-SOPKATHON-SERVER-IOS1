package sopt36.sopkathon.server_ios1.exception.profile;

import sopt36.sopkathon.server_ios1.exception.CustomException;
import sopt36.sopkathon.server_ios1.exception.ErrorCode;

public class ProfileException extends CustomException {
    public ProfileException(ErrorCode code) {
        super(code);
    }
}
