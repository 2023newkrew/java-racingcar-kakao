package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CarTest {

    @Mock
    Engine engine;


    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class from {

        @ParameterizedTest
        @MethodSource
        void should_throwException_when_invalidCarName(String carName, String message) {
            assertThatThrownBy(() -> Car.from(carName, engine))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage(message);
        }

        Stream<Arguments> should_throwException_when_invalidCarName() {
            return Stream.of(
                    Arguments.of("", "Car name too short."),
                    Arguments.of("123456", "car name too long.")
            );
        }

        @ParameterizedTest
        @MethodSource
        void should_createSuccess_when_validCarName(String carName, String expectedCarName) {
            Car car = Car.from(carName, engine);
            CarDto carDto = CarDto.from(car);
            assertThat(carDto.getName()).isEqualTo(expectedCarName);
            assertThat(carDto.getPosition()).isEqualTo(0);
        }

        Stream<Arguments> should_createSuccess_when_validCarName() {
            return Stream.of(
                    Arguments.of("abc", "abc"),
                    Arguments.of(" abc", "abc"),
                    Arguments.of(" abc ", "abc"),
                    Arguments.of(" a bc ", "a bc"),
                    Arguments.of("  12345  ", "12345"),
                    Arguments.of("a", "a")
            );
        }

        @Test
        void should_throwException_when_engineIsNull() {
            assertThatThrownBy(() -> Car.from("test", null))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage("Engine is null.");
        }
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class moveOrStop {

        @ParameterizedTest
        @MethodSource
        void should_returnPosition_when_moveOrStop(boolean move, int position) {
            when(engine.movable()).thenReturn(move);
            Car car = Car.from("test", engine);
            car.moveOrStop();
            CarDto carDto = CarDto.from(car);
            assertThat(carDto.getPosition()).isEqualTo(position);
        }

        Stream<Arguments> should_returnPosition_when_moveOrStop() {
            return Stream.of(
                    Arguments.of(true, 1),
                    Arguments.of(false, 0)
            );
        }
    }
}