package racingcar;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class RacingTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void 랜덤값이_4_이상일_경우_자동차를_전진한다(final int condition) {
        Racing racing = testRacing(condition);
        racing.round();
        assertThat(racing.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(racing.getCars().get(1).getPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 랜덤값이_3_이하일_경우_자동차를_정지한다(final int condition) {
        Racing racing = testRacing(condition);
        racing.round();
        assertThat(racing.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(racing.getCars().get(1).getPosition()).isEqualTo(0);
    }

    @Test
    public void 라운드가_종료될_때_마다_결과를_확인할_수_있다() {
        Racing racing = testRacing();
        racing.round();
        racing.round();
        assertThat(racing.getCars().get(0).getPosition()).isEqualTo(2);
        assertThat(racing.getCars().get(1).getPosition()).isEqualTo(0);

    }

    @Test
    public void 게임이_종료된_후_우숭자를_확인할_수_있다() {
        Racing racing = testRacing();
        racing.round();
        racing.round();
        List<String> winner = new ArrayList<>();
        winner.add("aaa");
        assertEquals(racing.getWinner(), winner);
    }

    private Racing testRacing(int condition) {
        List<String> carNames = new ArrayList<>();
        carNames.add("aaa");
        carNames.add("bbb");
        Racing racing = new Racing(carNames, 1) {
            @Override
            public void round() {
                for (Car car : getCars()) {
                    car.move(condition);
                }
            }
        };
        return racing;
    }

    private Racing testRacing() {
        List<String> carNames = new ArrayList<>();
        carNames.add("aaa");
        carNames.add("bbb");
        Racing racing = new Racing(carNames, 1) {
            @Override
            public void round() {
                getCars().get(0).move(4);
                getCars().get(1).move(3);
            }
        };
        return racing;
    }
}