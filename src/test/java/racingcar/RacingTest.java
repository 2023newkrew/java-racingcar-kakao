package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void generateCarsArray() {
        Racing racing = new Racing();
        String[] names = new String[]{"aaa","bbb","ccc"};
        Car[] cars = racing.generateCars(names);
        Assertions.assertThat(cars.length).isEqualTo(3);

        for(int i =0; i<3; i++) {
            Assertions.assertThat(cars[i].toString()).isEqualTo(names[i]);
            Assertions.assertThat(cars[i].toStringWithPosition()).isEqualTo(names[i]+" : -");
        }
    }

    @Test
    void winnerTest() {
        Car[] cars = new Car[5];
        cars[0] = new Car("a");
        cars[1] = new Car("b");
        cars[2] = new Car("c");
        cars[3] = new Car("d");
        cars[4] = new Car("e");

        final int ROUND = 5;
        Racing racing = new Racing();
        for (int i = 0; i < ROUND; i++) {
            cars[0].move(bound -> 2);
            cars[1].move(bound -> 2);
            cars[2].move(bound -> 6);
            cars[3].move(bound -> 2);
            cars[4].move(bound -> 2);
        }

        Assertions.assertThat(racing.getWinner(cars).toStringWithPosition()).isEqualTo("c : ------");
    }

    @Test
    void winnersTest(){
        Car[] cars = new Car[5];
        cars[0] = new Car("a");
        cars[1] = new Car("b");
        cars[2] = new Car("c");
        cars[3] = new Car("d");
        cars[4] = new Car("e");

        final int ROUND = 5;
        Racing racing = new Racing();
        for (int i = 0; i < ROUND; i++) {
            cars[0].move(bound -> 2);
            cars[1].move(bound -> 6);
            cars[2].move(bound -> 6);
            cars[3].move(bound -> 2);
            cars[4].move(bound -> 6);
        }

        Assertions.assertThat(racing.getWinners(cars)).containsExactly(cars[1], cars[2], cars[4]);
    }
}
