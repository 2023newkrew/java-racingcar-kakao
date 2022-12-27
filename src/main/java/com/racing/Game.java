package com.racing;

import java.util.ArrayList;
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
            runCount++;
        }
    }
}
