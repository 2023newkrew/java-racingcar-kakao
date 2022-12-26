package racing.service;

import racing.exception.CarNameInvalidException;
import racing.exception.ErrorCode;

public class RacingValidator {
    public void carNameValidate(String carName){
        if(carName.isBlank()) throw new CarNameInvalidException(ErrorCode.EMPTY_CAR_NAME);
        if(carName.length() > 5) throw new CarNameInvalidException(ErrorCode.TOO_LONG_CAR_NAME);
    }
}
