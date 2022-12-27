package racingCar;

import java.util.Random;

public class RandomNumGenerator {
    public static int generateRandomNum() {
        Random random = new Random();
        return random.nextInt(10);
    }
}
