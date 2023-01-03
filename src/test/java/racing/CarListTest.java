package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.CarList;

import static org.assertj.core.api.Assertions.assertThat;

public class CarListTest {

    @DisplayName("이름 입력을 통해 변환한 자동차 배열의 길이가 유지되었는지 테스트")
    @Test
    public void createCarListTest() {
        String names = "pobi,crong,honux";
        int carCount = names.split(",").length;
        CarList carList = new CarList(names);
        assertThat(carList.getLength()).isEqualTo(carCount);
    }

}
