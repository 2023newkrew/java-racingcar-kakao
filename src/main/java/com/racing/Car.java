package com.racing;

import java.util.Random;

public class Car {
    public int location;
    private String carName;
    public Car(String carName) {
        this.carName = carName;
    }



    public int makeRandom(){
        Random random = new Random();
        return random.nextInt(10);
    }

    /**
     * 차 이름이 5글자 초과라면 RuntimeError
     */
    public void checkName() {
        if(this.carName.length() > 5){
            throw new RuntimeException("car name length over 5");
        }
    }


    public void carMove(){
        move(makeRandom());
    }

    /**
     * random number가 4 이상이라면 한 칸 전진
     * @param rand
     */
    public void move(int rand) {
        if(rand >= 4) this.location++;
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

    public void printCarName(){
        System.out.print(this.carName);
    }
}
