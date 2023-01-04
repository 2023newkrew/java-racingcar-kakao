package racingcar.domain;

import java.util.List;

public class Racing {

    private final Cars cars;
    private int turn;
    private final MovingStrategy movingStrategy;

    public Racing(List<Car> cars, int turn) {
        this(cars, turn, new RandomMovingStrategy());
    }

    public Racing(List<Car> cars, int turn, MovingStrategy movingStrategy) {
        if (turn <= 0) {
            throw new IllegalArgumentException("turn은 양수이어야 합니다.");
        }
        this.cars = new Cars(cars);
        this.turn = turn;
        this.movingStrategy = movingStrategy;
    }

    public List<Car> getWinners() {
        return this.cars.findWinners();
    }

    private void decreaseTurn() {
        this.turn--;
    }

    public void proceedTurn() {
        this.cars.moveAll(movingStrategy);
        decreaseTurn();
    }

    public boolean isRacing() {
        return this.turn > 0;
    }

    public List<Car> getRaceStatus() {
        return cars.getList();
    }
}
