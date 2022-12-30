package racingcar.domain;

public interface Car {

    public int getDistance();
    public String getName();
    public void move(int seed);

    boolean outOfBound(int condition);

    public String toString();
}
