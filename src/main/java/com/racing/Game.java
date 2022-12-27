package com.racing;

import java.util.ArrayList;

public class Game {
    public ArrayList<Car> cars;

    public Game(){
        this.cars = new ArrayList<>();
    }

    public void init(String text) {
        // text(사용자 입력)을 차 이름으로 분리
        String[] carNames = text.split(",");

        for(String carName : carNames){
            cars.add(new Car(carName));
        }
    }
}
