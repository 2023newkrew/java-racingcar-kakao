package racingcar.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.domain.racing.Racing;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        this.racing = new Racing();
    }

    @Test
    void checkCarNos() {
        this.racing.makeCars(Arrays.asList("aa", "bbb", "ccc"));
        assertThat(this.racing.getCarDTOs().size()).isEqualTo(3);
    }

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
                .isThrownBy(() -> racing.init("aa,bb,cc", "-1"));

        assertThatIllegalArgumentException()
                .isThrownBy(() -> racing.init("aa,bb,aa", "4"));
    }

    @Test
    void isEnd() {
        racing.init("aa,bb", "1");

        assertThat(racing.isEnd()).isFalse();

        racing.proceedTurn();

        assertThat(racing.isEnd()).isTrue();
    }
}
