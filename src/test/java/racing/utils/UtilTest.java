package racing.utils;

import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @RepeatedTest(100)
    void randomNumberGenerateTest() {
        assertThat(RandomNumberGenerator.generate()).isBetween(0, 9);
    }
}
