package racingcar.domain;

public class Car extends MovableStrategy {
    private final CarName carName;
    private int position;

    public Car() {
        this("car");
    }

    public Car(final String name) {
        this.carName = new CarName(name);
    }

    public void moveOne(boolean canMove) {
        if (canMove) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() { return carName.toString(); }

    public void move(){
        int randomNumber = generateRandomNumber();
        moveOne(canMove(randomNumber));
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(carName);
        sb.append(" : ");
        sb.append("-".repeat(position));

        return sb.toString();
    }
}
