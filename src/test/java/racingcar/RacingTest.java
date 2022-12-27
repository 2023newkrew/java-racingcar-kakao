package racingcar;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    @Test
    void checkCarNos() {
        Racing racing = new Racing();

        racing.makeCars(Arrays.asList("aa", "bbb", "ccc"));
        assertThat(racing.getCarNo()).isEqualTo(3);
    }


}
