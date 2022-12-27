package racingcar;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        this.name = name;
        position = 0;
    }

    public int move(boolean flag) { //flag = 1이면 포지션을 증가시키고, 포지션을 반환, 0이면 포지션을 반환
        if (flag) position++;
        return position;
    }

    public int getPosition(){
        return position;
    }

    public String getName() {
        return name;
    }
}
