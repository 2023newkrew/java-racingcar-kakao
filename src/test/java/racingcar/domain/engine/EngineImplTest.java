package racingcar.domain.engine;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.engine.powerstrategy.PowerStrategy;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class EngineImplTest {

    @Nested
    class from {
        @Test
        void should_throwException_when_strategyIsNull() {
            assertThatThrownBy(() -> EngineImpl.from(null)).
                    isInstanceOf(RuntimeException.class)
                    .hasMessage("Power strategy should be not null.");
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class movable {

        @ParameterizedTest
        @MethodSource
        void should_returnMovable_when_givenPower(int power, boolean movable) {
            PowerStrategy powerStrategy = () -> power;
            Engine engine = EngineImpl.from(powerStrategy);
            assertThat(engine.movable()).isEqualTo(movable);
        }

        Stream<Arguments> should_returnMovable_when_givenPower() {
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
    }
}