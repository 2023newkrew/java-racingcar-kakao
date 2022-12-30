package racingcar.domain;

public interface RacingCarExceptionMessage {

    String CAR_NAME_NOT_OR_BLANK_EXCEPTION_MESSAGE = "자동차 이름은 널이거나 공백이 불가능합니다.";
    String CAR_NAME_BOUND_EXCEPTION_MESSAGE = "자동차 이름은 1자이상 5자이하 여야합니다.";
    String MOVE_INPUT_EXCEPTION_MESSAGE = "move함수에는 0 ~ 9 사이의 값이 주어져야 합니다.";
}
