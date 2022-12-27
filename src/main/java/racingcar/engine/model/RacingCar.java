package racingcar.engine.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import racingcar.Console;

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
        List<Car> cars = getCars();
        int count = getCount();
        showOutput(cars, count);
    }

    private List<Car> getCars() {
        Optional<List<Car>> result = getCarsSafely();
        while(result.isEmpty()) {
            result = getCarsSafely();
        }
        return result.get();
    }

    private Optional<List<Car>> getCarsSafely() {
        try {
            return Optional.of(getCarsLogic());
        } catch(RuntimeException e) {
            console.printError(e.getMessage());
            return Optional.empty();
        }
    }

    private List<Car> getCarsLogic() {
        String input = console.input("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).");
        String[] carNames = inputParser.splitByComma(input);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    private int getCount() {
        Optional<Integer> result = getCountSafely();
        while(result.isEmpty()) {
            result = getCountSafely();
        }
        return result.get();
    }

    private Optional<Integer> getCountSafely() {
        try {
            return Optional.of(getCountLogic());
        } catch (RuntimeException e) {
            console.printError(e.getMessage());
            return Optional.empty();
        }
    }

    private int getCountLogic() {
        String countInput = console.input("시도할 회수는 몇회인가요?");
        return inputParser.parseToInt(countInput);
    }

    private void showOutput(List<Car> cars, int count) {
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
