package racingcar.exception;

public enum ErrorCode {

    EMPTY_CAR_NAME_EXCEPTION("자동차 이름이 비어있습니다."),
    TOO_LONG_CAR_NAME_EXCEPTION("자동차 이름은 5자 이하여야 합니다."),
    EMPTY_CAR_LIST_EXCEPTION("최소한 1개 이상의 자동차가 포함되어야 합니다."),
    DUPLICATE_CAR_NAME_EXCEPTION("중복된 이름의 자동차가 존재합니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
