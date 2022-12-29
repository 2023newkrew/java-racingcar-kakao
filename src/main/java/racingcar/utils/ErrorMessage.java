package racingcar.utils;

public enum ErrorMessage {
    CAR_NAME_ERROR_MESSAGE("자동차 이름은 5자 이하만 가능합니다.");

    private final String message;

    ErrorMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
