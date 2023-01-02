package racingcar;

import java.util.Random;

public class CarRandom {
    public int generateRandom10() {
        Random rand = new Random();
        return rand.nextInt(10);
    }
}
