package CarRacing.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RacingCountTest {
    private RacingCount racingCount;

    @BeforeEach
    void setUp() {
        racingCount = new RacingCount(5);
    }

    @DisplayName("레이싱 시도 횟수가 정상인 경우 테스트")
    @Test
    public void correctRacingCountTest() {
        assertDoesNotThrow(() -> {
            racingCount.validateRacingCount("5");
        });
    }

    @DisplayName("레이싱 시도 횟수가 비정상인 경우 테스트")
    @Test
    public void wrongRacingCountTest() {
        assertThrows(IllegalArgumentException.class, () -> {
            racingCount.validateRacingCount("abc");
        });
    }
}
