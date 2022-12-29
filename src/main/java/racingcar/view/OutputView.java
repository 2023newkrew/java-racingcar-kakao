package racingcar.view;

import java.io.PrintStream;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;
import racingcar.model.Positions;

public class OutputView {

    private final PrintStream printStream;

    public OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void printExecuteResultMessage() {
        printStream.println();
        printStream.println("실행 결과");
    }

    public void printPositions(Positions positions) {
        for (String name : positions.getNames()) {
            String progressBar = progressBar(positions, name);
            printStream.println(name + " : " + progressBar);
        }
        printStream.println();
    }

    private String progressBar(Positions positions, String name) {
        return "-".repeat(positions.getPositionByName(name));
    }

    public void printWinners(List<Car> winners) {
        String winnersName = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        printStream.println(winnersName + "가 최종 우승했습니다.");
    }
}
