package racingcar.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
class RandomNumberGeneratorTest {

    @Test
    @DisplayName("0에서 9 사이에서 random값을 구한다.")
    void generateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        assertThat(randomNumberGenerator.generateBetweenZeroAndNine())
                .isGreaterThanOrEqualTo(0)
                .isLessThan(10);
    }

}