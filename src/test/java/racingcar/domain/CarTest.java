package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.lang.reflect.Field;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.RacingCar;

public class CarTest {


    @ParameterizedTest
    @ValueSource(strings = {"","russell"})
    public void 자동차이름이_공백이거나_6자이상이면_예외가_발생한다(String input){
        assertThatThrownBy(()->new RacingCar(input)).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    public void 자동차이름이_널이면_예외가_발생한다(){
        assertThatThrownBy(()->new RacingCar(null)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void moveTest(int input) {
        Car racingCar = new RacingCar("abc");
        racingCar.move(input);
        int dist = racingCar.getDistance();
        assertThat(dist).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void doNotMoveTest(int input) {
        Car racingCar = new RacingCar("abc");
        racingCar.move(input);
        int dist = racingCar.getDistance();
        assertThat(dist).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {10, -1})
    public void move함수에_범위외_값이_주어지면_예외가_발생한다(int input) {
        Car racingCar = new RacingCar("abc");
        Assertions.assertThatThrownBy(() -> racingCar.move(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abc", "def"})
    public void toStringTest(String input) {
        Car racingCar = new RacingCar(input);
        for (int i = 0; i < 3; i++) {
            racingCar.move(5);
            assertThat(racingCar.toString()).isEqualTo(input + " : " + "-".repeat(i + 1));
        }
    }


}
