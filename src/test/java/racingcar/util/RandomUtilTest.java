package racingcar.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RandomUtilTest {
    @RepeatedTest(100)
    void generateRandomZeroToNine() {
        int randomNumber = RandomUtil.generateRandom();
        Assertions.assertThat(randomNumber)
                .isBetween(0, 9);
    }
}
