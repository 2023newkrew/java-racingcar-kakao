package racing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    private RandomNumberGenerator generator;
    @BeforeEach
    void init() {
        generator = new RandomNumberGenerator();
    }
    @RepeatedTest(100)
    void randomNumberGenerateTest() {
        assertThat(generator.generate()).isBetween(0.0, 9.0);
    }
}
