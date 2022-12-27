package com.racing;

public class Car {
    public int location;
    private final String carName;

    public Car(String carName) {
        this.carName = carName;
    }

    /**
     * 차 이름이 5글자 초과라면 RuntimeError
     */
    public void validateName() {
        if (carName.length() > 5) {
            throw new RuntimeException("car name length over 5");
        }
    }

    /**
     * @param rand 0~9 사이의 값을 입력받는다 4 이상이면 location을 1 증가시킨다.
     */
    public void move(int rand) {
        if (rand >= 4) this.location++;
    }

    /**
     * 자동차의 현재 위치를 형식에 맞게 출력
     *
     * @return 자동차의 location 출력
     */
    public String formatLocation() {
        return String.format(
                "%s : %s",
                this.carName,
                "-".repeat(this.location)
        );
    }

    public void printCarName() {
        System.out.print(this.carName);
    }
}
