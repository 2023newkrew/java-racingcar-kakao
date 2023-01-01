package CarRacing.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarNameTest {
    private CarName carName;
    @BeforeEach
    void setUp() {
        carName = new CarName("test");
    }

    @DisplayName("빈 자동차 이름 예외 처리 테스트")
    @Test
    public void validateNullCarNameTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            carName.validateName(null);
        });
    }


    @DisplayName("적절한 길이(1이상 5이하)의 자동차 이름 예외 처리 테스트")
    @Test
    public void validateCorrectCarNameTest() {
        String correct_name = "pobi";
        assertDoesNotThrow(() -> {
            carName.validateName(correct_name);
        });
    }

    @DisplayName("적절하지 않은 길이(0, 6이상)의 자동차 이름 예외 처리 테스트")
    @Test
    public void validateWrongCarNameTest() {
        String wrong_name = "pororo";
        assertThrows(IllegalArgumentException.class, () -> {
            carName.validateName(wrong_name);
        });
    }
}
