package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.dto.CarDTO;
import racing.movable.RandomlyMovable;

public class CarTest {
    private static final String DEFAULT_NAME = "kyne";
    private static final String NULL_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private Car car;
    private CarName carName;
    private RandomlyMovable randomlyMovable;

    @BeforeEach
    void init() {
        carName = new CarName(DEFAULT_NAME);
    }

    @DisplayName("생성자의 carName 인자가 null인 경우 예외가 발생한다.")
    @Test
    void 생성자의_carName_인자가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_ARGUMENT_EXCEPTION_MESSAGE);

        randomlyMovable = new RandomlyMovable();
        assertThatThrownBy(() -> new Car(null, randomlyMovable))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @DisplayName("생성자의 movable 인자가 null인 경우 예외가 발생한다.")
    @Test
    void 생성자의_movable_인자가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(carName, null, new Position()))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @DisplayName("생성자의 position 인자가 null인 경우 예외가 발생한다.")
    @Test
    void 생성자의_position_인자가_null인_경우_예외가_발생한다() {
        assertThatThrownBy(() -> new Car(carName, randomlyMovable, null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @DisplayName("movable의 isMoving 메서드가 false를 반환하면 이동하지 않는다.")
    @RepeatedTest(100)
    void movable의_isMoving_메서드가_false를_반환하면_이동하지_않는다() {
        car = new Car(carName, () -> false);
        car.move();
        assertThat(CarDTO.of(car).getPosition().getPosition()).isEqualTo(0);
    }

    @DisplayName("movable의 isMoving 메서드가 true를 반환하면 거리가 1 증가한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3, 4, 5})
    void movable의_isMoving_메서드가_true를_반환하면_거리가_1만큼_증가한다(int repeat) {
        car = new Car(carName, () -> true);
        for (int i = 0; i < repeat; i++) {
            car.move();
        }
        assertThat(CarDTO.of(car).getPosition().getPosition()).isEqualTo(repeat);
    }
}
