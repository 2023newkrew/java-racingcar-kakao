package racingcar.view;

import racingcar.domain.Car;

import java.io.PrintStream;

public class PrintViewKorean implements PrintView {

    private final PrintStream printStream;

    public PrintViewKorean(PrintStream printStream){
        this.printStream = printStream;
    }
    @Override
    public void printStart() {
        printStream.println("실행 결과");
    }

    @Override
    public void printCars(Car[] cars) {
        for (Car car:cars){
            printStream.println(car);
        }
        printStream.println();
    }

    @Override
    public void printWinners(Car[] winners) {
        printStream.println(joinWinners(winners) + "가 최종 우승했습니다.");
    }
    private String joinWinners(Car[] winners) {
        String[] result = new String[winners.length];
        for (int i = 0; i < winners.length; i++) {
            result[i] = winners[i].toStringOnlyName();
        }
        return String.join(", ", result);
    }

}
