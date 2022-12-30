package racing.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomNumberGeneratorTest {
    private RandomNumberGenerator generator;
    @BeforeEach
    void init() {
        generator = new RandomNumberGenerator();
    }
    @RepeatedTest(100)
    void 랜덤넘버가_0과_9_사이인지_확인() {
        assertThat(generator.generate()).isBetween(0, 9);
    }
}
