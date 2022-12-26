package racing;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    @RepeatedTest(100)
    @DisplayName("생성된 숫자는 0~9 사이여야 한다.")
    public void randomNumberValidateTest() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        int number = randomNumberGenerator.generate();
        Assertions.assertThat(number).isGreaterThanOrEqualTo(0);
        Assertions.assertThat(number).isLessThanOrEqualTo(9);
    }


}
