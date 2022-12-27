package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import racing.util.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.*;

public class RandomNumberGeneratorTest {

    private RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    void setUp() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @RepeatedTest(100)
    @DisplayName("생성된 숫자는 0~9 사이여야 한다.")
    public void randomNumberValidate() {
        int number = randomNumberGenerator.generateRandomNumber();
        assertThat(number).isGreaterThanOrEqualTo(0);
        assertThat(number).isLessThanOrEqualTo(9);
    }
}
