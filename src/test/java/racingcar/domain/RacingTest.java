package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class RacingTest {
    @Test
    void oneWinnerTest() {
        Car[] cars = new Car[5];
        cars[0] = new Car("a", (a)->2);
        cars[1] = new Car("b", (a)->2);
        cars[2] = new Car("c", (a)->6);
        cars[3] = new Car("d", (a)->2);
        cars[4] = new Car("e", (a)->2);

        Racing racing = new Racing.Builder()
                .addCars(cars)
                .setRounds(5)
                .build();
        while(!racing.isEnd()){
            racing.proceedRound();
        }

        Assertions.assertThat(racing.getWinners()).containsExactly(cars[2]);
    }

    @Test
    void pluralWinnersTest(){
        Car[] cars = new Car[5];
        cars[0] = new Car("a", (a)->2);
        cars[1] = new Car("b", (a)->6);
        cars[2] = new Car("c", (a)->6);
        cars[3] = new Car("d", (a)->2);
        cars[4] = new Car("e", (a)->6);

        Racing racing = new Racing.Builder()
                .addCars(cars)
                .setRounds(5)
                .build();
        while(!racing.isEnd()){
            racing.proceedRound();
        }
        Assertions.assertThat(racing.getWinners()).containsExactly(cars[1], cars[2], cars[4]);
    }

    @Test
    void exceptionWhenProceedRoundNotRemainingRound(){
        Racing racing = new Racing.Builder()
                .addCars(new String[]{"a", "b", "c", "d", "e"})
                .setRounds(5)
                .build();
        assertThatThrownBy(()->{
            for (int i=1;i<=6;i++){
                racing.proceedRound();
            }
        }).isInstanceOf(InvalidRacingConditionException.class)
                .hasMessageStartingWith("1");
    }

    @Test
    void exceptionWhenGetWinnersRemainingRound(){
        Racing racing = new Racing.Builder()
                .addCars(new String[]{"a", "b", "c", "d", "e"})
                .setRounds(5)
                .build();
        for (int i=1;i<=4;i++){
            racing.proceedRound();
        }
        assertThatThrownBy(()->{
            Car[] winners = racing.getWinners();
        }).isInstanceOf(InvalidRacingConditionException.class)
                .hasMessageStartingWith("2");
    }

    @Test
    void exceptionWhenNoRounds(){
        assertThatThrownBy(()->{
            Racing racing = new Racing.Builder()
                    .addCars(new String[]{"a", "b", "c", "d", "e"})
                    .setRounds(0)
                    .build();
        }).isInstanceOf(InvalidRacingConditionException.class)
                .hasMessageStartingWith("3");
    }

    @Test
    void exceptionTooFewCars(){
        assertThatThrownBy(()->{
            Racing racing = new Racing.Builder()
                    .addCars(new String[]{"a"})
                    .setRounds(5)
                    .build();
        }).isInstanceOf(InvalidRacingConditionException.class)
                .hasMessageStartingWith("4");
    }

}
