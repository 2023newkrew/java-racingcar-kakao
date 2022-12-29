package racingcar.domain;

public class Car extends MovableStrategy {
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(name);
        sb.append(" : ");
        sb.append("-".repeat(position));

        return sb.toString();
    }
}
