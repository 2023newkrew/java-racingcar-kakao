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

    private int generatedRandomNumber;

    @BeforeEach
    void setUp() {
        generatedRandomNumber = generateRandomNumber(RANDOM_MAX_BOUND);
    }

    @RepeatedTest(1000)
    @DisplayName("생성된 랜덤 숫자는 RANDOM_MAX_BOUND(10) 보다 작아야 한다.")
    public void validateMaxRandomNUmber() {
        assertThat(generatedRandomNumber)
                .isLessThan(RANDOM_MAX_BOUND);
    }

    @RepeatedTest(1000)
    @DisplayName("생성된 랜덤 숫자는 RANDOM_MIN_BOUND(0) 이상이여야 한다.")
    public void validateMinRandomNumber() {
        assertThat(generatedRandomNumber)
                .isGreaterThanOrEqualTo(RANDOM_MIN_BOUND);
    }
}
