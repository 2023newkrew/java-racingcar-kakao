package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
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
        @ValueSource(strings = {"", "123456"})
        void should_throwException_when_invalidCarName(String carName) {
            assertThatThrownBy(() -> Car.of(carName, engine))
                    .isInstanceOf(RuntimeException.class);
        }

        @ParameterizedTest
        @MethodSource
        void should_createSuccess_when_validCarName(String carName, String expectedCarName) {
            Car car = Car.of(carName, engine);
            CarInfo carInfo = car.getCarInfo();
            assertThat(carInfo.getName()).isEqualTo(expectedCarName);
            assertThat(carInfo.getPosition()).isEqualTo(0);
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
    }

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class moveOrStop {

        @ParameterizedTest
        @MethodSource
        void should_returnPosition_when_moveOrStop(int returnPower, int position) {
            when(engine.getPower()).thenReturn(returnPower);
            Car car = Car.of("test", engine);
            car.moveOrStop();
            CarInfo carInfo = car.getCarInfo();
            assertThat(carInfo.getPosition()).isEqualTo(position);
        }

        Stream<Arguments> should_returnPosition_when_moveOrStop() {
            return Stream.of(
                    Arguments.of(9, 1),
                    Arguments.of(8, 1),
                    Arguments.of(7, 1),
                    Arguments.of(6, 1),
                    Arguments.of(5, 1),
                    Arguments.of(4, 1),
                    Arguments.of(3, 0),
                    Arguments.of(2, 0),
                    Arguments.of(1, 0),
                    Arguments.of(0, 0)
            );
        }

        @Test
        void should_throwException_when_engineIsNull() {
            Car car = Car.of("test", null);
            assertThatThrownBy(car::moveOrStop).isInstanceOf(RuntimeException.class);
        }
    }
}