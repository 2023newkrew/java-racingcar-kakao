package racingcar.view;

import java.util.List;

public interface OutputViewMessage {

    String START_MESSAGE = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    String ASK_COUNT_MESSAGE = "시도할 회수는 몇회인가요?";
    String RUN_RESULT_MESSAGE = "\n실행 결과";

    static String getResultMessage(List<String> winnerNames) {
        return String.format("%s%s", String.join(", ", winnerNames), "가 최종 우승했습니다.");
    }
}
