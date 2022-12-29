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
            Assertions.assertThat(cars[i].toStringOnlyName()).isEqualTo(names[i]);
            Assertions.assertThat(cars[i].toString()).isEqualTo(names[i]+" : -");
        }
    }

    @Test
    void winnerTest() {
        Car[] cars = new Car[5];
        cars[0] = new Car("a", (a)->2);
        cars[1] = new Car("b", (a)->2);
        cars[2] = new Car("c", (a)->6);
        cars[3] = new Car("d", (a)->2);
        cars[4] = new Car("e", (a)->2);

        Racing racing = new Racing();
        for (int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                cars[j].move();
            }
        }

        Assertions.assertThat(racing.getWinners(cars)).containsExactly(cars[2]);
    }

    @Test
    void winnersTest(){
        Car[] cars = new Car[5];
        cars[0] = new Car("a", (a)->2);
        cars[1] = new Car("b", (a)->6);
        cars[2] = new Car("c", (a)->6);
        cars[3] = new Car("d", (a)->2);
        cars[4] = new Car("e", (a)->6);

        Racing racing = new Racing();
        for (int i=0;i<5;i++) {
            for (int j = 0; j < 5; j++) {
                cars[j].move();
            }
        }

        Assertions.assertThat(racing.getWinners(cars)).containsExactly(cars[1], cars[2], cars[4]);
    }
}
