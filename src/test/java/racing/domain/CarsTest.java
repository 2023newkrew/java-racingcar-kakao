package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CarsTest {
    private static final String NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";

    @DisplayName("생성자의 carNames 인자가 null인 경우 예외가 발생한다.")
    @Test
    void 생성자의_carNames_인자가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @DisplayName("생성자의 carNames 인자가 empty list인 경우 예외가 발생한다.")
    @Test
    void 생성자의_carNames_인자가_empty_list인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Cars(new ArrayList<>()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_EMPTY_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @DisplayName("우승자가 한 대인 경우 우승자를 반환한다.")
    @Test
    void 우승자가_한_대인_경우_정확히_찾아낸다() {
        CarName carName1 = new CarName("kyne");
        Car car1 = new Car(carName1, new Position(1));
        CarName carName2 = new CarName("pobi");
        Car car2 = new Car(carName2, new Position(2));
        CarName carName3 = new CarName("kane");
        Car car3 = new Car(carName3, new Position(3));
        Cars cars = new Cars(List.of(car1, car2, car3));
        assertThat(cars.getWinners()).isEqualTo(List.of(carName3));
    }

    @DisplayName("우승자가 여러 대인 경우 우승자를 반환한다.")
    @Test
    void 우승자가_두_대_이상인_경우_정확히_찾아낸다() {
        CarName carName1 = new CarName("kyne");
        Car car1 = new Car(carName1, new Position(5));

        CarName carName2 = new CarName("pobi");
        Car car2 = new Car(carName2, new Position(2));

        CarName carName3 = new CarName("kane");
        Car car3 = new Car(carName3, new Position(5));

        Cars cars = new Cars(List.of(car1, car2, car3));
        assertThat(cars.getWinners()).isEqualTo(List.of(carName1, carName3));
    }
}
