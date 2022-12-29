package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public class RacingTest {
    @DisplayName("주어진 이름에 따라 Cars 가 잘 생성되는가")
    @Test
    void 주어진_이름에_따라_Cars_생성() {
        String[] names = new String[]{"aaa","bbb","ccc"};

        Racing racing = new Racing(names);
        Car[] cars = racing.cars();
        Assertions.assertThat(cars.length).isEqualTo(3);

        for(int i =0; i<3; i++) {
            Assertions.assertThat(cars[i].name()).isEqualTo(names[i]);
            Assertions.assertThat(cars[i].position()).isEqualTo(0);
        }
    }

    @DisplayName("한 명의 승자가 의도한대로 결정되는가")
    @Test
    void 무조건_이기는_한_명의_우승자() {
        String[] names = new String[] {"a", "b", "c", "d", "e"};

        final int ROUND = 5;
        Racing racing = new Racing(names);
        Car[] cars = racing.cars();
        for (int i = 0; i < ROUND; i++) {
            cars[0].move(bound -> 2);
            cars[1].move(bound -> 2);
            cars[2].move(bound -> 6);
            cars[3].move(bound -> 2);
            cars[4].move(bound -> 2);
        }

        Assertions.assertThat(racing.getOneWinner().position()).isEqualTo(ROUND);
    }

    @DisplayName("여러 명의 승자가 의도한대로 결정되는가")
    @Test
    void 무조건_이기는_최종_우승자들(){
        String[] names = new String[] {"a", "b", "c", "d", "e"};

        final int ROUND = 5;
        Racing racing = new Racing(names);
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
