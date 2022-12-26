package racingcar;

import java.util.Random;

public class Car {
    String name;
    int cnt;

    public Car(String name) {
        this.name = name;
        this.cnt = 0;
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
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        if (random.nextInt(9) > 3) {
            move();
        }
    }
}
