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

    /**
     * 모든 자동차들에 대해 {@link com.racing.Car#move} 메서드를 random 을 이용해 호출한다.
     */
    public void run() {
        Random randomGenerator = new Random();
        this.run((car) -> randomGenerator.nextInt(10));
    }

    /**
     * @param func 각 자동차에 어떤 값을 이용해 {@link com.racing.Car#move}를 호출할 지를 결정할 수 있게 해 준다.
     */
    public void run(RunEachStepCarFunc func) {
        for (Car eachCar : this.innerCars) {
            eachCar.move(func.generateMoveInput(eachCar));
        }
    }

    /**
     * 스트림으로 자동차를 순회할 수 있도록 제공하는 메서드
     * 기본 배열에 대해서 외부로부터의 Immutable 을 보장하기 위해서 고안되었다.
     *
     * @return 게임이 내부적으로 보유한 모든 자동차를 순회하는 스트림을 내보낸다.
     */
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

    /**
     * 이 함수 인터페이스(람다)는 자동차를 이동시키는 메서드에서 값을 입력하기 위해 사용된다.
     * 기본적으로 람다를 통해 랜덤, 혹은 상황에 따라 특정 자동차에게 특정 값을 사용하게 하는 등의 용도로 사용된다.
     */
    @FunctionalInterface
    public interface RunEachStepCarFunc {
        int generateMoveInput(Car about);
    }

    /**
     * 게임을 생성하기 위해서 사용되는 팩토리 클래스로 이를 이용해 객체를 생성하고 사용자가 직접 객체를 만드는 것을 막는다.
     */
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

        /**
         * 객체를 초기화하기 위한 모든 값을 준비하고 객체를 생성시킨다.
         */
        public Game build() {
            Game result = temporary;
            this.temporary = null;
            return result;
        }
    }
}
