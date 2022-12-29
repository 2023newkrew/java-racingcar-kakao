package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import racingcar.domain.Car;
import racingcar.domain.CarDto;
import racingcar.domain.RacingCars;
import racingcar.domain.engine.Engine;
import racingcar.domain.engine.EngineImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingCarsTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class from {

        @ParameterizedTest
        @MethodSource
        void should_throwException_when_givenCars(List<Car> cars, String message) {
            assertThatThrownBy(() -> RacingCars.from(cars))
                    .isInstanceOf(RuntimeException.class)
                    .hasMessage(message);
        }

        Stream<Arguments> should_throwException_when_givenCars() {
            Engine engine = EngineImpl.getRandomEngine();
            List<Car> cars = new ArrayList<>();
            for (int i = 0; i < 101; ++i) {
                cars.add(Car.from("c" + i, engine));
            }
            return Stream.of(
                    Arguments.of(null, "Cars is Empty."),
                    Arguments.of(List.of(), "Cars is Empty."),
                    Arguments.of(
                            List.of(Car.from("abc", engine),
                                    Car.from("abc", engine)), "Car name Duplicate."),
                    Arguments.of(cars, "car too many. current car count: 101")
            );
        }

        @Test
        void should_returnRacingCars_when_givenValidCars() {
            Engine engine = EngineImpl.getRandomEngine();
            List<Car> cars = List.of(
                    Car.from("abc", engine),
                    Car.from("abcd", engine)
            );
            RacingCars racingCars = RacingCars.from(cars);
            assertThat(racingCars).isNotNull();
        }
    }

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class getWinners {

        @ParameterizedTest
        @MethodSource
        void should_returnCarDtos_when_givenCars(List<Car> cars, List<CarDto> carDtos) {
            RacingCars racingCars = RacingCars.from(cars);
            List<CarDto> winners = racingCars.getWinners();
            assertThatList(winners).isEqualTo(carDtos);
        }

        Stream<Arguments> should_returnCarDtos_when_givenCars() {
            Engine engine = EngineImpl.getRandomEngine();
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