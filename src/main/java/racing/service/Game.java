package racing.service;

import java.util.ArrayList;
import java.util.List;
import racing.domain.Cars;
import racing.utils.RandomNumberGenerator;

public class Game {
    private final Cars cars;
    private final int length;
    private final RandomNumberGenerator generator;
    private int gameTurn;

    public Game(String carNames, int gameTurn) {
        this.cars = new Cars(carNames);
        this.gameTurn = gameTurn;
        this.length = carNames.split(",").length;
        this.generator = new RandomNumberGenerator();
    }

    public void play() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            randomNumbers.add(generator.generate());
        }
        cars.play(randomNumbers);
        gameTurn--;
    }

    public boolean isEnd() {
        return gameTurn == 0;
    }


    public List<String> getStatus() {
        return cars.getStatus();
    }

    public List<String> getWinners() {
        return cars.getWinners();
    }


}
