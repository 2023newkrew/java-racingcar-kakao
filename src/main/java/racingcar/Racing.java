package racingcar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Racing {
    private Car[] cars;
    public Car[] generateCars(String[] names) {
        Car[] result = new Car[names.length];
        for (int i = 0; i < names.length; i++) {
            result[i] = new Car(names[i], new RandomGeneratorImpl());
        }
        cars = result;
        return result;
    }

    public void proceedRounds(int counts) {
        System.out.println("*** 실행결과 ***");
        for (int i = 0; i < counts; i++) {
            proceedRound();
        }
    }

    private void proceedRound() {
        for (Car car: cars) {
            car.move();
            System.out.println(car);
        }
        System.out.println();
    }

    public List<Car> getWinners(Car[] cars) {
        Stream<Car> stream = Arrays.stream(cars);
        Car winner = getWinner(cars);
        List<Car> result = new ArrayList<>();
        stream.filter(car -> car.equalsPosition(winner))
                .forEach(car -> result.add(car));
        return result;
    }

    private Car getWinner(Car[] cars) {
        Car winner = cars[0];
        for (Car car : cars) {
            winner = max(winner, car);
        }
        return winner;
    }

    private Car max(Car car1, Car car2) {
        if(car1.compareTo(car2) >= 0) {
            return car1;
        }
        return car2;
    }

    public String joinWinners() {
        List<Car> winners = getWinners(this.cars);
        String[] result = new String[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            result[i] = winners.get(i).toStringOnlyName();
        }
        return String.join(", ", result);
    }
}