package CarRacing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    //자동차들 각각에 전진 이벤트 부여 메소드 작성
    //시도 회수만큼 이벤트 발생하는 메소드 작성
    //출력 메소드 작성
    //우승자 판별 로직 작성
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
    }
}
