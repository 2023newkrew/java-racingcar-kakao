package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarList;
import racing.domain.Racing;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingTest {

    @DisplayName("정지/전진을 한 번 마친 자동차 배열의 길이가 유지되었는지 테스트")
    @Test
    public void oneCycleTest() {
        Racing racing = new Racing();
        String names = "pobi,crong,honux";
        CarList carList = new CarList(names);
        int beforeCarCount = carList.getLength();
        carList = racing.oneCycle(carList);
        int afterCarCount = carList.getLength();
        assertThat(afterCarCount).isEqualTo(beforeCarCount);
    }

}
