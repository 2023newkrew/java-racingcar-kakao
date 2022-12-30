package racingcar.domain;

import java.util.List;

public class Racing {

    private final List<Car> cars;
    private int turn;
    private final RacingService racingService;
    private final MovingStrategy movingStrategy;

    public Racing(List<Car> cars, int turn) {
        this(cars, turn, new RandomMovingStrategy());
    }

    public Racing(List<Car> cars, int turn, MovingStrategy movingStrategy) {
        this.cars = cars;
        this.turn = turn;
        racingService = new RacingService();
        this.movingStrategy = movingStrategy;
    }

    public List<Car> getWinners() {
        return racingService.getWinners(cars);
    }

    private void decreaseTurn() {
        this.turn--;
    }

    public void proceedTurn() {
        this.cars.forEach(car -> car.move(movingStrategy));
        decreaseTurn();
    }

    public boolean isRacing() {
        return this.turn > 0;
    }

    public List<Car> getRaceStatus() {
        return this.cars;
    }
}
