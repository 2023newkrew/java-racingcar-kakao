package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputHandler {

    private final InputParser inputParser = new InputParser();
    private final Scanner scanner = new Scanner(System.in);

    private final int MINIMUM_CARS = 2;


    public List<Car> getCars() {
        String carNamesInput = scanner.nextLine();
        String[] carNames = inputParser.splitByComma(carNamesInput);
        validateCarNames(carNames);
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
        return cars;
    }

    public int getRounds() {
        String roundInput = scanner.nextLine();
        return inputParser.parseToInt(roundInput);
    }

    private void validateCarNames(String[] carNames) {
        if (carNames.length < MINIMUM_CARS) {
            throw new RuntimeException("경주에는 최소 2대 이상의 자동차가 필요합니다.");
        }
    }
}
