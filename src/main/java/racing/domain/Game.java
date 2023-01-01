package racing.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private final Cars cars;


    public Game(Cars cars) {
        this.cars = cars;
    }

    public Game(String[] carNames){
        this.cars = new Cars(
                Arrays.stream(carNames)
                        .map(RacingCar::new)
                        .collect(Collectors.toList())
        );
    }

    public void play() {
        cars.play();
    }

    public List<String> getWinnerNames() {
        return cars.getCarsWithSamePosition(cars.getMaxPosition())
                .stream()
                .map(Car::getName)
                .collect(Collectors.toList());
    }


    public List<ImmutableCar> getCars() {
        return cars.getCars();
    }
}
