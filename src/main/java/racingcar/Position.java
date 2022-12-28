package racingcar;

import java.util.Objects;

public class Position implements Comparable{
    private int position;

    public Position(int defaultPosition) {
        this.position = defaultPosition;
    }

    public void move() {
        this.position++;
    }

    @Override
    public int compareTo(Object o) {
        if (!(o instanceof Position)) {
            throw new RuntimeException();
        }
        return position - ((Position)o).position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }
        Position position = (Position) o;
        return this.position == position.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    @Override
    public String toString() {
        return "-".repeat(this.position);
    }


}
