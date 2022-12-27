package com.racing;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Game {
    public ArrayList<Car> cars;
    public int runCount;

    public Game(){
        this.cars = new ArrayList<>();
        this.runCount = 0;
    }

    public void init(String text) {
        // text(사용자 입력)을 차 이름으로 분리
        String[] carNames = text.split(",");

        for(String carName : carNames){
            cars.add(new Car(carName));
        }
    }

    /**
     *
     * @return 각각의 random값
     */
    public ArrayList<Integer> moveCars() {
        Random random = new Random();
        ArrayList<Integer> result = new ArrayList<>();
        for (Car car : cars) {
            int rand = random.nextInt(10);
            result.add(rand);
            car.movement(rand);
        }
        return result;
    }

    public void run(int turn) {
        for(int i=0; i<turn; i++){
            moveCars();
            printCarsLocation();
            runCount++;
        }
    }

    public void printCarsLocation(){
        for(Car car : cars){
            System.out.println(car.printLocation());
        }
        System.out.println();
    }

    public ArrayList<Car> getWinner() {
        int maxLoc = maxLocation();
        ArrayList<Car> ret = new ArrayList<>();
        for (Car car : cars) {
            ret.add(maxLoc == car.location ? car : null);
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
        for (Car car : cars) {
            tmpMax = Math.max(tmpMax, car.location);
        }
        return tmpMax;
    }
}
