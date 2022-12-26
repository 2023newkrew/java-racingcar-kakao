package racing;

import java.security.SecureRandom;
import java.util.Random;

public class RandomNumberGenerator {
    public int generate() {
        Random random = new SecureRandom();
        return random.nextInt(10);
    }
}
