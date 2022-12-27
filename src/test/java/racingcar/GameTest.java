package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    void init() {
        GameInfo gameInfo = game.init(carNames, roundInput);

        for (int i = 0; i < gameInfo.getCarInfos().size(); i++) {
            assertThat(gameInfo.getCarInfos().get(i).getName()).isEqualTo(carNames.get(i));
            assertThat(gameInfo.getCarInfos().get(i).getDistance()).isEqualTo(INITIAL_DISTANCE);
        }
        assertThat(gameInfo.getLeftRoundCnt()).isEqualTo(roundInput);
    }

    @Test
    void runRound() {
        game.init(carNames, roundInput);

        GameInfo gameInfo = game.runRound();

        assertThat(gameInfo.getLeftRoundCnt()).isEqualTo(roundInput - 1);
        for (int i = 0; i < gameInfo.getCarInfos().size(); i++) {
            assertThat(gameInfo.getCarInfos().get(i).getName()).isEqualTo(carNames.get(i));
            assertThat(gameInfo.getCarInfos().get(i).getDistance()).isBetween(INITIAL_DISTANCE, INITIAL_DISTANCE+1);
        }
    }

    @Test
    void findWinners() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));

        while(cars.get(0).getDistance() < 3) {
            cars.get(0).move();
        }

        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.findWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(1);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
        assertThat(winners.get(0).getDistance()).isEqualTo(3);
    }

    @Test
    void findWinners_plural() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("car1"));
        cars.add(new Car("car2"));
        cars.add(new Car("car3"));

        while(cars.get(0).getDistance() < 3) {
            cars.get(0).move();
        }
        while(cars.get(1).getDistance() < 3) {
            cars.get(1).move();
        }

        GameInfo gameInfo = new GameInfo(cars, 0);

        List<CarInfo> winners = game.findWinners(gameInfo);

        assertThat(winners.size()).isEqualTo(2);
        assertThat(winners.get(0).getName()).isEqualTo("car1");
        assertThat(winners.get(1).getName()).isEqualTo("car2");
        assertThat(winners.get(0).getDistance()).isEqualTo(3);
        assertThat(winners.get(1).getDistance()).isEqualTo(3);
    }
}
