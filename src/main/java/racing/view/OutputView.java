package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.CarName;

public class OutputView {
    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";

    public void printResult(final List<String> status) {
        status.forEach(System.out::println);
        System.out.println();
    }

    public void printWinner(final List<CarName> winners) {
        List<String> winnerNames = winners.stream()
                .map(CarName::getName)
                .collect(Collectors.toList());
        String winnerString = String.join(WINNER_DELIMITER, winnerNames);
        System.out.printf(WINNER_MESSAGE_FORMAT, winnerString);
    }
}
