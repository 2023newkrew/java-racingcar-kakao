package racingCar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class GameTest {
    private Car[] cars;

    @BeforeEach
    void before() {
        cars = new Car[]{
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        };
    }

    @Test
    void mustMoveCar() {
        Game game = new Game(5, cars);
        game.moveCar(0, 4);
        assertThat(cars[0].getPosition()).isEqualTo(2);
    }

    @Test
    void mustNotMoveCar() {
        Game game = new Game(5, cars);
        game.moveCar(1, 3);
        assertThat(cars[1].getPosition()).isEqualTo(1);
    }

    @Test
    void findWinner() {
        Game game = new Game(5, cars);
        cars[0].move();
        Car[] winners = game.findWinners();
        assertThat(winners).isEqualTo(new Car[]{cars[0]});
    }

    @Test
    void findMultipleWinners() {
        Game game = new Game(5, cars);
        cars[1].move();
        cars[2].move();
        Car[] winners = game.findWinners();
        assertThat(winners).isEqualTo(new Car[]{cars[1], cars[2]});
    }
}
