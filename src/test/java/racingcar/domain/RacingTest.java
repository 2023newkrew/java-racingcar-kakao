package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingTest {

    private final List<Car> cars = Arrays.asList(new Car("aa"), new Car(1, "bb"), new Car(1, "cc"));

    @DisplayName("생성자로 차 리스트와 턴 수를 받는다.")
    @Test
    void constructRacingWithCarNamesAndTurn() {
        assertThatCode(() -> new Racing(cars, 2)).doesNotThrowAnyException();
    }

    @DisplayName("Racing의 현재 턴이 남아있으면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void isRacing(int turn) {
        Racing racing = new Racing(cars, turn);

        assertThat(racing.isRacing()).isTrue();
    }

    @DisplayName("Racing의 현재 턴이 남아있지 않으면 false를 반환한다.")
    @Test
    void isNotRacing() {
        Racing racing = new Racing(cars, 0);

        assertThat(racing.isRacing()).isFalse();
    }

    @DisplayName("Racing의 proceedTurn이 실행되면 turn이 하나 줄어든다.")
    @Test
    void proceedTurn() {
        Racing racing = new Racing(cars, 1);
        racing.proceedTurn();
        assertThat(racing.isRacing()).isFalse();
    }
}
