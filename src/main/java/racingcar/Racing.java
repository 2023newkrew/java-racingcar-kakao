package racingcar;

import java.util.ArrayList;


public class Racing {
    private Car[] cars;
    public Car[] generateCars(String[] carNames) {
        Car[] result = new Car[carNames.length];
        for (int i = 0; i < carNames.length; i++) {
            result[i] = new Car(carNames[i]);
        }
        cars = result;
        return cars;
    }

    public void proceedRound() {
        for (Car car: cars) {
            car.move(new RandomGeneratorImpl());
            System.out.println(car.toStringWithPosition());
        }
        System.out.println();
    }

    public void proceedRounds(int counts) {
        System.out.println("*** 실행결과 ***");
        for (int i = 0; i < counts; i++) {
            proceedRound();
        }
    }

    public Car getWinner(Car[] cars) {
        Car winner = cars[0];
        for (Car car : cars) {
            winner = max(winner, car);
        }
        return winner;
    }

    private Car max(Car car1, Car car2) {
        if(car1.comparePositionToOtherCar(car2) >= 0) {
            return car1;
        }
        return car2;
    }

    public ArrayList<Car> getWinners(Car[] cars) {
        ArrayList<Car> result = new ArrayList<>();
        Car winner = getWinner(cars);
        for(Car car : cars) {
            addWinner(car, winner, result);
        }
        return result;
    }

    public String joinWinners() {
        ArrayList<Car> winners = getWinners(this.cars);
        String[] result = new String[winners.size()];
        for (int i = 0; i < winners.size(); i++) {
            result[i] = winners.get(i).toString();
        }
        return String.join(", ", result);
    }

    private void addWinner(Car car, Car winner, ArrayList<Car> result) {
        if (car.equalsPositionToOtherCar(winner)) {
            result.add(car);
        }
    }
}