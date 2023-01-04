package racingcar.exception;

public enum RacingExceptionCode {
    INVALID_CARS_SIZE("경주에 참여할 자동차는 2대 이상이어야 합니다."),
    INVALID_CAR_LENGTH("자동차 이름의 길이는 5글자 이하여야 합니다"),
    CAR_NAME_DUPLICATION("자동차 이름에 중복이 있습니다."),
    INVALID_TRIAL_NUMBER("시도 횟수는 1회 이상이여야합니다."),
    TRIAL_NOT_NUMBER("시도 횟수를 숫자로 입력해야 합니다."),
    ALREADY_RACING_END("이미 레이싱이 종료됐습니다."),
    RACING_NOT_STARTED("레이싱이 아직 시작되지 않았습니다!"),
    INVALID_RACING_ARGUMENT("레이싱 구성에 필요한 값이 입력되지 않았습니다.");

    private final String errorMessage;

    RacingExceptionCode(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
