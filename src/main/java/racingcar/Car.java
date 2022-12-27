package racingcar;

import java.util.Random;

public class Car {
    private String name;
    private int count = 1;

    public Car(String name) {
        this.name = name;
    }


    public void printStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append(name + " : ");
        sb.append("-".repeat(Math.max(0, count)));
        System.out.println(sb);
    }

    public void move() {
        this.count++;
    }

    public void race() {
        Random random = new Random();

        if (random.nextInt(9) > 3) {
            move();
        }
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }
}
