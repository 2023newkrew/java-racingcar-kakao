package racingcar;

public class Car {
    String name;
    int cnt;

    public Car(String name) {
        this.name = name;
        this.cnt = 0;
    }


    public void printStatus() {
        System.out.println(name + " : ");
    }
}
