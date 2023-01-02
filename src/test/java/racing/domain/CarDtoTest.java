package racing.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.dto.CarDTO;

public class CarDtoTest {
    private static final String NULL_INPUT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    @DisplayName("생성자의 carName 인자가 null인 경우 예외가 발생한다.")
    @Test
    void 생성자의_carName_인자가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new CarDTO(null, new Position(0)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_INPUT_EXCEPTION_MESSAGE);
    }
}
