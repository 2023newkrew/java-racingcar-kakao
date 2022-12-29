package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private List<String> getCarsWithPosition(Car[] cars, int position) {
        List<String> winners = Arrays.stream(cars)
                .filter(car -> car.getPosition() == position)
                .map(s -> s.getName()).collect(Collectors.toList());
        return winners;
    }

    public List<String> getWinner(Car[] cars) {
        List<String> winners = new ArrayList<>();
        int maxPosition = Arrays.stream(cars)
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return getCarsWithPosition(cars, maxPosition);
    }

}
