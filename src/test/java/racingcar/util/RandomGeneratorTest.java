package racingcar.util;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.RepeatedTest;

public class RandomGeneratorTest {
    private final int REPS = 1000;

    @RepeatedTest(REPS)
    void generateOneDigit() {
        assertThat(RandomGenerator.generateOneDigit()).isLessThan(10);
        assertThat(RandomGenerator.generateOneDigit()).isGreaterThanOrEqualTo(0);
    }
}
