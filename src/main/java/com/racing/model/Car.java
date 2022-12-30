package com.racing.model;

import com.racing.Service.RandomService;

import java.util.Random;

public class Car {
    private int location;
    private String carName;
    private final RandomService randomService;

    private static final int MAX_NAME_LENGTH = 5;
    private static final int MIN_MOVE_FLAG = 4;
    private static final int MAX_RANDOM_NUM = 10;

    public Car(String carName) {
        this.checkName(carName);
        this.carName = carName;
        this.randomService = new RandomService();
    }

    /**
     * 차 이름이 5글자 초과라면 IllegalArgumentException
     */
    private void checkName(String carName) {
        if(carName.length() > MAX_NAME_LENGTH){
            throw new IllegalArgumentException("차 이름은 5글자 이하여야 합니다.");
        }
    }

    /**
     * Random 값에 맞춰 차 이동
     */
    public void moveCar(){
        this.move(randomService.makeRandom(MAX_RANDOM_NUM));
    }

    /**
     * random number가 4 이상이라면 한 칸 전진
     * @param rand
     */
    public void move(int rand) {
        if(rand >= MIN_MOVE_FLAG) this.location++;
    }

    /**
     * 자동차의 현재 위치를 형식에 맞게 출력
     * @return 자동차의 location 출력
     */
    public String toStringLocation() {
        return String.format(
                "%s : %s",
                this.carName,
                "-".repeat(this.location)
        );
    }

    public int getLocation() {
        return location;
    }

    public String getCarName() {
        return carName;
    }
}
