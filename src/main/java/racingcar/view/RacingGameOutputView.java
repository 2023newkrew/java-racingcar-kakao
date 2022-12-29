package racingcar.view;

import racingcar.Car;
import racingcar.Cars;

import java.util.List;
import java.util.stream.Collectors;

public class RacingGameOutputView {

    public RacingGameOutputView() {
    }

    public void printCars(Cars cars) {
        System.out.println(cars);
        System.out.println();
    }

    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(","));

        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
