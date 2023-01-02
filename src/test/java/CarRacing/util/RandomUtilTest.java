package CarRacing.util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class RandomUtilTest {
    @DisplayName("랜덤한 숫자가 0부터 9사이로 생성되는지 테스트")
    @RepeatedTest(10)
    public void generateRandomNumberTest() {
        assertThat(RandomUtil.generateRandomNumber(10)).isBetween(0, 9);
    }
}
