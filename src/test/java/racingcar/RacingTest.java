package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class RacingTest {
    @Test
    void generateCarsArray() {
        Racing racing = new Racing();
        String[] names = new String[]{"aaa","bbb","ccc"};

        racing.generateCars(names);
        Car[] cars = racing.cars();
        Assertions.assertThat(cars.length).isEqualTo(3);

        for(int i =0; i<3; i++) {
            Assertions.assertThat(cars[i].toString()).isEqualTo(names[i]);
            Assertions.assertThat(cars[i].toStringWithPosition()).isEqualTo(names[i]+" : -");
        }
    }

    @Test
    void winnerTest() {
        String[] names = new String[] {"a", "b", "c", "d", "e"};

        final int ROUND = 5;
        Racing racing = new Racing();
        racing.generateCars(names);
        Car[] cars = racing.cars();
        for (int i = 0; i < ROUND; i++) {
            cars[0].move(bound -> 2);
            cars[1].move(bound -> 2);
            cars[2].move(bound -> 6);
            cars[3].move(bound -> 2);
            cars[4].move(bound -> 2);
        }

        Assertions.assertThat(racing.getOneWinner().toStringWithPosition()).isEqualTo("c : ------");
    }

    @Test
    void winnersTest(){
        String[] names = new String[] {"a", "b", "c", "d", "e"};

        final int ROUND = 5;
        Racing racing = new Racing();
        racing.generateCars(names);
        Car[] cars = racing.cars();
        for (int i = 0; i < ROUND; i++) {
            cars[0].move(bound -> 2);
            cars[1].move(bound -> 6);
            cars[2].move(bound -> 6);
            cars[3].move(bound -> 2);
            cars[4].move(bound -> 6);
        }

        Assertions.assertThat(racing.getTotalWinners()).containsExactly(cars[1], cars[2], cars[4]);
    }
}
