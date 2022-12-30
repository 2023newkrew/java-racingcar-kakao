package racingcar.view;

import static racingcar.view.OutputViewMessage.ASK_COUNT_MESSAGE;
import static racingcar.view.OutputViewMessage.RUN_RESULT_MESSAGE;
import static racingcar.view.OutputViewMessage.START_MESSAGE;
import static racingcar.view.OutputViewMessage.getResultMessage;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.RacingCarGame;

public class OutputView {
    public void printStartMessage() {
        System.out.println(START_MESSAGE);
    }

    public void printAskRunCount() {
        System.out.println(ASK_COUNT_MESSAGE);
    }

    public void printRunResult() {
        System.out.println(RUN_RESULT_MESSAGE);
    }

    public void printEachRunResult(List<String> carResults) {
        carResults.forEach(System.out::println);
        System.out.println();
    }

    public void printFinalResult(List<String> winnerNames) {
        System.out.println(getResultMessage(winnerNames));
    }
}
