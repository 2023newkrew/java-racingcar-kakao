package racingcar.model;

import racingcar.model.strategy.MovableStrategy;

public class Car extends MovableStrategy {
    private final String carName;
    private int position;

    public Car() {
        this("car");
    }

    public Car(String name) {
        this.carName = name;
    }

    public void moveOne(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() { return carName; }

    public void move(){
        int randomNumber = generateRandomNumber();
        moveOne(canMove(randomNumber));
    }

    public void print() {
        System.out.print(carName + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
