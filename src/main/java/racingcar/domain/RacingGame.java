package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<RacingCar> cars;
    private final int finalTurn;
    private int turnCount;

    public List<RacingCar> getCars() {
        return this.cars;
    }

    public int getTurnCount() {
        return this.turnCount;
    }


    public RacingGame(List<String> names, int finalTurn) {
        this.cars = names.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
        this.finalTurn = finalTurn;
    }


    public boolean isFinished() {
        return this.turnCount >= this.finalTurn;
    }

    public int generateRandomNumber() {
        return (int)(Math.random()*1000) %10;
    }

    public List<RacingCar> proceedTurn() {
        for(RacingCar rc : cars) {
            rc.accelerate(generateRandomNumber());
        }
        this.turnCount++;
        return this.cars;
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
