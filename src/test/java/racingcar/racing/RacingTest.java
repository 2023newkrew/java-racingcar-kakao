package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        this.racing = new Racing();
    }

    @Test
    void checkCarNos() {
        this.racing.makeCars(Arrays.asList("aa", "bbb", "ccc"));
        assertThat(this.racing.getCarNo()).isEqualTo(3);
    }

    @Test
    void duplicateNames() {
        assertThat(Racing.isDuplicateNames(Arrays.asList("aaa", "aaa"))).isTrue();
    }

    @Test
    void uniqueValidNames() {
        assertThat(Racing.isDuplicateNames(Arrays.asList("aaa", "aab"))).isFalse();
    }
}
