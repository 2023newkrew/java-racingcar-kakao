package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public interface RacingCarGame {

    void run(int times);

    void add(String carName);

    void add(Car... cars);

    List<Car> getWinner();

    List<String> getWinnerNames();

    List<String> getCarResults();

    void play();
}
