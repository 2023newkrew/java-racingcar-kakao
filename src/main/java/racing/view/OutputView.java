package racing.view;

import java.util.List;
import java.util.stream.Collectors;
import racing.domain.CarName;
import racing.dto.CarDTO;

public class OutputView {
    private boolean isFirstCall = true;
    private static final String RESULT_MESSAGE = "실행 결과";
    private static final String MOVING_SYMBOL = "-";
    private static final String STATUS_STRING_FORMAT = "%s : %s";
    private static final String WINNER_DELIMITER = ", ";
    private static final String WINNER_MESSAGE_FORMAT = "%s가 최종 우승했습니다.";

    public void printResult(final List<CarDTO> status) {
        if (isFirstCall) {
            System.out.println(RESULT_MESSAGE);
            isFirstCall = false;
        }
        status.forEach(this::printSingleResult);
        System.out.println();
    }

    public void printSingleResult(final CarDTO carDTO) {
        String singleResult = String.format(STATUS_STRING_FORMAT,
                carDTO.getName().toString(),
                MOVING_SYMBOL.repeat(carDTO.getDistance()));
        System.out.println(singleResult);
    }

    public void printWinners(final List<CarName> winners) {
        List<String> winnerNames = winners.stream()
                .map(CarName::toString)
                .collect(Collectors.toList());
        String winnersString = String.join(WINNER_DELIMITER, winnerNames);
        System.out.printf(WINNER_MESSAGE_FORMAT, winnersString);
    }
}
