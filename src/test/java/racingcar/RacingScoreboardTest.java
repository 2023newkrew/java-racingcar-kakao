package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingScoreboardTest {

    List<RacingCar> racingCars;
    ByteArrayOutputStream out;
    RacingScoreboard racingScoreboard;

    @BeforeEach
    void setUp() {
        racingCars = new ArrayList<>();
        racingCars.add(new RacingCar("car1"));
        racingCars.add(new RacingCar("car2"));
        racingCars.add(new RacingCar("car3"));

        racingScoreboard = new RacingScoreboard();

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @Test
    void printScore() {
        //given
        String expected = "car1 : -\n" +
                "car2 : -\n" +
                "car3 : -\n" +
                "\n";

        //when
        racingScoreboard.printScore(racingCars);

        //then
        assertThat(out.toString()).hasToString(expected);
    }

    @Test
    void printWinners() {
        //given
        String expected = "car1, car2, car3가 최종 우승했습니다.\n";

        //when
        racingScoreboard.printWinners(racingCars);

        //then
        assertThat(out.toString()).hasToString(expected);
    }

    @Test
    void printWinners_singleWinner() {
        //given
        String expected = "car1가 최종 우승했습니다.\n";

        //when
        racingScoreboard.printWinners(List.of(new RacingCar("car1")));

        //then
        assertThat(out.toString()).hasToString(expected);
    }
}
