package racingcar.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.RacingCar;
import racingcar.domain.RacingCars;
import racingcar.domain.RacingGameWinners;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RacingGameScoreViewTest {

    RacingCars racingCars;
    ByteArrayOutputStream out;
    RacingGameScoreView racingGameScoreView;

    @BeforeEach
    void setUp() {
        racingCars = new RacingCars(new String[]{"car1", "car2", "car3"});

        racingGameScoreView = new RacingGameScoreView();

        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("자동차들의 이름과 distance를 -로 출력한다")
    @Test
    void printScore() {
        //given
        String expected = "car1 : -\n" +
                "car2 : -\n" +
                "car3 : -\n" +
                "\n";

        //when
        racingGameScoreView.printRacingCarDist(racingCars);

        //then
        assertThat(out.toString()).hasToString(expected);
    }

    @DisplayName("RacingCar 배열을 받아 우승자 목록을 출력한다")
    @Test
    void printWinners() {
        //given
        String expected = "car1, car2, car3가 최종 우승했습니다.\n";

        //when
        RacingGameWinners winners = new RacingGameWinners(
                Arrays.asList(
                        new RacingCar("car1"),
                        new RacingCar("car2"),
                        new RacingCar("car3")
                )
        );
        racingGameScoreView.printWinners(winners);

        //then
        assertThat(out.toString()).hasToString(expected);
    }

    @DisplayName("RacingCar 배열을 받아 우승자를 출력한다")
    @Test
    void printWinners_singleWinner() {
        //given
        String expected = "car1가 최종 우승했습니다.\n";

        //when
        RacingGameWinners winners = new RacingGameWinners(List.of(new RacingCar("car1")));
        racingGameScoreView.printWinners(winners);

        //then
        assertThat(out.toString()).hasToString(expected);
    }
}
