package racingcar.domain.racing;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingTest {

    @Test
    void duplicateNames() {
        assertThat(Racing.isDuplicateNames(Arrays.asList("aaa", "aaa"))).isTrue();
    }

    @Test
    void uniqueValidNames() {
        assertThat(Racing.isDuplicateNames(Arrays.asList("aaa", "aab"))).isFalse();
    }

    @Test
    void checkInvalidRace() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing("aa,bb,cc", "-1"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Racing("aa,bb,aa", "4"));
    }

    @Test
    void isEnd() {
        Racing racing = new Racing("aa,bb", "1");

        assertThat(racing.isEnd()).isFalse();

        racing.proceedTurn();

        assertThat(racing.isEnd()).isTrue();
    }
}
