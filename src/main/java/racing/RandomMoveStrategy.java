package racing;

import java.util.Random;

public class RandomMoveStrategy {
    public int random() {
        Random random = new Random();
        return random.nextInt(9);
    }

    public boolean isMove() {
        return isMove(random());
    }

    public boolean isMove(int input) {
        return input > 3;
    }
}
