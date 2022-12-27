package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomNumberSelector implements NumberSelector {

    private final List<Integer> numbers;
    private final Random rand;

    public RandomNumberSelector(int startNumber, int endNumber) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = startNumber; i < endNumber; i++) {
            numbers.add(i);
        }
        this.numbers = numbers;
        this.rand = new Random();
    }

    public int selectNumber() {
        int index = rand.nextInt(numbers.size());
        return numbers.get(index);
    }
}
