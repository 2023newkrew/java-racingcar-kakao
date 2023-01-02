package CarRacing.domain;

import java.util.Objects;

public class CarPosition {
    private int position;

    public CarPosition(int position) {
        this.position = position;
    }

    public CarPosition move(int speed) {
        return new CarPosition(position + speed);
    }

    public boolean comparePosition(int positionToCompare) {
        return position > positionToCompare;
    }

    public CarPosition largerPosition(CarPosition positionToCompare) {
        if (positionToCompare.comparePosition(position)) {
            return new CarPosition(positionToCompare.getPosition());
        }
        return new CarPosition(position);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CarPosition that = (CarPosition) o;
        return position == that.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }
}
