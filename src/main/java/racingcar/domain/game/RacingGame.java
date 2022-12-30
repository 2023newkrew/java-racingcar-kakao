package racingcar.domain.game;

import racingcar.domain.car.RacingCar;
import racingcar.domain.power.PowerGeneratable;
import racingcar.domain.power.RandomPowerGenerator;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGame {
    private List<RacingCar> cars;
    private RacingGameTurnInfo turnInfo;

    public RacingGame(List<String> names, int finalTurn) {
        this.cars = names.stream()
                .map(RacingCar::new)
                .collect(Collectors.toList());
        this.turnInfo = new RacingGameTurnInfo(finalTurn);
    }

    public List<RacingCar> getCars() {
        return this.cars;
    }

    public RacingGameTurnInfo getTurnInfo() {
        return this.turnInfo;
    }

    public List<RacingCar> proceedTurn() {
        PowerGeneratable powerGenerator = new RandomPowerGenerator();
        for (RacingCar rc : cars) {
            rc.move(powerGenerator);
        }
        this.turnInfo.increaseTurnCount();
        return this.cars;
    }

    public List<RacingCar> judgeWinners() {
        int maxPos = this.cars.stream()
                .mapToInt(RacingCar::getPos)
                .max()
                .getAsInt();
        List<RacingCar> winners = this.cars.stream()
                .filter(car -> car.getPos() == maxPos)
                .collect(Collectors.toList());
        return winners;
    }

}
