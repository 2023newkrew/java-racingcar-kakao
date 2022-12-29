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
        racing = new Racing();
        cars = new Car[] {new Car("pobi", 5), new Car("crong", 4), new Car("honux", 5)};
    }

    @DisplayName("입력 문자열을 잘 스플릿하는지 테스트")
    @Test
    public void splitInputStringTest() {
        String inputString = "pobi,crong,honux";
        assertThat(racing.splitInputString(inputString)).isEqualTo(new String[] {"pobi", "crong", "honux"});
    }

    @DisplayName("적절한 길이(1이상 5이하)의 자동차 이름 예외 처리 테스트")
    @Test
    public void checkCorrectCarNameLengthTest() {
        String correct_name = "pobi";
        assertDoesNotThrow(() -> {racing.checkCarNameLength(correct_name);});
    }

    @DisplayName("적절하지 않은 길이(0, 6이상)의 자동차 이름 예외 처리 테스트")
    @Test
    public void checkWrongCarNameLengthTest() {
        String wrong_name = "pororo";
        assertThrows(RuntimeException.class, () -> {racing.checkCarNameLength(wrong_name);});
    }

    @DisplayName("이름 배열로 자동차 배열을 생성한 후 길이가 일치하는지 테스트")
    @Test
    public void makeCarListTest() {
        String[] names = new String[] {"pobi", "crong", "honux"};
        Car[] cars = racing.makeCarList(names);
        assertThat(cars.length).isEqualTo(names.length);
    }

    @DisplayName("자동차 배열에서 최대 포지션을 제대로 구하는지 테스트")
    @Test
    public void getMaxPositionTest() {
        assertThat(racing.getMaxPosition(cars)).isEqualTo(5);
    }

    @DisplayName("자동차 배열에서 우승자를 제대로 구하는지 테스트")
    @Test
    public void getWinnersTest() {
        assertThat(racing.getWinners(cars)).isEqualTo(Arrays.asList("pobi", "honux"));
    }

    @DisplayName("우승자 목록이 제대로 갱신되는지 테스트")
    @Test
    public void addWinnerTest() {
        List<String> winners = new ArrayList<>();

        winners = racing.addWinner(winners, "honux");
        assertThat(winners.size()).isEqualTo(1);
        winners = racing.addWinner(winners, null);
        assertThat(winners.size()).isEqualTo(1);
    }
}
