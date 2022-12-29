package racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static final String NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    @DisplayName("생성자의 carNames 인자가 null인 경우 예외가 발생한다.")
    @Test
    void 생성자의_carNames_인자가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @DisplayName("생성자의 carNames 인자가 empty list인 경우 예외가 발생한다.")
    @Test
    void 생성자의_carNames_인자가_empty_list인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE);
    }

    /*
    @DisplayName("생성자의 carNames 인자가 empty list인 경우 예외가 발생한다.")
    @Test
    void singleWinnerTest() {
        assertThat(cars.getWinners(distanceComparator)).isEqualTo(Arrays.asList("cosmo"));
    }

    @Test
    void multiWinnerTest() {
        cars.play();
        cars.play();
        assertThat(cars.getWinners(distanceComparator)).isEqualTo(Arrays.asList("cosmo", "kyne"));
    } */
}
