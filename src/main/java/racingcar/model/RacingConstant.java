package racingcar.model;

public class RacingConstant {
    public static final int MAX_ROUND_LIMIT = 99;
    public static final String CAR_NAME_DUPLICATE_EXCEPTION_MSG = "자동차 이름은 유일한 이름이어야 합니다.";
    public static final String MAX_ROUND_OUT_OF_RANGE_EXCEPTION_MSG = "시도 회수는 " + MAX_ROUND_LIMIT + "이하의 숫자여야합니다.";
    public static final String NUMBER_OF_PARTICIPATING_CARS_EXCEPTION_MSG = "경주에는 최소 하나의 자동차가 참가해야 합니다.";
    public static final String ALREADY_CLOSED_RACE_EXCEPTION_MSG = "이미 자동차 경주가 종료되었습니다.";
}
