package racingcar.domain;

import java.util.List;

public interface RacingCarGame {

    void run(int times);

    void add(String carName);

    void add(Car... cars);

    void play();
}
