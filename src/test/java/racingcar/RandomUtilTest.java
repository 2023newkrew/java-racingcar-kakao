package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;

public class RandomUtilTest {
    @RepeatedTest(100)
    void generateRandomZeroToNine() {
        RandomUtil randomUtil = new RandomUtil();
        int randomNumber = randomUtil.generateRandom();
        Assertions.assertThat(randomNumber)
                .isBetween(0, 9);
    }
}
