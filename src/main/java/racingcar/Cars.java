package racingcar;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Cars {

    private final NumberGenerator numberGenerator;
    private final List<Car> cars;

    public Cars(NumberGenerator numberGenerator, List<Car> cars) {
        this.numberGenerator = numberGenerator;
        this.cars = cars;
    }

    public void move() {
        for (Car car : cars) {
            car.move(numberGenerator.generate());
        }
    }

    public List<Car> getWinners() {
        int winnerPosition = getWinnerPosition();

        return cars.stream()
                .filter(car -> isWinner(winnerPosition, car))
                .collect(Collectors.toList());
    }

    private int getWinnerPosition() {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow();
    }

    private boolean isWinner(int winnerPosition, Car car) {
        return car.getPosition() == winnerPosition;
    }

    public Result getResult() {
        Map<String, Integer> positions = cars.stream()
                .collect(Collectors.toMap(Car::getName, Car::getPosition));
        return new Result(positions);
    }
}
