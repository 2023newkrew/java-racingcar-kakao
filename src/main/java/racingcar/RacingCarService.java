package racingcar;

import java.util.List;
import java.util.Random;

public class RacingCarService implements Runnable {

    private final InputHandler inputHandler;
    private final Referee referee;
    private final Console console;
    private final Random random = new Random();

    private final int POWER_BOUND = 10;

    public RacingCarService(InputHandler inputHandler, Referee referee,
                            Console console) {
        this.inputHandler = inputHandler;
        this.referee = referee;
        this.console = console;
    }

    @Override
    public void run() {
        console.printMessage("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        List<Car> cars = inputHandler.getCars();
        console.printMessage("시도할 회수는 몇회인가요?");
        int round = inputHandler.getRounds();
        printResult(cars, round);
    }



    private void printResult(List<Car> cars, int count) {
        console.printMessage("실행 결과");
        printRacingStatus(cars);
        for (int i = 0; i < count; i++) {
            moveAllCars(cars);
            printRacingStatus(cars);
            console.printEmptyLine();
        }
        List<String> winners = referee.judgeWinners(cars);
        console.printMessage(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private void printRacingStatus(List<Car> cars) {
        for (Car car : cars) {
            console.printMessage(car.getCurrentStatusString());
        }
    }

    private void moveAllCars(List<Car> cars) {
        for (Car car : cars) {
            car.moveWithPower(random.nextInt(POWER_BOUND));
        }
    }

}
