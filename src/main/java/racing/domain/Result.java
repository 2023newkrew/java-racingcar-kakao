package racing.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Result {

    private List<String> winners = new ArrayList<>();

    private void getCarsWithPosition(Car[] cars, int position) {
        winners = Arrays.stream(cars)
                .filter(car -> car.getPosition() == position)
                .map(s -> s.getName()).collect(Collectors.toList());
    }

    public List<String> getWinner(CarList carList) {
        winners = new ArrayList<>();
        int maxPosition = Arrays.stream(carList.getCars())
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        getCarsWithPosition(carList.getCars(), maxPosition);
        return winners;
    }

}
