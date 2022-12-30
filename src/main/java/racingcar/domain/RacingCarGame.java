package racingcar.domain;

import java.util.List;

public interface RacingCarGame {

    public Cars getCars();
    void race();

    public Cars createCars(String[] carNames);

    void add(String carName);

    void add(List<Car> cars);

    void play();

    int getCarsSize();
}
