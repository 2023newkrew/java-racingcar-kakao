package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {

    private final int CAR_INITIAL_DISTANCE = 1;
    private Game game;
    private int gameRoundCnt;
    private List<String> carNames;

    @BeforeEach
    void setup() {
        game = new Game();
        carNames = List.of("carName1", "carName2");
        gameRoundCnt = 5;
    }

    @Test
    void 게임_시작시_자동차의_이름과_실행횟수를_받아_자동차_목록과_실행횟수를_저장한다() {
        GameInfo gameInfo = game.init(carNames, gameRoundCnt);

        for (int i = 0; i < gameInfo.getCarInfos().size(); i++) {
            assertThat(gameInfo.getCarInfos().get(i).getName()).isEqualTo(carNames.get(i));
            assertThat(gameInfo.getCarInfos().get(i).getDistance()).isEqualTo(CAR_INITIAL_DISTANCE);
        }
        assertThat(gameInfo.getLeftRoundCnt()).isEqualTo(gameRoundCnt);
    }

    @Test
    void 게임의_한_실행횟수마다_자동차들을_움직이고_자동차들_정보와_남은_실행횟수가_반환된다() {
        game.init(carNames, gameRoundCnt);

        GameInfo gameInfo = game.runRound();

        assertThat(gameInfo.getLeftRoundCnt())
                .isEqualTo(gameRoundCnt - 1);
        for (int i = 0; i < gameInfo.getCarInfos().size(); i++) {
            assertThat(gameInfo.getCarInfos().get(i).getName())
                    .isEqualTo(carNames.get(i));
            assertThat(gameInfo.getCarInfos().get(i).getDistance())
                    .isBetween(CAR_INITIAL_DISTANCE, CAR_INITIAL_DISTANCE +1);
        }
    }

    @Test
    void 게임의_우승자는_한명일_수_있다() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        while(cars.get(0).getDistance() < 3) {
            cars.get(0).move();
        }
        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.getWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
        assertThat(winners.get(0).getDistance()).isEqualTo(3);
    }

    @Test
    void 게임의_우승자는_여러명일_수_있다() {
        List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        while(cars.get(0).getDistance() < 5) {
            cars.get(0).move();
        }
        while(cars.get(1).getDistance() < 5) {
            cars.get(1).move();
        }
        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.getWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
        assertThat(winners.get(1).getName()).isEqualTo("car2");
        assertThat(winners.get(0).getDistance()).isEqualTo(5);
        assertThat(winners.get(1).getDistance()).isEqualTo(5);
    }
}
