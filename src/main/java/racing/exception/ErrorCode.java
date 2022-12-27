package racing.exception;

public enum ErrorCode {
    EMPTY_CAR_NAME("유효하지 않은 이름 (빈 문자열)"),
    TOO_LONG_CAR_NAME("유효하지 않은 이름 (문자열 길이가 5를 초과)"),
    NEGATIVE_ATTEMPT("시도할 횟수로 음수를 입력할 수 없습니다.");

    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
