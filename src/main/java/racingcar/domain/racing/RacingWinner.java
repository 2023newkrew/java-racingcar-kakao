package racingcar.domain.racing;

import racingcar.domain.car.CarDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RacingWinner {
    private List<CarDTO> winners = new ArrayList<>();

    public RacingWinner(List<CarDTO> cars) {
        setWinners(cars);
    }

    private void setWinners(List<CarDTO> cars) {
        int maxPosition = cars.stream()
                .mapToInt(CarDTO::getPosition)
                .max()
                .orElse(0);

        winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RacingWinner))
            return false;

        RacingWinner compareWinner = (RacingWinner) obj;

        return winners.equals(compareWinner.winners);
    }

    @Override
    public String toString() {
        return winners.stream()
                .map(CarDTO::getName)
                .collect(Collectors.joining(" "));
    }
}
