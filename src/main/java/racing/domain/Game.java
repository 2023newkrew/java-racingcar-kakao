package racing.domain;

import java.util.ArrayList;
import java.util.List;
import racing.utils.RandomNumberGenerator;

public class Game {
    private static final String INPUT_GAME_TURN_RANGE_EXCEPTION_MESSAGE = "[ERROR] 반복 횟수는 양수여야 합니다.";
    private final Cars cars;
    private final RandomNumberGenerator generator;
    private int gameTurn;

    public Game(String carNames, int gameTurn) {
        this.cars = new Cars(carNames);
        validatePositive(gameTurn);
        this.gameTurn = gameTurn;
        this.generator = new RandomNumberGenerator();
    }
    private void validatePositive(int value) {
        if (value <= 0) {
            throw new IllegalArgumentException(INPUT_GAME_TURN_RANGE_EXCEPTION_MESSAGE);
        }
    }

    public void play() {
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0; i < cars.size(); i++) {
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
