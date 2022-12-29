package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {
    private final List<Car> carList;

    public Cars(List<String> carNames) {
        carList = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public void move() {
        for (Car car: carList){
            car.move();
        }
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void printCars() {
        for (Car car : carList) {
            car.print();
        }
    }

    public void printWinners() {
        List<Car> winners = pickWinners();

        List<String> winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.print(String.join(", ", winnerNames));
        System.out.println("가 최종 우승했습니다.");
    }

    private List<Car> pickWinners(){
        int maxPosition = carList.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return carList.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
