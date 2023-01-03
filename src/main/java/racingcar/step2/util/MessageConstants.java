package racingcar.step2.util;

public class MessageConstants {
    public static final String MSG_INPUT_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    public static final String MSG_INPUT_TURN = "시도할 횟수는 몇 회인가요?";
    public static final String MSG_PRINT_HEADER = "\n실행 결과";
    public static final String MSG_TURN_RESULT_FORMAT = "%s : %s";
    public static final String MSG_FINAL_RESULT_FORMAT = "%s(이)가 최종 우승했습니다.\n";

    public static final String ERR_NAME_DOESNT_EXISTS = "자동차는 이름이 존재해야 합니다.";
    public static final String ERR_NAME_OVER_FIVE_LETTERS = "5글자 이하의 이름만 가능합니다.";
    public static final String ERR_NAME_DUPLICATED = "자동차 이름은 중복될 수 없습니다.";
}
