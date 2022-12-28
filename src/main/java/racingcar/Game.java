package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Car> cars;
    private int leftRoundCnt;

    public GameInfo init(List<String> names, int roundInput) {
        this.cars = names.stream()
                .map(name -> new Car(name))
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
        List<CarInfo> winners = new ArrayList<>();
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            addWinnerByPosition(winners, carInfo, getMaxPosition(gameInfo));
        }
        return winners;
    }

    private void addWinnerByPosition(List<CarInfo> winners,
                                     CarInfo carInfo,
                                     int maxPosition) {
        if (carInfo.getPosition() == maxPosition) {
            winners.add(carInfo);
        }
    }

    public int getMaxPosition(GameInfo gameInfo) {
        int maxPosition = 0;
        for (CarInfo carInfo : gameInfo.getCarInfos()) {
            maxPosition = Math.max(maxPosition, carInfo.getPosition());
        }
        return maxPosition;
    }

    public void run(IOHelper ioHelper) {
        List<String> namesInput = ioHelper.getNamesInput();
        int roundInput = ioHelper.getRoundInput();

        GameInfo gameInfo = init(namesInput, roundInput);
        ioHelper.printInitialStatus(gameInfo);
        while(gameInfo.getLeftRoundCnt() != 0) {
            gameInfo = runRound();
            ioHelper.printRoundResult(gameInfo);
        }

        ioHelper.printGameResult(findWinners(gameInfo));
    }
}
