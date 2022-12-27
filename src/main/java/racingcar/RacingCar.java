package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class RacingCar implements Runnable {

    private final InputParser inputParser;

    private final RandomNumberGenerator randomNumberGenerator;

    private final Referee referee;

    private final Console console;

    public RacingCar(InputParser inputParser, RandomNumberGenerator randomNumberGenerator, Referee referee,
                     Console console) {
        this.inputParser = inputParser;
        this.randomNumberGenerator = randomNumberGenerator;
        this.referee = referee;
        this.console = console;
    }

    @Override
    public void run() {
        String input = console.input("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = inputParser.splitByComma(input);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        String countInput = console.input("시도할 회수는 몇회인가요?");
        int count = inputParser.parseToInt(countInput);
        console.printOutput(Integer.toString(count));
        console.printOutput("실행 결과");
        printCurrentStatus(cars);
        for (int i = 0; i < count; i++) {
            moveAllCars(cars);
            printCurrentStatus(cars);
        }
        List<String> winners = referee.judgeWinner(cars);
        console.printOutput(String.join(", ", winners) + "가 최종 우승했습니다.");
    }

    private void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            console.printOutput(car.getCurrentStatus());
        }
    }

    private void moveAllCars(List<Car> cars) {
        for (Car car : cars) {
            car.moveWithPower(randomNumberGenerator.generateRandomNumber());
        }
    }
}
