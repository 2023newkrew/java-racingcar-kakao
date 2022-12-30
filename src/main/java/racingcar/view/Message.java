package racingcar.view;

public enum Message {

    NAME_INPUT_MESSAGE("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    ROUND_INPUT_MESSAGE("시도할 회수는 몇회인가요?"),
    IS_WINNER_MESSAGE("가 최종 우승했습니다."),
    WRONG_NAME("잘못된 이름입니다!")
    ;

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
