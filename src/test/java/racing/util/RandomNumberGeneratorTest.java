package racing.util;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racing.util.RandomNumberGenerator;

import java.util.Random;

import static org.assertj.core.api.Assertions.*;
import static racing.util.RandomNumberGenerator.*;

public class RandomNumberGeneratorTest {

    private static final int RANDOM_MAX_BOUND = 10;
    private static final int RANDOM_MIN_BOUND = 0;
    @RepeatedTest(1000)
    @DisplayName("생성된 숫자는 0~9 사이여야 한다.")
    public void randomNumberValidate() {
        int number = generateRandomNumber(RANDOM_MAX_BOUND);
        assertThat(number).isGreaterThanOrEqualTo(RANDOM_MIN_BOUND);
        assertThat(number).isLessThan(RANDOM_MAX_BOUND);
    }
}
