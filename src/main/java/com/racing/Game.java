package com.racing;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Game {
    public ArrayList<Car> cars = new ArrayList<>();
    public int runCount = 0;

    public Game(){}

    /**
     * @param text 초기화를 위해 자동차 이름들의 목록을 반환한다.
     */
    public void init(String text) {
        // 만약 길이가 0 인 문자열이라면 무시한다.
        if(text.length() == 0){
            return;
        }
        // text(사용자 입력)을 차 이름으로 분리
        String[] carNames = text.split(",");

        for(String carName : carNames){
            Car car = new Car(carName);
            car.validateName();
            cars.add(car);
        }
    }

    /**
     * @return 각각의 Car에 move 값으로 넣어지는 0~9 사이의 값을 삽입한다.
     */
    public ArrayList<Integer> moveCars() {
        Random randomGenerator = new Random();
        ArrayList<Integer> result = new ArrayList<>();
        for (Car eachCar : this.cars) {
            int randomNumber = randomGenerator.nextInt(10);
            result.add(randomNumber);
            eachCar.move(randomNumber);
        }
        return result;
    }

    /**
     * @param turn 지정한 횟수만큼 moveCars를 수행한다.
     */
    public void run(int turn) {
        for(int i=0; i<turn; i++){
            moveCars();
            printCarsLocation();
            runCount++;
        }
    }

    /**
     * 자동차들의 현재 위치를 출력하는 메서드.
     */
    public void printCarsLocation(){
        for(Car car : cars){
            System.out.println(car.formatLocation());
        }
        System.out.println();
    }

    /**
     * @return 가장 location이 큰 모든 Car 목록을 반환한다.
     */
    public ArrayList<Car> getWinners() {
        int maxLocation = getMaxLocation();
        ArrayList<Car> ret = new ArrayList<>();
        for (Car eachCar : this.cars) {
            ret.add(maxLocation == eachCar.location ? eachCar : null);
        }
        // 모든 null 값을 제거한다.
        ret.removeIf(Objects::isNull);
        return ret;
    }

    /**
     * @return 자동차들이 이동한 거리 중 가장 최대값을 반환한다.
     */
    public int getMaxLocation() {
        int tempMaxLocation = 0;
        for (Car eachCar : this.cars) {
            tempMaxLocation = Math.max(tempMaxLocation, eachCar.location);
        }
        return tempMaxLocation;
    }
}
