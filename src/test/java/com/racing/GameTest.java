package com.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.security.InvalidParameterException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class GameTest {

    static Stream<Arguments> winnerParams() {
        return Stream.of(
                Arguments.of(
                        Map.of(
                                "a", 1,
                                "b", 2,
                                "c", 3
                        ),
                        List.of("c")
                ),
                Arguments.of(
                        Map.of(
                                "a", 1,
                                "b", 3,
                                "c", 3
                        ),
                        List.of("b", "c")
                ),
                Arguments.of(
                        Map.of(
                                "a", 3,
                                "b", 3,
                                "c", 3
                        ),
                        List.of("a", "b", "c")
                )
        );
    }


    static Stream<Arguments> maxLocationParams() {
        return Stream.of(
                Arguments.of(
                        Map.of(
                                "a", 1,
                                "b", 2,
                                "c", 3
                        ),
                        3
                ),
                Arguments.of(
                        Map.of(
                                "a", 2,
                                "b", 3,
                                "c", 4
                        ),
                        4
                )
        );
    }

    @DisplayName("올바르지 않은 게임 생성을 시도하는 경우")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "|",
            "'abcdef'|",
            "'a,abcdef'|",
    })
    void invalidNamesTest(String invalidName) {
        assertThatExceptionOfType(InvalidParameterException.class)
                .isThrownBy(() -> Game.factory()
                        .withCarsRawString(invalidName)
                        .build());
    }

    @DisplayName("올바른 게임을 생성하는 경우")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "''                         |0",
            "'a'                        |1",
            "'a,ab'                     |2",
            "'a,ab,abc'                 |3",
            "'a,ab,abc,abcd'            |4",
            "'a,ab,abc,abcd,abcde'      |5",
    })
    void validNamesTest(String validName, int length) {
        List<String> names = Arrays.stream(validName.split(","))
                .limit(length)
                .collect(Collectors.toList());
        Game game = Game.factory()
                .withCarsRawString(validName)
                .build();
        assertThat(game.carStream()
                .map(Car::name)
                .collect(Collectors.toList()))
                .isEqualTo(names);

    }

    @DisplayName("1단계를 진행하는 메서드")
    @ParameterizedTest
    @CsvSource(delimiter = '|' , value = {
            "0 | 0",
            "1 | 0",
            "2 | 0",
            "3 | 0",
            "4 | 1",
            "5 | 1",
            "6 | 1",
            "7 | 1",
            "8 | 1",
            "9 | 1",
    })
    void runEachStepTest(int userIn, int expectLocation) {
        Game game = Game.factory()
                .withCarsRawString("a,b,c")
                .build();
        game.run(car -> userIn);
        game.carStream()
                .forEach(car -> assertThat(car.location()).isEqualTo(expectLocation));
    }

    @DisplayName("승리자를 판단")
    @ParameterizedTest
    @MethodSource("winnerParams")
    void winnerTest(Map<String, Integer> carLocations, List<String> expectWinners) {
        Game game = Game.factory()
                .withCarsRawString(String.join(",", carLocations.keySet()))
                .build();
        game.carStream()
                .forEach(car -> car.setLocation(carLocations.get(car.name())));
        List<String> actualWinners = game.winners()
                .stream()
                .map(Car::name)
                .collect(Collectors.toList());
        assertThat(actualWinners).hasSameElementsAs(expectWinners);
    }


    @DisplayName("가장 멀리 간 자동자를 확인")
    @ParameterizedTest
    @MethodSource("maxLocationParams")
    void maxLocationTest(Map<String, Integer> carLocations, int expectMaxLocation) {
        Game game = Game.factory()
                .withCarsRawString(String.join(",", carLocations.keySet()))
                .build();
        game.carStream()
                .forEach(car -> car.setLocation(carLocations.get(car.name())));
        assertThat(game.maxLocation()).isEqualTo(expectMaxLocation);
    }
}
