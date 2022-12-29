package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class GameRepeatTest {
    private static final String NOT_ENOUGH_REPEAT_EXCEPTION_MESSAGE = "[ERROR] 최소 1회는 시도해야 합니다.";
    private static final String TOO_MANY_REPEAT_EXCEPTION_MESSAGE = "[ERROR] 시도 횟수는 최대 100회까지만 가능합니다.";
    private GameRepeat gameRepeat;

    @DisplayName("반복 횟수가 1 미만인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10000})
    void 반복_횟수가_1_미만인_경우_예외가_발생한다(int repeat) {
        assertThatThrownBy(() -> new GameRepeat(repeat))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NOT_ENOUGH_REPEAT_EXCEPTION_MESSAGE);
    }

    @DisplayName("반복 횟수가 5 초과인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {101, 200, 10000})
    void 반복_횟수가_100_초과인_경우_예외가_발생한다(int repeat) {
        assertThatThrownBy(() -> new GameRepeat(repeat))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_MANY_REPEAT_EXCEPTION_MESSAGE);
    }

    @DisplayName("반복 횟수가 1 이상 100 이하인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {91, 100, 1})
    void 반복_횟수가_1_이상_100_이하인_경우_예외가_발생하지_않는다(int repeat) {
        assertThatCode(() -> new GameRepeat(repeat))
                .doesNotThrowAnyException();
    }

    @DisplayName("hasRemaining 메서드는 남은 repeat이 양수인지 반환한다.")
    @Test
    void hasRemaining_메서드는_남은_repeat이_양수인지_반환한다() {
        gameRepeat = new GameRepeat(2);
        assertThat(gameRepeat.hasRemaining()).isEqualTo(true);
        Assertions.assertAll(
                () -> assertThat(reduceAndHasRemaining()).isEqualTo(true),
                () -> assertThat(reduceAndHasRemaining()).isEqualTo(false),
                () -> assertThat(reduceAndHasRemaining()).isEqualTo(false)
        );
    }

    private boolean reduceAndHasRemaining() {
        gameRepeat.reduce();
        return gameRepeat.hasRemaining();
    }
}
