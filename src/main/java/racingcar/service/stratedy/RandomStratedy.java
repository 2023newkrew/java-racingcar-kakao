package racingcar.service.stratedy;

public class RandomStratedy implements MovableStrategy {
    private final int FORWARD_NUM = 4;

    public boolean isMove() {
        return (int) (Math.random() * 10) >= FORWARD_NUM;
    }
}
