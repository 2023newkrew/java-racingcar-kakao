package racing.model;

import racing.exception.ErrorCode;
import racing.exception.RacingException;

import java.util.concurrent.ThreadLocalRandom;

public class Car implements Comparable<Car>{
    private final String name;
    private int position;

    public Car(String name, int position) {
        validateCarName(name);
        this.name = name;
        this.position = position;
    }

    private void validateCarName(String carName) {
        if(carName.isBlank()) throw new RacingException(ErrorCode.EMPTY_CAR_NAME);
        if(carName.length() > 5) throw new RacingException(ErrorCode.TOO_LONG_CAR_NAME);
    }

    public void tryMove() {
        int randint = ThreadLocalRandom.current().nextInt(10);
        if (randint >= 4) {
            position++;
        }
    }

    public String getName() {
        return this.name;
    }

    public Integer getPosition() {
        return this.position;
    }

    public boolean isSamePos(int pos) {
        return this.position == pos;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Car){
            Car other = (Car) obj;
            return this.name.equals(other.name);
        }
        return false;
    }

    @Override
    public String toString(){
        return name + " : " + "-".repeat(Math.max(1, position));
    }

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.position, otherCar.position);
    }
}
