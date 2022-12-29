package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;

class RacingCarModelTest {

    @Nested
    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    class ParseNames {
        @ParameterizedTest
        @MethodSource
        void should_parseNames_when_validNameLine(String nameLine, String[] names) {
            List<String> result = RacingCarModel.parseNames(nameLine);
            assertThat(result).containsExactly(names);
        }

        Stream<Arguments> should_parseNames_when_validNameLine() {
            return Stream.of(
                    Arguments.of(",abc", new String[]{"", "abc"}),
                    Arguments.of("abc, def, geh", new String[]{"abc", " def", " geh"})
            );
        }

        @Test
        void should_throwException_when_tooManyNames() {
            String nameLine = "abc,".repeat(100) + "abc";
            assertThatThrownBy(() -> RacingCarModel.parseNames(nameLine))
                    .isInstanceOf(RuntimeException.class);
        }
    }


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
            Engine engine = Engine.defaultEngine;
            return Stream.of(
                    Arguments.of((Object) null),
                    Arguments.of(List.of()),
                    Arguments.of(
                            List.of(Car.of("abc", engine),
                                    Car.of("abc", engine))
                    ));
        }

        @Test
        void should_returnRacingCarModel_when_givenValidCars() {
            Engine engine = Engine.defaultEngine;
            List<Car> cars = List.of(
                    Car.of("abc", engine),
                    Car.of("abcd", engine)
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
        void should_returnCarInfos_when_givenCars(List<Car> cars, List<CarInfo> carInfos) {
            RacingCarModel model = RacingCarModel.from(cars);
            List<CarInfo> winners = model.getWinners();
            assertThatList(winners).isEqualTo(carInfos);
        }

        Stream<Arguments> should_returnCarInfos_when_givenCars() {
            Engine engine = Engine.defaultEngine;
            return Stream.of(
                    Arguments.of(
                            List.of(
                                    Car.of(CarInfo.of("car1", 1), engine),
                                    Car.of(CarInfo.of("car2", 2), engine),
                                    Car.of(CarInfo.of("car3", 3), engine)),
                            List.of(
                                    CarInfo.of("car3", 3))),
                    Arguments.of(
                            List.of(
                                    Car.of(CarInfo.of("car1", 1), engine),
                                    Car.of(CarInfo.of("car2", 1), engine),
                                    Car.of(CarInfo.of("car3", 1), engine)),
                            List.of(
                                    CarInfo.of("car1", 1),
                                    CarInfo.of("car2", 1),
                                    CarInfo.of("car3", 1))),
                    Arguments.of(
                            List.of(
                                    Car.of(CarInfo.of("car1", 1), engine)),
                            List.of(
                                    CarInfo.of("car1", 1))));
        }
    }
}