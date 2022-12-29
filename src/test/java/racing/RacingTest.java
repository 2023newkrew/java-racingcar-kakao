package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarBuilder;
import racing.domain.Racing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {
    private Racing racing;

    @BeforeEach
    void setUp() {
        racing = new Racing();
    }

    @Test
    public void nameSplitTest() {
        String inputString = "pobi,crong,honux";
        assertThat(racing.nameSplit(inputString)).isEqualTo(new String[] {"pobi", "crong", "honux"});
    }

    @Test
    public void nameExceptionTest() {
        String wrong_name = "leopss";
        String correct_name = "pobi";
        assertThrows(RuntimeException.class, () -> {racing.nameException(wrong_name);});
        assertDoesNotThrow(() -> {racing.nameException(correct_name);});
    }

    @Test
    public void makeCarListTest() {
        String[] names = new String[] {"pobi", "crong", "honux"};
        Car[] cars = racing.makeCarList(names);
        assertThat(cars.length).isEqualTo(names.length);
    }

    @Test
    public void getWinnerTest() {
        Car carA = new CarBuilder().name("pobi").position(5).buildCar();
        Car carB = new CarBuilder().name("crong").position(4).buildCar();
        Car carC = new CarBuilder().name("honux").position(5).buildCar();
        Car[] cars = new Car[] {carA, carB, carC};
        assertThat(racing.getWinner(cars)).isEqualTo(Arrays.asList("pobi", "honux"));
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
