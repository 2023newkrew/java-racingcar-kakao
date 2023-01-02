package racingcar.model;

public class CarMove {
    private static final int MOVE_BOUNDARY = 4;

    public static boolean isMove() {
        return RandomMoveNumber.getRandomMoveNumber() >= MOVE_BOUNDARY;
    }
}
