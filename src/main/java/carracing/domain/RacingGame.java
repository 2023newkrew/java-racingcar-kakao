package carracing.domain;

import java.util.List;

public class RacingGame {
    private final Cars cars;
    private int curTurn = 0;
    private final TurnNumber numberOfTurns;

    public RacingGame(Cars cars, int numberOfTurns) {
        this.cars = cars;
        this.numberOfTurns = new TurnNumber(numberOfTurns);
    }

    public List<Car> getRacingPlayers() {
        return cars.getCarList();
    }

    public void runSingleTurn() {
        cars.moveCars();
        this.curTurn++;
    }

    public List<Car> getWinners() {
        int maxPosition = cars.getMaxPosition();
        return cars.getCarsInPosition(maxPosition);
    }

    public int getCurrentTurn() {
        return this.curTurn;
    }

    public Boolean isFinished() {
        return curTurn == numberOfTurns.getTurnNumber();
    }
}
