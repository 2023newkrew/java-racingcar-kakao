package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameRunner {
    private final int numberOfGames;
    private final List<Car> carList;
    public RacingGameRunner(final String carNames, final int numberOfGames) {
        this.numberOfGames = numberOfGames;
        this.carList = registerCars(carNames);
    }

    private List<Car> registerCars(final String carNames){
        InputParser inputParser = new InputParser();
        List<String> splitCarNames = inputParser.splitNames(carNames);

        return splitCarNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void run() {
        for (int i = 0; i < numberOfGames; i++) {
            move();
            printCars();
            System.out.println();
        }
        printWinners();
    }
    public void move() {
        for (Car car: carList){
            car.move();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void printCars() {
        for (Car car : carList) {
            car.print();
        }
    }

    public void printWinners() {
        List<Car> winners = pickWinners();

        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    private List<Car> pickWinners() {
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
