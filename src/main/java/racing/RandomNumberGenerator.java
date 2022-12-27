package racing;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberGenerator {
    private Random random;

    public RandomNumberGenerator() {
        this.random = new SecureRandom();
    }

    public Integer generateRandomNumber() {
        return random.nextInt(10);
    }

    public List<Integer> generateRandomNumbers(int size) {
        List<Integer> randomNumbers = new ArrayList<>();
        IntStream.range(0, size).forEach(i -> randomNumbers.add(generateRandomNumber()));
        return randomNumbers;
    }
}
