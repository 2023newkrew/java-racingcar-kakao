package com.racing;

import java.util.Random;

public class Car {
    private int location;
    private String carName;
    private static final int MAX_CAR_NAME = 5;
    private static final int MIN_CAR_MOVE = 4;
    private static final int MAX_RANDOM = 10;

    public Car(String carName) {
        this.carName = carName;
    }

    /**
     * 차 이름이 5글자 초과라면 RuntimeError
     */
    public void checkName() {
        if(this.carName.length() > MAX_CAR_NAME){
            throw new RuntimeException("car name length over 5");
        }
    }

    /**
     * 0 ~ MAX_RANDOM 사이의 랜덤 정수 반환
     * @return random값
     */
    public int makeRandom(){
        Random random = new Random();
        return random.nextInt(MAX_RANDOM);
    }

    /**
     * random number가 4 이상이라면 한 칸 전진
     * @param rand
     */
    public void move(int rand) {
        if(rand >= MIN_CAR_MOVE) this.location++;
    }

    /**
     * 자동차의 현재 위치를 형식에 맞게 출력
     * @return 자동차의 location 출력
     */
    public String printLocation() {
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
