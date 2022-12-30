package racing_car;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing_car.model.Car;
import racing_car.model.Racing;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

public class RacingTest {
    /*
    # GameControl 클래스가 갖춰야 할 요소
    - 쉼표로 구분된 자동차 목록으로 자동차들을 생성한다.
    - 0부터 9사이의 random 값을 생성하여 Car 객체에 전달한다.
    - 사용자가 입력한 숫자만큼 자동차들을 이동할 기회를 가진다.
    - 경주가 끝나고 우승한 자동차를 선정해야 한다.
    */

    static Racing racing;

    @BeforeEach
    void createGameControl(){
        racing = new Racing();
    }

    @Test
    @DisplayName("쉼표로 구분된 자동차 목록으로 자동차들 생성")
    void createCars() {
        String testNames = "pobi,crong,honux";
        racing.createCars(testNames);
        assertArrayEquals(racing.getCars(), new Car[] {
                new Car("pobi"),
                new Car("crong"),
                new Car("honux")
        });
    }

    @Test
    @DisplayName("0부터 9사이의 random 값 생성")
    void randomValue() {
        for (int i = 0; i < 1000; i++) {
            int value = racing.generateValue();
            assertThat(value<=9 && value>=0).isTrue();
        }
    }

    @Test
    @DisplayName("입력 횟수 만큼 자동차를 움직이려 시도")
    void race() {
        racing = new Racing(){
            @Override
            public int generateValue() {
                return 5;
            }
        };
        String testNames = "pobi,crong";
        int round = 3;
        racing.createCars(testNames);
        racing.setRound(round);

        while(!racing.isEnd()){
            racing.race();
        }

        assertThat(racing.getCars()[0].distance()).isEqualTo(round);
    }

    @Test
    @DisplayName("우승자 구하기")
    void getWinner() {
        String testNames = "pobi,crong,honux,ryan,chun,jordy";
        int[] distances = new int[] {1, 5, 2, 5, 4, 5};
        racing.createCars(testNames, distances);

        Car[] cars = racing.getCars();
        Car[] winners = racing.getWinners(cars);

        assertArrayEquals(new Car[] {
                cars[1], cars[3], cars[5]
        }, winners);
    }

}
