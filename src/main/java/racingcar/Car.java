package racingcar;

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
}
