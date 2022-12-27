package racing;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class RandomMoveStrategyTest {
    @ParameterizedTest
    @MethodSource("getMoveData")
    void move(int input, boolean expected) {
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy();
        assertThat(moveStrategy.isMove(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> getMoveData() {
        return Stream.of(
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, false),
                Arguments.of(3, false),
                Arguments.of(4, true),
                Arguments.of(5, true),
                Arguments.of(6, true),
                Arguments.of(7, true),
                Arguments.of(8, true),
                Arguments.of(9, true)
        );
    }

    @RepeatedTest(100)
    void random() {
        RandomMoveStrategy moveStrategy = new RandomMoveStrategy();
        assertThat(moveStrategy.random()).isIn(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
    }
}
