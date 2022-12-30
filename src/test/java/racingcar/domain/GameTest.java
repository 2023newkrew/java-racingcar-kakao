package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.dto.CarInfo;
import racingcar.dto.GameInfo;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {

    private final int INITIAL_DISTANCE = 1;
    Game game;
    int roundInput;
    List<String> carNames;

    @BeforeEach
    void setup() {
        game = new Game();
        carNames = List.of("name1", "name2");
        roundInput = 5;
    }

    @Test
    @DisplayName("게임을 초기화하면 차의 이름과 초기 거리, 남은 시도(라운드) 수가 설정된다")
    void init() {
        GameInfo gameInfo = game.init(carNames, roundInput);

        for (int i = 0; i < gameInfo.getCarInfos().size(); i++) {
            assertThat(gameInfo.getCarInfos().get(i).getName()).isEqualTo(carNames.get(i));
            assertThat(gameInfo.getCarInfos().get(i).getPosition()).isEqualTo(INITIAL_DISTANCE);
        }
        assertThat(gameInfo.getLeftRoundCnt()).isEqualTo(roundInput);
    }

    @Test
    @DisplayName("시도 1회당 남은 시도 수가 1씩 줄어들고 각 차들의 위치값이 0 또는 1씩 증가한다")
    void runRound() {
        game.init(carNames, roundInput);

        GameInfo gameInfo = game.runRound();

        assertThat(gameInfo.getLeftRoundCnt()).isEqualTo(roundInput - 1);
        for (int i = 0; i < gameInfo.getCarInfos().size(); i++) {
            assertThat(gameInfo.getCarInfos().get(i).getName()).isEqualTo(carNames.get(i));
            assertThat(gameInfo.getCarInfos().get(i).getPosition()).isBetween(INITIAL_DISTANCE, INITIAL_DISTANCE + 1);
        }
    }

    @Test
    @DisplayName("최대 위치는 모든 차들의 위치값 중 최대값이다")
    void getMaxPosition() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));

        for (int i = 0; i < 2; i++) {
            cars.get(0).move(() -> true);
        }
        GameInfo gameInfo = new GameInfo(cars, 0);
        int maxPosition = game.getMaxPosition(gameInfo);
        assertThat(maxPosition).isEqualTo(3);
    }

    @Test
    @DisplayName("가장 멀리간 차가 우승한다(단독우승)")
    void findWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));

        for (int i = 0; i < 2; i++) {
            cars.get(0).move(() -> true);
        }

        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.findWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
        assertThat(winners.get(0).getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("가장 멀리간 차가 우승한다(공동우승)")
    void findWinners_plural() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        for (int i = 0; i < 2; i++) {
            cars.get(0).move(() -> true);
        }
        for (int i = 0; i < 2; i++) {
            cars.get(1).move(() -> true);
        }

        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.findWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
        assertThat(winners.get(1).getName()).isEqualTo("car2");
        assertThat(winners.get(0).getPosition()).isEqualTo(3);
        assertThat(winners.get(1).getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("0에서 9 사이의 임의의 정수를 뽑는다")
    void pickRandomNumber() {
        assertThat(game.pickRandomNumber()).isBetween(0, 9);
    }
}