package racingcar;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class RacingGameTest {

    private Method getWinners;
    private Field carList;

    @BeforeEach
    void setUp() throws NoSuchFieldException, NoSuchMethodException {
        getWinners = RacingGame.class.getDeclaredMethod("getWinners");
        carList = RacingGame.class.getDeclaredField("carList");

        getWinners.setAccessible(true);
        carList.setAccessible(true);
    }

    @Test
    void makeCarsTest() {
        RacingGame racingGame = new RacingGame(List.of("car1", "car2", "car3"), 5);
        List<String> expected = new ArrayList<>(List.of("car1", "car2", "car3"));

        for (int i = 0; i < 3; i++) {
            assertThat(racingGame.getCarList().get(i).getName()).isEqualTo(expected.get(i));
        }
    }

    @Test
    void countTurnTest() {
        RacingGame racingGame = new RacingGame(List.of("car1", "car2", "car3"), 5);
        racingGame.play();

        assertThat(racingGame.getTurn()).isEqualTo(0);
    }

    @Test
    void getWinnersTest() throws InvocationTargetException, IllegalAccessException {
        RacingGame racingGame = new RacingGame(new ArrayList<>(), 5);

        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("car1", 5));
        testCarList.add(new Car("car2", 6));
        testCarList.add(new Car("car3", 7));

        carList.set(racingGame, testCarList);

        assertThat(getWinners.invoke(racingGame)).isEqualTo(List.of("car3"));

    }

    @Test
    void coWinnerTest() throws InvocationTargetException, IllegalAccessException {
        RacingGame racingGame = new RacingGame(new ArrayList<>(), 5);

        List<Car> testCarList = new ArrayList<>();
        testCarList.add(new Car("car1", 7));
        testCarList.add(new Car("car2", 6));
        testCarList.add(new Car("car3", 7));

        carList.set(racingGame, testCarList);

        assertThat(getWinners.invoke(racingGame)).isEqualTo(List.of("car1", "car3"));

    }
}