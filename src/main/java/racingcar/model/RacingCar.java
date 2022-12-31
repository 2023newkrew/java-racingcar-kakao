package racingcar.model;

import racingcar.util.Movable;

public class RacingCar extends Car implements Comparable<RacingCar>{

    public RacingCar(String name) {
        this(name, 1);
    }

    public RacingCar(String name, int defaultPosition) {
        super(name, defaultPosition);
    }

    public void move(Movable movable) {
        if (movable.canMove()) {
            position++;
        }
    }


    @Override
    public int compareTo(RacingCar o) {
        return o.comparePosition(this.position);
    }

    private int comparePosition(int otherCarPosition) {
        return otherCarPosition - this.position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof RacingCar) {
            return this.position == ((RacingCar)obj).position && this.name.equals(((RacingCar)obj).name);
        }
        return false;
    }
}
