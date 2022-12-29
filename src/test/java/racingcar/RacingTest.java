package racingcar;
/**
 * - 여러대의 자동차 정보를 가지고 있다
 * - 각 라운드마다 자동차를 전진하거나 정지한다
 *  - 랜덤 값이 4 이상일 경우 자동차를 전진한다
 *  - 랜덤 값이 3 이하일 경우 자동차를 정지한다
 * - 라운드가 종료될 때 마다 결과를 확인할 수 있다
 * - 게임이 종료된 후 우승자를 확인할 수 있다
 */

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
        racing.round();
        assertThat(racing.getCars().get(0).getPosition()).isEqualTo(1);
        assertThat(racing.getCars().get(1).getPosition()).isEqualTo(1);
    }
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void 랜덤값이_3_이하일_경우_자동차를_정지한다(final int condition) {
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
        racing.round();
        assertThat(racing.getCars().get(0).getPosition()).isEqualTo(0);
        assertThat(racing.getCars().get(1).getPosition()).isEqualTo(0);
    }
}
