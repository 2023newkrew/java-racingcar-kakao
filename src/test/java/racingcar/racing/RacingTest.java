package racingcar.racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RacingTest {

    private Racing racing;

    @BeforeEach
    void setUp() {
        this.racing = new Racing();
    }

    @Test
    void checkCarNos() {
        this.racing.setCars(Arrays.asList("aa", "bbb", "ccc"));
        assertThat(this.racing.getCarNo()).isEqualTo(3);
    }
}
