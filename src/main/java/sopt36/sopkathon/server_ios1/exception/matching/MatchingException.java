package sopt36.sopkathon.server_ios1.exception.matching;

import sopt36.sopkathon.server_ios1.exception.CustomException;
import sopt36.sopkathon.server_ios1.exception.ErrorCode;

public class MatchingException extends CustomException {
    public MatchingException(ErrorCode code) {
        super(code);
    }
}
