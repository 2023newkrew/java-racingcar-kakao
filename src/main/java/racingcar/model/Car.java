package racingcar.model;

import racingcar.model.strategy.MovableStrategy;

public class Car extends MovableStrategy {
    private final String inputParser;
    private int position;

    public Car() {
        this("car");
    }

    public Car(String name) {
        this.inputParser = name;
    }

    public void moveOne(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() { return inputParser; }

    public void move(){
        int randomNumber = generateRandomNumber();
        moveOne(canMove(randomNumber));
    }


    public void print() {
        System.out.print(inputParser + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
