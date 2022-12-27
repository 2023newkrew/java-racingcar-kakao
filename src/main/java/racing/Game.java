package racing;

import java.util.Arrays;
import java.util.List;

public class Game {
    private Cars cars;

    public Game() {
        this.cars = new Cars();
    }

    public Game(Cars cars) {
        this.cars = cars;
    }

    public void initialize(String input) {
        String[] carNames = input.split(",");
        Arrays.stream(carNames)
            .forEach(carName -> {
                cars.add(new Car(carName));
        });
    }

    public List<Car> decideWinner() {
        return cars.getCarsWithSamePosition(cars.getMaxPosition());
    }
}
