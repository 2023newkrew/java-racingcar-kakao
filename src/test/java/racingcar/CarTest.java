package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.when;

class CarTest {

    @Mock
    Engine engine;

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class from {

        @ParameterizedTest
        @ValueSource(strings = {"", "123456"})
        void should_throwException_when_invalidCarName(String carName) {
            assertThatThrownBy(() -> Car.from(carName, engine))
                    .isInstanceOf(RuntimeException.class);
        }

        @ParameterizedTest
        @MethodSource
        void should_createSuccess_when_validCarName(String carName, String expectedCarName) {
            Car car = Car.from(carName, engine);
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

}