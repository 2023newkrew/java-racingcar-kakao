package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Car> cars;
    private int leftRoundCnt;

    public GameInfo init(List<String> names, int roundInput) {
        this.cars = names
                .stream()
                .map(Car::new)
                .collect(Collectors.toList());
        this.leftRoundCnt = roundInput;
        return new GameInfo(cars, leftRoundCnt);
    }

    public GameInfo runRound() {
        for (Car car : cars) {
            car.move();
        }
        leftRoundCnt--;
        return new GameInfo(cars, leftRoundCnt);
    }

    public List<CarInfo> findWinners(GameInfo gameInfo) {
        int maxDistance = 0;
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            maxDistance = Math.max(maxDistance, carInfo.getDistance());
        }
        List<CarInfo> winners = new ArrayList<>();
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            addWinnerByDistance(winners, carInfo, maxDistance);
        }
        return winners;
    }

    private void addWinnerByDistance(List<CarInfo> winners,
                                     CarInfo carInfo,
                                     int distance) {
        if (carInfo.getDistance() == distance) {
            winners.add(carInfo);
        }
    }

    public void run(IOHelper ioHelper) {
        List<String> namesInput = ioHelper.getNamesInput();
        int roundInput = ioHelper.getRoundInput();

        GameInfo gameInfo = init(namesInput, roundInput);
        ioHelper.printInitialStatus(gameInfo);
        while(gameInfo.getLeftRoundCnt()!=0) {
            gameInfo = runRound();
            ioHelper.printRoundResult(gameInfo);
        }

        ioHelper.printGameResult(findWinners(gameInfo));
    }
}
