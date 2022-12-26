package racingcar;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private final List<Car> carList = new ArrayList<>();

    public RacingGame(String carList) {
        String[] carNameList = carList.split(",");
        for (String s : carNameList) {
            checkNameLength(s);
            this.carList.add(new Car(s));
        }
    }

    private void checkNameLength(String s) {
        if (s.length() > 5) throw new RuntimeException("5글자 이하의 이름만 가능합니다.");
    }

    public List<Car> getCarList() {
        return carList;
    }
}
