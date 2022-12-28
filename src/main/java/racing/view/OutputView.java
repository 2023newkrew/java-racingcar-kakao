package racing.view;

import java.util.List;

public class OutputView {
    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";

    public void printResult(List<String> status) {
        status.forEach(System.out::println);
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        String winnerString = String.join(WINNER_DELIMITER, winners);
        System.out.printf(WINNER_MESSAGE_FORMAT, winnerString);
    }
}
