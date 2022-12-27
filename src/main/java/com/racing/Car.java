package com.racing;

public class Car {
    public int location;
    private String carName;
    public Car(String carName) {
        this.carName = carName;
    }

    /**
     * 차 이름이 5글자 초과라면 RuntimeError
     */
    public void checkName() {
        if(this.carName.length() > 5){
            throw new RuntimeException("car name length over 5");
        }
    }

    /**
     * random number가 4 이상이라면 한 칸 전진
     * @param rand
     */
    public void movement(int rand) {
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
