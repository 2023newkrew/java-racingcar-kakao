package racingcar.domain;

public interface RacingCarGame {

    public Cars getCars();

    void race();

    public Cars createCars(String[] carNames);

    int getCarsSize();
}
