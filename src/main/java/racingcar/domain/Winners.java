package racingcar.domain;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Winners {
    private final List<Car> winners;

    public Winners(List<Car> winners) {
        this.winners = winners;
    }

    public String getWinnerNames() {
        return winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }
}
