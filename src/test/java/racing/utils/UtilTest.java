package racing.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import static org.assertj.core.api.Assertions.assertThat;

public class UtilTest {
    @DisplayName("randomNumberGenerator는 0 이상 9 이하의 숫자를 생성한다.")
    @RepeatedTest(100)
    void randomNumberGenerateTest() {
        assertThat(RandomNumberGenerator.generate()).isBetween(0, 9);
    }
}
