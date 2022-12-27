package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> cars;
    private int finalTurn;
    private int turnCount;

    public int getTurnCount() {
        return this.turnCount;
    }

    public RacingGame() {
        this.cars = new ArrayList<>();
    }
    public RacingGame(List<String> names, int finalTurn) {
        this();
        for (String name : names) {
            cars.add(new RacingCar(name));
        }
    }

    public int generateRandomNumber() {
        return (int)(Math.random()*1000) %10;
    }

    public void proceedTurn() {
        for(RacingCar rc : cars) {
            rc.accelerate(this.generateRandomNumber());
        }
        this.turnCount++;
    }
}
