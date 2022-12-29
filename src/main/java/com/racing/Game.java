package com.racing;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Game {
    private List<Car> cars;
    private int runCount;

    public Game(){
        this.cars = new ArrayList<>();
        this.runCount = 0;
    }

    /**
     * 사용자 입력을 통해 carName 분리
     * cars 생성
     * @param text
     */
    public void init(String text) {
        // text(사용자 입력)을 차 이름으로 분리
        String[] carNames = text.split(",");

        for(String carName : carNames){
            Car car = new Car(carName);
            this.cars.add(car);
        }
    }

    /**
     * random 값을 통해 모든 차에 대해 movement() 실행
     */
    public void moveCars() {
        for (Car car : this.cars) {
            car.move(car.makeRandom());
        }
    }

    /**
     * 사용자가 지정한 turn 만큼 게임 실행
     * @param turn
     */
    public void run(int turn) {
        for(int i=0; i<turn; i++){
            moveCars();
            printCarsLocation();
            this.runCount++;
        }
    }

    /**
     * 자동차들의 현재 위치를 출력
     */
    public void printCarsLocation(){
        for(Car car : this.cars){
            System.out.println(car.printLocation());
        }
        System.out.println();
    }

    /**
     * 자동차 중 가장 멀리 간 차들을
     * maxLocation과 비교해 모두 반환
     * @return
     */
    public ArrayList<Car> getWinner() {
        int maxLoc = maxLocation();
        ArrayList<Car> ret = new ArrayList<>();
        for (Car car : this.cars) {
            ret.add(maxLoc == car.getLocation() ? car : null);
        }
        ret.removeIf(Objects::isNull);
        return ret;
    }

    /**
     * 자동차가 간 거리 중 가장 최대값
     * @return
     */
    public int maxLocation() {
        int tmpMax = 0;
        for (Car car : this.cars) {
            tmpMax = Math.max(tmpMax, car.getLocation());
        }
        return tmpMax;
    }

    public List<Car> getCars() {
        return cars;
    }
}
