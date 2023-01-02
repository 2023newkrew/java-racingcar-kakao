package racingcar.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Collections;
import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.StubNumberGenerator;

class RacingGameTest {

    private static final int MOVE = 4;
    private static final int STOP = 3;

    @DisplayName("자동차 이름은 공백을 제거하고 6글자 이상일 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"ethaan   ", "veruasds   ", "   pasdobi\t\t\t"})
    void inputUnderFiveLength(String carName) {
        Assertions.assertThatThrownBy(() -> new Car(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1대 이상의 자동차가 경주에 참가해야한다.")
    @Test
    void mustParticipateTwoCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);

        assertThatThrownBy(() -> new RacingGame(1, numberGenerator, Collections.emptyList()))
                .isInstanceOf(IllegalArgumentException.class);
    }


    @DisplayName("특정 값 이상인 경우 자동차를 이동시킨다")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveCar(int value) {
        NumberGenerator numberGenerator = new StubNumberGenerator(value);
        int maxRound = 1;
        RacingGame racingGame = new RacingGame(maxRound, numberGenerator, List.of("a"));

        RacingResult racingResult = racingGame.race();
        RoundResult lastRoundResult = getRoundResult(racingResult, maxRound);

        assertThat(getPositionByName(lastRoundResult, "a")).isOne();
    }

    @DisplayName("특정 값 이하인 경우 자동차를 정지시킨다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void stopCar(int value) {
        NumberGenerator numberGenerator = new StubNumberGenerator(value);
        int maxRound = 1;
        RacingGame racingGame = new RacingGame(maxRound, numberGenerator, List.of("a"));

        RacingResult racingResult = racingGame.race();
        RoundResult lastRoundResult = getRoundResult(racingResult, maxRound);

        assertThat(getPositionByName(lastRoundResult, "a")).isZero();
    }

    @DisplayName("여러 대의 자동차를 이동 혹은 정지시킨다.")
    @Test
    void moveOrStopCars() {
        NumberGenerator numberGenerator = new StubNumberGenerator(MOVE, MOVE, STOP);
        int maxRound = 1;
        RacingGame racingGame = new RacingGame(maxRound, numberGenerator, List.of("a", "b", "c"));

        RacingResult racingResult = racingGame.race();
        RoundResult lastRoundResult = getRoundResult(racingResult, maxRound);
        assertThat(getPositionByName(lastRoundResult, "a")).isOne();
        assertThat(getPositionByName(lastRoundResult, "b")).isOne();
        assertThat(getPositionByName(lastRoundResult, "c")).isZero();
    }

    @DisplayName("가장 멀리 이동한 차가 단독 우승한다")
    @Test
    void getSoloWinner() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, STOP, STOP,
                MOVE, MOVE, MOVE
        );
        RacingGame racingGame = new RacingGame(3, numberGenerator, List.of("a", "b", "c"));

        RacingResult racingResult = racingGame.race();

        List<Car> winners = racingResult.getWinnerCars();
        assertThat(winners)
                .extracting(Car::getName)
                .hasSize(1)
                .contains("a");
    }

    @DisplayName("가장 멀리 이동한 자동차가 공동 우승한다")
    @Test
    void getCoWinners() {
        NumberGenerator numberGenerator = new StubNumberGenerator(
                MOVE, MOVE, STOP,
                MOVE, MOVE, MOVE,
                MOVE, MOVE, MOVE
        );
        RacingGame racingGame = new RacingGame(3, numberGenerator, List.of("a", "b", "c"));

        RacingResult racingResult = racingGame.race();

        List<Car> winners = racingResult.getWinnerCars();
        assertThat(winners)
                .hasSize(2)
                .extracting(Car::getName)
                .contains("a", "b");
    }

    private static RoundResult getRoundResult(RacingResult racingResult, int round){
        return racingResult.getRoundResults()
                .stream()
                .filter(roundResult -> (roundResult.getRound() == round))
                .findFirst()
                .orElseThrow();
    }

    private static int getPositionByName(RoundResult roundResult, String name) {
        return roundResult.getRacingCars()
                .stream()
                .filter(car -> car.getName().equals(name))
                .mapToInt(Car::getPosition)
                .findFirst()
                .orElseThrow();
    }
}
