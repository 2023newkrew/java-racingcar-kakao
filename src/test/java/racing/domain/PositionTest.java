package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PositionTest {
    private static final String NEGATIVE_POSITION_EXCEPTION_MESSAGE = "[ERROR] 위치는 음수일 수 없습니다.";

    @DisplayName("최초 위치가 음수인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10000})
    void 최초_위치가_음수인_경우_예외가_발생한다(int position) {
        assertThatThrownBy(() -> new Position(position))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NEGATIVE_POSITION_EXCEPTION_MESSAGE);
    }

    @DisplayName("최초 위치가 0 이상인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 10000})
    void 최초_위치가_0_이상인_경우_예외가_발생하지_않는다(int position) {
        assertThatCode(() -> new Position(position))
                .doesNotThrowAnyException();
    }

    @DisplayName("최초 위치를 생략하는 경우 예외가 발생하지 않는다.")
    @Test
    void 최초_위치를_생략하는_경우_예외가_발생하지_않는다() {
        assertThatCode(Position::new)
                .doesNotThrowAnyException();
    }

    @DisplayName("비교_연산시_position_필드를_비교한다")
    @Test
    void 비교_연산시_position_필드를_비교한다() {
        Position position = new Position();
        Position position0 = new Position(0);
        Position position1 = new Position(1);
        Assertions.assertAll(
                () -> assertThat(position.compareTo(position0)).isEqualTo(0),
                () -> assertThat(position0.compareTo(position)).isEqualTo(0),
                () -> assertThat(position0.compareTo(position1)).isLessThan(0),
                () -> assertThat(position1.compareTo(position0)).isGreaterThan(0)
        );
    }

    @DisplayName("increase_연산시_position_값이_distance만큼_증가한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void increase_연산시_position_값이_distance만큼_증가한다(int distance) {
        Position position = new Position();
        Position opponent = new Position(distance);
        position.increase(distance);
        assertThat(position.compareTo(opponent)).isEqualTo(0);
    }

    @DisplayName("인자_없이_increase_연산시_position_값이_1만큼_증가한다")
    @Test
    void 인자_없이_increase_연산시_position_값이_1만큼_증가한다() {
        Position position = new Position();
        Position opponent = new Position(1);
        position.increase();
        assertThat(position.compareTo(opponent)).isEqualTo(0);
    }
}
