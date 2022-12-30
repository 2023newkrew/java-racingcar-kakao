package racingcar.domain;

public class Car extends MovableStrategy {
    private final CarName carName;
    private Position position;

    public Car() {
        this("car");
    }

    public Car(final String name) {
        this.carName = new CarName(name);
        this.position = new Position(0);
    }

    public void moveOne(boolean canMove) {
        if (canMove) {
            position.moveOne();
        }
    }

    public Position getPosition() {
        return position;
    }

    public String getName() { return carName.toString(); }

    public void move(){
        int randomNumber = generateRandomNumber();
        moveOne(canMove(randomNumber));
    }

    public boolean isAtPosition(Position position) {
        return this.position.equals(position);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(carName);
        sb.append(" : ");
        sb.append(position.repeat("-"));

        return sb.toString();
    }
}
