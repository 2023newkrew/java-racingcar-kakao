package racingcar.step2.domain;

import java.util.Random;

public class Car implements Comparable<Car>{

    private static final int MAXIMUM_NAME_LENGTH = 5;
    private static final int MOVE_THRESHOLD = 4;
    private int position;
    private final String name;


    public Car(final String name){
        this(name, 1);
    }
    public Car(final String name, final int position){
        validateName(name);
        this.name = name;
        this.position = position;
    }

    public void validateName(final String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("자동차 이름은 1자 이상이어야 합니다.");
        }
        if (name.length() > MAXIMUM_NAME_LENGTH){
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }

    public void move(){
        move(getRandomNumber());
    }

    public void move(final int condition){
        if (condition >= MOVE_THRESHOLD){
            position++;
        }
    }

    protected int getRandomNumber(){
        return new Random().nextInt(10);
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }


    @Override
    public String toString(){
        return name + " : " + "-".repeat(Math.max(1, position));
    }

    @Override
    public int compareTo(Car o) {
        return Integer.compare(this.position, o.position);
    }
}
