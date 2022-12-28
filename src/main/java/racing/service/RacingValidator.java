package racing.service;

import racing.exception.RacingException;
import racing.exception.ErrorCode;

public class RacingValidator {
    public void attemptValidate(Integer attempt){
        if(attempt < 0) throw new RacingException(ErrorCode.NEGATIVE_ATTEMPT);
    }
}
