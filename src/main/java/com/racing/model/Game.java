package com.racing.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Game {
    private List<Car> cars;

    public Game(){
        this.cars = new ArrayList<>();
    }

    /**
     * random 값을 통해 모든 차에 대해 movement() 실행
     */
    private void moveCars() {
        cars.forEach(Car::moveCar);
    }

    /**
     * 자동차들의 현재 위치를 출력
     */
    private void printCarsLocation(){
        cars.forEach(car -> System.out.println(car.toStringLocation()));
        System.out.println();
    }

    /**
     * run 함수 내부 실행 메소드들
     */
    private void runProgress(){
        moveCars();
        printCarsLocation();
    }

    /**
     * 사용자가 지정한 turn 만큼 게임 실행
     * @param turn
     */
    public void run(int turn) {
        for(int i=0; i<turn; i++){
            runProgress();
        }
    }

    /**
     * 사용자 입력을 통해 carName 분리
     * cars 생성
     * @param text
     */
    public void gameInit(String text) {
        // text(사용자 입력)을 차 이름으로 분리
        this.cars.addAll(Arrays.stream(text.split(","))
                .map(carName -> new Car(carName))
                .collect(Collectors.toList()));
    }

    /**
     * 자동차 중 가장 멀리 간 차들을
     * maxLocation과 비교해 모두 반환
     * @return
     */
    public List<Car> getWinner() {
        int maxLoc = getMaxLocation();
        return cars.stream()
                .filter(car -> car.getLocation() == maxLoc)
                .collect(Collectors.toList());
    }

    /**
     * 자동차가 간 거리 중 가장 최대값
     * @return
     */
    public int getMaxLocation() {
        return this.cars.stream()
                .max(Comparator.comparingInt(Car::getLocation))
                .get()
                .getLocation();
    }

    public List<Car> getCars() {
        return cars;
    }
}
