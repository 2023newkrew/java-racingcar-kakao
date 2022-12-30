package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public interface RacingCarGame {

    void run();

    void add(Set<String> names);

    void add(Car... cars);

    List<Car> getWinner();

    List<String> getWinnerNames();

    List<String> getCarResults();

}
