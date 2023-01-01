package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarPositionTest {
    private CarPosition carPosition;
    private CarPosition comparePosition;
    @BeforeEach
    void setUp() {
        carPosition = new CarPosition(5);
        comparePosition = new CarPosition(6);
    }

    @DisplayName("자동차 위치 이동이 잘 이루어지는지 테스트")
    @Test
    public void moveTest() {
        assertThat(carPosition.move(1)).isEqualTo(comparePosition);
    }

    @DisplayName("졍수형으로 표현된 자동차 위치와 비교가 잘 이루어지는지 테스트")
    @ParameterizedTest
    @CsvSource({"4, true", "6, false"})
    public void comparePositionTest(int positionToCompare, boolean larger) {
        assertThat(carPosition.comparePosition(positionToCompare)).isEqualTo(larger);
    }

    @DisplayName("두 자동차 위치 객체를 비교해서 더 큰 위치를 갖는 객체를 리턴하는지 테스트")
    @Test
    public void largerPositionTest() {
        CarPosition smallerPosition = new CarPosition(4);
        assertThat(carPosition.largerPosition(comparePosition)).isEqualTo(comparePosition);
        assertThat(carPosition.largerPosition(smallerPosition)).isEqualTo(carPosition);
    }
}
