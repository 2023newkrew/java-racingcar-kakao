package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;
    private Car[] cars;

    @BeforeEach
    void setUp() {
        cars = new Car[]{new Car("pobi", 5), new Car("crong", 4), new Car("honux", 5)};
        racing = new Racing("pobi,crong,honux", "5");
    }

//    @DisplayName("이름 배열로 자동차 배열을 생성한 후 길이가 일치하는지 테스트")
//    @Test
//    public void makeCarListTest() {
//        String[] names = new String[]{"pobi", "crong", "honux"};
//        Car[] cars = racing.makeCarList(names);
//        assertThat(cars.length).isEqualTo(names.length);
//    }

    @DisplayName("자동차 배열에서 최대 포지션을 제대로 구하는지 테스트")
    @Test
    public void getMaxPositionTest() {
        assertThat(racing.getMaxPosition()).isEqualTo(5);
    }

//    @DisplayName("자동차 배열에서 우승자를 제대로 구하는지 테스트")
//    @Test
//    public void decideWinnersTest() {
//        assertThat(racing.decideWinners()).isEqualTo(Arrays.asList("pobi", "honux"));
//    }

//    @DisplayName("우승자 목록이 제대로 갱신되는지 테스트")
//    @Test
//    public void addWinnerTest() {
//        List<String> winners = new ArrayList<>();
//
//        winners = racing.addWinner(winners, "honux");
//        assertThat(winners.size()).isEqualTo(1);
//        winners = racing.addWinner(winners, null);
//        assertThat(winners.size()).isEqualTo(1);
//    }
}
