package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<RacingCar> cars;
    private int finalTurn;
    private int turnCount;

    public List<RacingCar> getCars() {
        return this.cars;
    }

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
        this.finalTurn = finalTurn;
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

    public void playGame() {
        while(this.turnCount<this.finalTurn) {
            this.proceedTurn();
        }
    }

    public List<RacingCar> judgeWinners() {
        int maxPos = -1;

        for(RacingCar rc : this.cars) {
            maxPos = Math.max(maxPos,rc.getPos());
        }
        List<RacingCar> winners = new ArrayList<>();
        for(RacingCar rc : this.cars) {
            appendWinner(winners, rc, maxPos);
        }
        return winners;
    }

    public void appendWinner(List<RacingCar> winners, RacingCar racingCar, int maxPos) {
        if(racingCar.getPos()==maxPos) {
            winners.add(racingCar);
        }
    }
}
