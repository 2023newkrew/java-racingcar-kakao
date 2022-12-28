package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Car> cars;
    private int leftRoundCnt;

    public void run(IOHelper ioHelper) {
        List<String> names = ioHelper.getNamesInput();
        int roundCnt = ioHelper.getRoundInput();

        GameInfo gameInfo = init(names, roundCnt);
        ioHelper.printInitialStatus(gameInfo);

        while (gameInfo.getLeftRoundCnt()!=0) {
            gameInfo = runRound();
            ioHelper.printRoundResult(gameInfo);
        }

        ioHelper.printGameResult(findWinners(gameInfo));
    }

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
        int maxDistance = getMaxDistance(gameInfo.getCarInfos());

        List<CarInfo> winners = gameInfo.getCarInfos()
                .stream()
                .filter(carInfo -> carInfo.getDistance()==maxDistance)
                .collect(Collectors.toList());
        return winners;
    }

    private int getMaxDistance(List<CarInfo> carInfos) {
        int maxDistance = 0;
        for (CarInfo carInfo : carInfos) {
            maxDistance = Math.max(maxDistance, carInfo.getDistance());
        }
        return maxDistance;
    }
}
