package racingcar.view;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.RacingResult;
import racingcar.model.RoundResult;

public class OutputView {

    public static final String PROGRESS_BAR_ELEM = "-";
    public static final String WINNER_NAME_DELIMITER = ", ";
    private final PrintStream printStream;

    public OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printRacingResult(RacingResult racingResult) {
        printExecuteResultMessage();
        printRoundResults(racingResult.getRoundResults());
        printWinners(racingResult.getWinnerCars());
    }

    public void printExecuteResultMessage() {
        printStream.println();
        printStream.println("실행 결과");
    }

    public void printRoundResults(List<RoundResult> roundResults) {
        for (RoundResult roundResult : roundResults) {
            printRoundResult(roundResult);
            printStream.println();
        }
    }

    private void printRoundResult(RoundResult roundResult) {
        for (Car racingCar : roundResult.getRacingCars()){
            String progressBar = progressBar(racingCar.getPosition());
            printStream.printf("%s : %s", racingCar.getName(), progressBar);
            printStream.println();
        }
    }

    private String progressBar(int position) {
        return PROGRESS_BAR_ELEM.repeat(position);
    }

    public void printWinners(List<Car> winners) {
        String winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));

        printStream.printf("%s가 최종 우승했습니다.", winnersName);
    }
}
