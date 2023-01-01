package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.CarList;
import racing.domain.Result;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @DisplayName("우승자 테스트")
    @Test
    public void getWinnerTest() {
        Result result = new Result();
        int maxPosition = 5;
        Car carA = new Car(maxPosition, "pobi");
        Car carB = new Car(maxPosition - 1, "crong");
        Car carC = new Car(maxPosition, "honux");
        Car[] cars = new Car[] {carA, carB, carC};
        CarList carList = new CarList(cars);
        assertThat(result.getWinner(carList)).isEqualTo(Arrays.asList("pobi", "honux"));
    }

}
