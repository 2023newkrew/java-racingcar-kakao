package racing.exception;

public enum ErrorCode {
    EMPTY_CAR_NAME("유효하지 않은 이름 (빈 문자열)"),
    TOO_LONG_CAR_NAME("유효하지 않은 이름 (문자열 길이가 5를 초과)");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
