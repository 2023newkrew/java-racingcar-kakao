package CarRacing.domain;

import CarRacing.util.StringUtil;
import java.util.ArrayList;
import java.util.List;


public class Racing {
    private RacingCount racingCount;
    private Cars cars;
    private List<RacingLog[]> racingLogs = new ArrayList<>();
    private List<CarName> winners = new ArrayList<>();


    public Racing(String inputNames, String racingCount) {
        this.racingCount = new RacingCount(racingCount);
        this.cars = new Cars(splitInputNames(inputNames));
    }

    public Racing(Cars cars, int racingCount) {
        this.cars = cars;
        this.racingCount = new RacingCount(racingCount);
    }

    public String[] splitInputNames(String inputNames) {
        return StringUtil.splitString(inputNames, ",");
    }

    public void decideWinners() {
        CarPosition maxPosition = cars.getMaxPosition();
        winners = cars.getWinners(maxPosition);
    }

    public void writeRacingLog() {
        racingLogs.add(cars.getRacingLog());
    }

    public RacingResult playRacing() {
        writeRacingLog();
        while (racingCount.isEnd()) {
            cars.oneCycle();
            writeRacingLog();
            racingCount = racingCount.decreaseCount(1);
        }
        decideWinners();
        return new RacingResult(racingLogs, winners);
    }

    public Cars getCars() {
        return cars;
    }

    public List<CarName> getWinners() {
        return winners;
    }
}
