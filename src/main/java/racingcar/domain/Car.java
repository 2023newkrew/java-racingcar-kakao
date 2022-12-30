package racingcar.domain;

public interface Car {

    public int getPosition();

    public String getName();

    public void move(int seed);

    public String toString();
}
