package com.racing;

import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Game {
    private final ArrayList<Car> innerCars = new ArrayList<>();

    private Game() {
    }

    public static Factory factory() {
        return new Factory();
    }

    public void run() {
        Random randomGenerator = new Random();
        this.run((car) -> randomGenerator.nextInt(10));
    }

    public void run(RunEachStepCarFunc func) {
        for (Car eachCar : this.innerCars) {
            eachCar.move(func.generateMoveInput(eachCar));
        }
    }

    public Stream<Car> carStream() {
        return this.innerCars.stream();
    }


    /**
     * @return 가장 location이 큰 모든 Car 목록을 반환한다.
     */
    public List<Car> winners() {
        int maxLocation = maxLocation();
        return this.innerCars
                .stream()
                .filter(car -> car.location() == maxLocation)
                .collect(Collectors.toList());
    }

    /**
     * @return 자동차들이 이동한 거리 중 가장 최대값을 반환한다.
     */
    public int maxLocation() {
        int tempMaxLocation = 0;
        for (Car eachCar : this.innerCars) {
            tempMaxLocation = Math.max(tempMaxLocation, eachCar.location());
        }
        return tempMaxLocation;
    }

    @FunctionalInterface
    public interface RunEachStepCarFunc {
        int generateMoveInput(Car about);
    }

    public static class Factory {
        Game temporary;

        private Factory() {
            this.temporary = new Game();
        }

        /**
         * @param text 초기화를 위해 자동차 이름들의 목록을 반환한다.
         */
        public Factory withCarsRawString(String text) {
            if (text == null) {
                throw new InvalidParameterException("raw string not nullable");
            }
            // 만약 길이가 0 인 문자열이라면 무시한다.
            if (text.length() == 0) {
                return this;
            }
            // text(사용자 입력)을 차 이름으로 분리
            for (String carName : text.split(",")) {
                this.temporary.innerCars.add(
                        Car.factory()
                                .withName(carName)
                                .build()
                );
            }
            return this;
        }

        public Game build() {
            Game result = temporary;
            this.temporary = null;
            return result;
        }
    }
}
