package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingCarTest {

    @Test
    @DisplayName("자동차의 이름을 부여한다.")
    void giveACarName() {
        String carName = "avante";
        Car car = new Car(carName);

        assertThat(car.isSameName(carName)).isTrue();
    }

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

        assertThat(avanteDto.getPosition()).isEqualTo(1);
        assertThat(sonataDto.getPosition()).isEqualTo(2);
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

        assertThat(avanteDto.getPosition()).isZero();
        assertThat(sonataDto.getPosition()).isZero();
    }

    @Test
    @DisplayName("시도할 횟수만큼 게임을 진행한다.")
    void playGame() {
        int count = 5;
        List<Car> list = List.of(new Car("avante"), new Car("sonata"));
        RacingCarGame racingCarGame = new RacingCarGame(list, count);

        while (!racingCarGame.isFinish()) {
            racingCarGame.play();
        }

        assertThat(racingCarGame.isFinish()).isTrue();
    }

    @Test
    @DisplayName("자동차마다 이동한 거리를 비교해서 가장 많이 이동한 자동차들을 선정한다.")
    void selectWinner() {
        int count = 5;
        List<Car> list = List.of(new Car("avante"), new Car("sonata"));
        RacingCarGame racingCarGame = new RacingCarGame(list, count);

        while (!racingCarGame.isFinish()) {
            racingCarGame.play();
        }

        assertThat(racingCarGame.selectWinners()).isNotEmpty();
    }


}
