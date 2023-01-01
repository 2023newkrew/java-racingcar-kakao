package racingcar;

import java.util.List;

public class RacingCarService implements Runnable {

    private final InputView inputView;
    private final Referee referee;
    private final OutputView outputView;
    private final MovingStrategy movingStrategy;


    public RacingCarService(InputView inputView, Referee referee,
                            OutputView outputView, MovingStrategy movingStrategy) {
        this.inputView = inputView;
        this.referee = referee;
        this.outputView = outputView;
        this.movingStrategy = movingStrategy;
    }

    @Override
    public void run() {
        List<Car> cars = inputView.getCars();
        int round = inputView.getRounds();
        printResult(cars, round);
    }



    private void printResult(List<Car> cars, int count) {
        outputView.printMessage("실행 결과");
        printRacingStatus(cars);
        for (int i = 0; i < count; i++) {
            moveAllCars(cars);
            printRacingStatus(cars);
            outputView.printEmptyLine();
        }
        List<String> winners = referee.judgeWinners(cars);
        outputView.printMessage(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            outputView.printMessage(car.getCurrentStatus());
        }
    }

    private void moveAllCars(List<Car> cars) {
        for (Car car : cars) {
            car.move(movingStrategy);
        }
    }

}
