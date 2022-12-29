package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class CarTest {


    @ParameterizedTest
    @ValueSource(strings = {"soony", "five"})
    void 이름이_다섯자_이하이면_정상적으로_차_생성(String name) {
        Assertions.assertThatCode(() -> new RacingCar(name))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"long_name", "more_than_five"})
    void 이름이_다섯자_초과라면_IllegalArgException_발생(String name) {
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> new RacingCar(name));
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 이름이_Null_또는_Empty_라면_NPE_발생(String name) {
        Assertions.assertThatNullPointerException()
                .isThrownBy(() -> new RacingCar(name));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveTest(int input) {
        Car racingCar = new RacingCar("abc");
        racingCar.move(input);
        int dist = racingCar.getPosition();
        assertThat(dist).isEqualTo(1);
    }

    @Test
    void 초기_distance를_갖는_Car_생성() {
        assertThatCode(() -> new RacingCar("abc", 5)).doesNotThrowAnyException();
        assertThat(new RacingCar("soony", 6).getPosition()).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void doNotMoveTest(int input) {
        Car racingCar = new RacingCar("abc");
        racingCar.move(input);
        int dist = racingCar.getPosition();
        assertThat(dist).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def"})
    public void toStringTest(String input) {
        Car racingCar = new RacingCar(input);
        for (int i = 0; i < 3; i++) {
            racingCar.move(5);
            assertThat(racingCar.toString()).isEqualTo(input + " : " + "-".repeat(i + 1));
        }
    }


}
