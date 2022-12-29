package racingcar;

public class Car extends MovableStrategy{
    private final String name;
    private int position;

    public Car() {
        this("car");
    }

    public Car(final String name) {
        this.name = name;
    }

    public void moveOne(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() { return name; }

    public void move(){
        int randomNumber = generateRandomNumber();
        moveOne(canMove(randomNumber));
    }

    public void print() {
        System.out.print(name + " : ");
        for (int i = 0; i < position; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

}
