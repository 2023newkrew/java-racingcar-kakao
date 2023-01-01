package racingcar.domain;

import java.util.*;
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
            throw new InvalidRacingConditionException("1 : racing is already over");
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
    public boolean isNotEnd(){
        return !isEnd();
    }
    public Car[] getWinners(){
        if (isNotEnd()){
            throw new InvalidRacingConditionException("2 : Not yet race ended.");
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
        private int remainingRounds = 0;

        public Builder addCars(String[] carNames){
            addCars(carNames, new RandomGeneratorImpl());
            return this;
        }

        public Builder addCars(String[] carNames, RandomGenerator rg){
            for (String carName : carNames){
                cars.add(new Car(carName, rg));
            }
            checkDuplicatedName();
            return this;
        }

        public Builder addCars(Car[] madeCars){
            for (Car car:madeCars){
                cars.add(car);
            }
            checkDuplicatedName();
            return this;
        }

        private void checkDuplicatedName(){
            Set<String> carSet = new HashSet<>();
            for (Car car:cars){
                carSet.add(car.toStringOnlyName());
            }
            if (carSet.size() != cars.size()){
                throw new InvalidRacingConditionException("5 : Duplicated car exist!");
            }
        }

        public Builder setRounds(int rounds){
            this.remainingRounds = rounds;
            return this;
        }

        public Racing build(){
            if (remainingRounds <= 0){
                throw new InvalidRacingConditionException("3 : Round should be positive");
            }
            if (cars.size() <= 1){
                throw new InvalidRacingConditionException("4 : Too few Cars(need 2)");
            }
            return new Racing(this);
        }
    }
}