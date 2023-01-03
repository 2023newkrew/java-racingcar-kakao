package racingcar.domain;

import racingcar.dto.CarInfo;
import racingcar.dto.GameInfo;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
    private List<Car> cars;
    private int leftRoundCnt;
    private Movable moveRule;

    public GameInfo init(List<String> names, int roundInput, Movable moveRule) {
        this.cars = names.stream()
                .map(name -> new Car(name))
                .collect(Collectors.toList());
        this.leftRoundCnt = roundInput;
        this.moveRule = moveRule;
        return new GameInfo(cars, leftRoundCnt);
    }

    public GameInfo runRound() {
        for (Car car : cars) {
            car.move(moveRule);
        }
        leftRoundCnt--;
        return new GameInfo(cars, leftRoundCnt);
    }

    public List<CarInfo> findWinners(GameInfo gameInfo) {
        List<CarInfo> carInfos = gameInfo.getCarInfos();
        int maxPosition = getMaxPosition(gameInfo);

        List<CarInfo> winners = carInfos.stream()
                .filter(carInfo -> carInfo.getPosition() == maxPosition)
                .collect(Collectors.toList());

        return winners;
    }

    public int getMaxPosition(GameInfo gameInfo) {
        int maxPosition = 0;
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            maxPosition = Math.max(maxPosition, carInfo.getPosition());
        }
        return maxPosition;
    }

    public int pickRandomNumber() {
        return new Random().nextInt(10);
    }
}
