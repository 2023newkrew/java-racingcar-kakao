package racingcar.model;

public class CarConstant {
    public static final int MOVE_THRESHOLD = 4;
    public static final int MAX_NAME_LENGTH = 5;
    public static final int MIN_NAME_LENGTH = 1;

    public static final String CAR_NAME_REQUIRED_EXCEPTION_MSG = "자동차는 반드시 이름을 가져야 합니다.";
    public static final String INVALID_CAR_NAME_LENGTH_EXCEPTION_MSG =  "자동차 이름은 " + MIN_NAME_LENGTH + " 이상 " + MAX_NAME_LENGTH + " 이하여야 합니다.";
}
