package mvc.domain;

import java.util.Random;

public class RandomNumGenerator {
    public static int generateNum() {
        return new Random().nextInt(10);
    }
}
