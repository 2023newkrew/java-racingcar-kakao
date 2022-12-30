package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public void printCars(List<Car> carList) {
        for (Car car : carList) {
            car.print();
        }
    }

    public void printWinners(List<Car> carList) {
        List<Car> winners = pickWinners(carList);

        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    private List<Car> pickWinners(List<Car> carList){
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
