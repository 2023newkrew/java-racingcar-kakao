package racing.service;

import racing.exception.RacingException;
import racing.exception.ErrorCode;

public class RacingValidator {
    public void carNameValidate(String carName){
        if(carName.isBlank()) throw new RacingException(ErrorCode.EMPTY_CAR_NAME);
        if(carName.length() > 5) throw new RacingException(ErrorCode.TOO_LONG_CAR_NAME);
    }

    public void attemptValidate(Integer attempt){
        if(attempt < 0) throw new RacingException(ErrorCode.NEGATIVE_ATTEMPT);
    }
}
