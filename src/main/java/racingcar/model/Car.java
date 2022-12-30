package racingcar.model;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    public void printStatus() {
        StringBuilder sb = new StringBuilder();

        sb.append(name + " : ");
        sb.append("-".repeat(Math.max(0, position)));

        System.out.println(sb);
    }

    public void move() {
        this.position++;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }
}
