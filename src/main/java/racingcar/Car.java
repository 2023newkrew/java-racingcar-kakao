package racingcar;

import java.util.Random;

public class Car {
    private final String name;
    private int cnt;

    public Car(String name) {
        this.name = name;
        this.cnt = 1;
    }


    public void printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " : ");
        sb.append("-".repeat(Math.max(0, cnt)));
        System.out.println(sb);
    }

    public void move() {
        this.cnt++;
    }

    public void race() {
        if (new Random().nextInt(9) > 3) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    public int getCnt() {
        return cnt;
    }
}
