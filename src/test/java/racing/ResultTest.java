package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Result;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    private Result result;

    @BeforeEach
    void setUp() {
        result = new Result();
    }

    @DisplayName("우승자 테스트")
    @Test
    public void getWinnerTest() {
        Car carA = new Car(5, "pobi");
        Car carB = new Car(4, "crong");
        Car carC = new Car(5, "honux");
        Car[] cars = new Car[] {carA, carB, carC};
        assertThat(result.getWinner(cars)).isEqualTo(Arrays.asList("pobi", "honux"));
    }

}
