package racing.view;

import java.util.List;
import java.util.Map;

import static racing.util.PrintUtils.*;

public class GameView {
    private static final String REQUEST_CAR_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_TRY_NUM_INPUT = "시도할 회수는 몇회인가요?";
    private static final String PROGRESS_ICON = "-";

    public void printCarNamesInputRequestMessage() {
        System.out.println(REQUEST_CAR_INPUT);
    }

    public void printTriesInputRequestMessage() {
        System.out.println(REQUEST_TRY_NUM_INPUT);
    }

    public void printResult(Map<String, Integer> result) {
        result.forEach((carName, position) -> {
            System.out.println(carName + " : " + getRepeatedString(PROGRESS_ICON, position));
        });
        System.out.println();
    }

    public void printWinner(List<String> winnerNames) {
        System.out.println(String.join(", ", winnerNames) + " 가 최종 우승했습니다.");
    }

    public void printGameStartMessage() {
        System.out.println("실행 결과");

    }
}
