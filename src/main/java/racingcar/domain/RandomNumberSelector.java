package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomNumberSelector implements NumberSelector {

    private final List<Integer> numbers;
    private final Random rand;

    public RandomNumberSelector(int startNumber, int endNumber) {
        List<Integer> numbers = new ArrayList<>();
        IntStream.range(startNumber, endNumber).forEach(numbers::add);
        this.numbers = numbers;
        this.rand = new Random();
    }

    public int selectNumber() {
        int index = rand.nextInt(numbers.size());
        return numbers.get(index);
    }
}
