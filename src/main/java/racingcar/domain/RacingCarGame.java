package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public interface RacingCarGame {

    void run();

    void add(String carName);
    void add(String... carNames);

    void add(Car... cars);

    List<Car> getWinner();

    List<String> getWinnerNames();

    List<String> getCarResults();

}
