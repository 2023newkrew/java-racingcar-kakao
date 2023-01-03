package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameTest {

    private static final int CAR_INITIAL_DISTANCE = 1;
    private static final int CAR_MOVE_STANDARD = 4;

    private Game game;
    private int gameRoundCnt;
    private List<String> carNames;

    private void 자동차를_특정_거리까지_움직인다(Car car, int distance) {
        while(car.getDistance()!=distance) {
            car.move(CAR_MOVE_STANDARD);
        }
    }

    @BeforeEach
    void setup() {
        game = new Game();
        carNames = List.of("carName1", "carName2");
        gameRoundCnt = 5;
    }

    @Test
    void 게임_시작시_자동차의_이름과_실행횟수를_받아_자동차_목록과_실행횟수를_저장한다() {
        GameInfo gameInfo = game.init(carNames, gameRoundCnt);
        List<CarInfo> carInfos = gameInfo.getCarInfos();

        for (int i = 0; i < carInfos.size(); i++) {
            assertThat(carInfos.get(i).getName()).isEqualTo(carNames.get(i));
            assertThat(carInfos.get(i).getDistance()).isEqualTo(CAR_INITIAL_DISTANCE);
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
        int distance = 3;
        List<Car> cars = List.of(new Car("car1"), new Car("car2"));
        자동차를_특정_거리까지_움직인다(cars.get(0), distance);

        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.getWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo(cars.get(0).getName());
        assertThat(winners.get(0).getDistance()).isEqualTo(distance);
    }

    @Test
    void 게임의_우승자는_여러명일_수_있다() {
        int distance = 5;
        List<Car> cars = List.of(new Car("car1"), new Car("car2"), new Car("car3"));
        자동차를_특정_거리까지_움직인다(cars.get(0), distance);
        자동차를_특정_거리까지_움직인다(cars.get(1), distance);
        자동차를_특정_거리까지_움직인다(cars.get(2), distance-1);

        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.getWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo(cars.get(0).getName());
        assertThat(winners.get(1).getName()).isEqualTo(cars.get(1).getName());
        assertThat(winners.get(0).getDistance()).isEqualTo(distance);
        assertThat(winners.get(1).getDistance()).isEqualTo(distance);
    }
}
