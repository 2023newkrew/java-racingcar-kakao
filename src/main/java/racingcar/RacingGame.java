package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> cars;

    public RacingGame() {
        this.cars = new ArrayList<>();
    }
    public RacingGame(List<String> names) {
        this();
        for (String name : names) {
            cars.add(new RacingCar(name));
        }
    }

    public int generateRandomNumber() {
        return (int)(Math.random()*1000) %10;
    }
}
