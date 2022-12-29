package racingcar.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class Racing {
    private Car[] cars;
    private int remainingRound;


    private Racing(Builder builder){
        cars = builder.cars.toArray(new Car[0]);
        remainingRound = builder.remainingRounds;
    }
    public void proceedRound() {
        if (remainingRound <= 0){
            throw new InvalidRacingConditionException("이미 경기가 끝났습니다.");
        }
        remainingRound--;
        for (Car car: cars) {
            car.move();
        }
    }

    public Car[] getCars(){
        return cars;
    }

    public boolean isEnd(){
        return remainingRound<=0;
    }
    public Car[] getWinners(){
        return getWinners(this.cars);
    }
    public Car[] getWinners(Car[] cars) {
        if (remainingRound > 0){
            throw new InvalidRacingConditionException("아직 경기가 끝나지 않았습니다.");
        }
        Stream<Car> stream = Arrays.stream(cars);
        Car winner = getWinner(cars);
        List<Car> result = new ArrayList<>();
        stream.filter(car -> car.equalsPosition(winner))
                .forEach(car -> result.add(car));
        return result.toArray(new Car[0]);
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

    public static class Builder{
        private List<Car> cars = new ArrayList<>();
        private int remainingRounds;

        public Builder addCars(String[] carNames){
            for (String carName : carNames){
                cars.add(new Car(carName, new RandomGeneratorImpl()));
            }
            return this;
        }

        public Builder addCars(String[] carNames, RandomGenerator rg){
            for (String carName : carNames){
                cars.add(new Car(carName, rg));
            }
            return this;
        }

        public Builder addCars(Car[] madeCars){
            for (Car car:madeCars){
                cars.add(car);
            }
            return this;
        }

        public Builder setRounds(int rounds){
            this.remainingRounds = rounds;
            return this;
        }

        public Racing build(){
            if (remainingRounds <= 0){
                throw new InvalidRacingConditionException("라운드 횟수는 1 이상이어야 합니다.");
            }
            if (cars.size() <= 1){
                throw new InvalidRacingConditionException("차는 2대 이상이어야 합니다.");
            }
            return new Racing(this);
        }
    }
}