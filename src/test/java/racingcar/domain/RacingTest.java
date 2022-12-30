package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RacingTest {

    private final List<Car> cars = Arrays.asList(new Car("aa"), new Car(1, "bb"), new Car(1, "cc"));

    @DisplayName("생성자로 차 리스트와 턴 수를 받는다.")
    @Test
    void constructRacingWithCarNamesAndTurn() {
        assertThatCode(() -> new Racing(cars, 2)).doesNotThrowAnyException();
    }

    @DisplayName("Racing의 현재 턴이 남아있으면 true를 반환한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4})
    void isRacing(int turn) {
        Racing racing = new Racing(cars, turn);

        assertThat(racing.isRacing()).isTrue();
    }

    @DisplayName("Racing의 현재 턴이 남아있지 않으면 false를 반환한다.")
    @Test
    void isNotRacing() {
        Racing racing = new Racing(cars, 0);

        assertThat(racing.isRacing()).isFalse();
    }

    @DisplayName("Racing의 proceedTurn이 실행되면 turn이 하나 줄어든다.")
    @Test
    void proceedTurn() {
        Racing racing = new Racing(cars, 1);
        racing.proceedTurn();
        assertThat(racing.isRacing()).isFalse();
    }

    // 새롭게 알게 된 사실
    // @BeforeEach를 통해 cars 를 초기화시키지 않기 때문에
    // 참조로 파라미터를 넘겨줄 때 영향으로 바로 위의 테스트의 proceedTurn() 과 꼬여서 position이 이상해질 줄 알았는데
    // 각 테스트 메소드 마다 멤버 변수를 초기화하는 듯하다.
    @DisplayName("현재 경주의 상태를 올바르게 반환해야 한다.")
    @Test
    void getRaceStatus() {
        Racing racing = new Racing(cars, 1, () -> true);
        List<Car> movedCarsByOne = cars.stream()
                .map(car -> new Car(car.getPosition() + 1, car.getName()))
                .collect(Collectors.toList());

        racing.proceedTurn();

        assertThat(racing.getRaceStatus()).isEqualTo(movedCarsByOne);
    }

    @DisplayName("우승자의 리스트를 반환해야 한다.")
    @Test
    void getWinners() {
        Racing racing = new Racing(cars, 2);
        List<Car> expectedWinners = Arrays.asList(new Car(1, "bb"), new Car(1, "cc"));

        assertThat(racing.getWinners()).isEqualTo(expectedWinners);
    }
}
