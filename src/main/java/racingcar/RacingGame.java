package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private int finalTurn;
    private int turnCount;
    private IOView ioView;

    public List<Car> getCars() {
        return this.cars;
    }

    public int getTurnCount() {
        return this.turnCount;
    }

    public RacingGame() {
        this.cars = new ArrayList<>();
        this.ioView = new IOView();
    }
    public RacingGame(List<String> names, int finalTurn) {
        this();
        for (String name : names) {
            cars.add(new Car(name));
        }
        this.finalTurn = finalTurn;
    }

    public int generateRandomNumber() {
        return (int)(Math.random()*1000) %10;
    }

    public void proceedTurn() {
        for(Car rc : cars) {
            rc.accelerate(this.generateRandomNumber());
        }
        this.turnCount++;
        ioView.printTurnResult(this.cars);
    }

    public void playGame() {
        ioView.printGameResultMessage();
        while(this.turnCount<this.finalTurn) {
            this.proceedTurn();
        }
        ioView.printWinners(judgeWinners());
    }

    public List<Car> judgeWinners() {
        int maxPos = -1;

        for(Car rc : this.cars) {
            maxPos = Math.max(maxPos,rc.getPosition());
        }
        List<Car> winners = new ArrayList<>();
        for(Car rc : this.cars) {
            appendWinner(winners, rc, maxPos);
        }
        return winners;
    }

    public void appendWinner(List<Car> winners, Car racingCar, int maxPos) {
        if(racingCar.getPosition()==maxPos) {
            winners.add(racingCar);
        }
    }
}
