package CarRacing.domain;

import org.junit.jupiter.api.BeforeEach;
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

    @Test
    public void splitInputStringTest() {
        String inputString = "pobi,crong,honux";
        assertThat(racing.splitInputString(inputString)).isEqualTo(new String[] {"pobi", "crong", "honux"});
    }

    @Test
    public void checkCarNameLengthTest() {
        String wrong_name = "pororo";
        String correct_name = "pobi";
        assertThrows(RuntimeException.class, () -> {racing.checkCarNameLength(wrong_name);});
        assertDoesNotThrow(() -> {racing.checkCarNameLength(correct_name);});
    }

    @Test
    public void makeCarListTest() {
        String[] names = new String[] {"pobi", "crong", "honux"};
        Car[] cars = racing.makeCarList(names);
        assertThat(cars.length).isEqualTo(names.length);
    }

    @Test
    public void getMaxPositionTest() {
        assertThat(racing.getMaxPosition(cars)).isEqualTo(5);
    }

    @Test
    public void getWinnersTest() {
        assertThat(racing.getWinners(cars)).isEqualTo(Arrays.asList("pobi", "honux"));
    }

    @Test
    public void addWinnerTest() {
        List<String> winners = new ArrayList<>();

        winners = racing.addWinner(winners, "honux");
        assertThat(winners.size()).isEqualTo(1);
        winners = racing.addWinner(winners, null);
        assertThat(winners.size()).isEqualTo(1);
    }
}
