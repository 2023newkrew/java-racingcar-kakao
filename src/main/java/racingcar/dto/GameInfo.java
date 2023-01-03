package racingcar.dto;

import racingcar.domain.Car;

import java.util.List;

public class GameInfo {

    private List<CarInfo> carInfos;
    private int leftRoundCnt;

    public GameInfo(List<Car> cars, int leftRoundCnt) {
        this.carInfos = CarInfo.of(cars);
        this.leftRoundCnt = leftRoundCnt;
    }

    public List<CarInfo> getCarInfos() {
        return carInfos;
    }

    public int getLeftRoundCnt() {
        return leftRoundCnt;
    }
}
