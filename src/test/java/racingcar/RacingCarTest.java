package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("0에서 9 사이에서 random값을 구한다.")
    void generateRandomNumber() {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

        assertThat(randomNumberGenerator.generateBetweenZeroAndNine())
                .isGreaterThanOrEqualTo(0)
                .isLessThan(10);
    }

    @Test
    @DisplayName("자동차는 random값이 4 이상일 경우 전진한다.")
    void moveIfRandomNumberIsGreaterThanEqualFour() {
        Car avante = new Car("avante");
        Car sonata = new Car("sonata");
        int randomNumber = 4;

        avante.move(randomNumber);
        sonata.move(randomNumber);
        sonata.move(randomNumber);

        CarDto avanteDto = avante.toDto();
        CarDto sonataDto = sonata.toDto();

        assertThat(avanteDto.getPosition()).isEqualTo(2);
        assertThat(sonataDto.getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차는 random값이 3 이하의 값일 경우 멈춘다.")
    void stopIfRandomNumberIsLessThanEqualThree() {
        Car avante = new Car("avante");
        Car sonata = new Car("sonata");
        int randomNumber = 3;

        avante.move(randomNumber);
        sonata.move(randomNumber);
        sonata.move(randomNumber);

        CarDto avanteDto = avante.toDto();
        CarDto sonataDto = sonata.toDto();

        assertThat(avanteDto.getPosition()).isOne();
        assertThat(sonataDto.getPosition()).isOne();
    }

    @Test
    @DisplayName("시도할 횟수만큼 게임을 진행한다.")
    void playGame() {
        int count = 5;
        List<CarDto> inputCars = List.of(new CarDto("avante"), new CarDto("sonata"));
        RacingCarGame racingCarGame = new RacingCarGame(inputCars, count);

        while (!racingCarGame.isFinish()) {
            racingCarGame.play();
        }

        assertThat(racingCarGame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("시도할 횟수만큼 게임 진행 시 매 시도마다 결과가 반환된다.")
    void returnIntermediateGameResult() {
        int count = 5;
        List<CarDto> inputCars = List.of(new CarDto("avante"), new CarDto("sonata"));
        RacingCarGame racingCarGame = new RacingCarGame(inputCars, count);

        while (!racingCarGame.isFinish()) {
            GameResult gameResult = racingCarGame.play();
            assertThat(gameResult).isNotNull();
            assertThat(gameResult.getCarStatusList()).hasSize(inputCars.size());
        }
    }

    @Test
    @DisplayName("자동차마다 이동한 거리를 비교해서 가장 많이 이동한 자동차들을 선정한다.")
    void selectWinner() {
        int count = 5;
        List<CarDto> inputCars = List.of(new CarDto("avante"), new CarDto("sonata"));
        RacingCarGame racingCarGame = new RacingCarGame(inputCars, count);

        while (!racingCarGame.isFinish()) {
            racingCarGame.play();
        }
        GameResult gameResult = racingCarGame.selectWinners();

        assertThat(gameResult).isNotNull();
        assertThat(gameResult.getCarStatusList()).isNotEmpty();
    }


}
