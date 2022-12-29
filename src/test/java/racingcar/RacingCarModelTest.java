package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingCarModelTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class from {

        @ParameterizedTest
        @MethodSource
        void should_throwException_when_givenCars(List<Car> cars) {
            assertThatThrownBy(() -> RacingCarModel.from(cars))
                    .isInstanceOf(RuntimeException.class);
        }

        Stream<Arguments> should_throwException_when_givenCars() {
            Engine engine = Engine.getDefaultEngine();
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < 101; ++i) {
                cars.add(Car.from("c" + i, engine));
            }
            return Stream.of(
                    Arguments.of((Object) null),
                    Arguments.of(List.of()),
                    Arguments.of(
                            List.of(Car.from("abc", engine),
                                    Car.from("abc", engine))),
                    Arguments.of(cars)
            );
        }

        @Test
        void should_returnRacingCarModel_when_givenValidCars() {
            Engine engine = Engine.getDefaultEngine();
            List<Car> cars = List.of(
                    Car.from("abc", engine),
                    Car.from("abcd", engine)
            );
            RacingCarModel model = RacingCarModel.from(cars);
            assertThat(model).isNotNull();
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class getWinners {

        @ParameterizedTest
        @MethodSource
        void should_returnCarInfos_when_givenCars(List<Car> cars, List<CarDto> carDtos) {
            RacingCarModel model = RacingCarModel.from(cars);
            List<CarDto> winners = model.getWinners();
            assertThatList(winners).isEqualTo(carDtos);
        }

        Stream<Arguments> should_returnCarInfos_when_givenCars() {
            Engine engine = Engine.getDefaultEngine();
            return Stream.of(
                    Arguments.of(
                            List.of(
                                    Car.from("car1", 1, engine),
                                    Car.from("car2", 2, engine),
                                    Car.from("car3", 3, engine)),
                            List.of(
                                    CarDto.from("car3", 3))),
                    Arguments.of(
                            List.of(
                                    Car.from("car1", 1, engine),
                                    Car.from("car2", 1, engine),
                                    Car.from("car3", 1, engine)),
                            List.of(
                                    CarDto.from("car1", 1),
                                    CarDto.from("car2", 1),
                                    CarDto.from("car3", 1))),
                    Arguments.of(
                            List.of(
                                    Car.from("car1", 1, engine)),
                            List.of(
                                    CarDto.from("car1", 1))));
        }
    }
}