package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Comparator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.dto.CarDTO;
import racing.dto.CarDtoDistanceComparator;

public class CarDtoTest {
    private static final String DEFAULT_NAME = "kyne";
    private static final String NULL_INPUT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    @DisplayName("생성자의 carName 인자가 null인 경우 예외가 발생한다.")
    @Test
    void 생성자의_carName_인자가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new CarDTO(null, new Position(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_INPUT_EXCEPTION_MESSAGE);
    }

    @Test
    void compareDistanceTest() {
        Comparator<CarDTO> comparator = new CarDtoDistanceComparator();
        CarDTO carDTO = new CarDTO(new CarName(DEFAULT_NAME), new Position(1));
        CarDTO opponentCarDTO = new CarDTO(new CarName("1234"), new Position(1));
        assertThat(comparator.compare(opponentCarDTO, carDTO)).isEqualTo(0);

        opponentCarDTO = new CarDTO(new CarName("1234"), new Position(3));
        assertThat(comparator.compare(opponentCarDTO, carDTO)).isGreaterThan(0);
        assertThat(comparator.compare(carDTO, opponentCarDTO)).isLessThan(0);
    }
}
