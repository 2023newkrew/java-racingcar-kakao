package racingcar.step2.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @ValueSource(strings = {"pobi","huny"})
    @ParameterizedTest
    void 자동차_이름은_5자_이하여야_한다(final String name){
        Assertions.assertDoesNotThrow(() -> new Car(name));
    }

    @Test
    void 자동차_이름은_5자를_초과하면_예외가_발생해야_한다(){
        assertThatThrownBy(() -> new Car("동해물과 백두산이")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @NullAndEmptySource
    @ParameterizedTest
    void 자동차_이름이_공백인_경우_예외가_발생한다(final String name){
        assertThatThrownBy(() -> new Car(name)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 자동차의_현재_위치를_알_수_있다(){
        final Car car = new Car("huny", 5);
        Assertions.assertEquals(car.getPosition(), 5);
    }
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @ParameterizedTest
    void 숫자가_4_이상이면_자동차는_전진한다(final int condition){
        final Car car = new Car("huny");
        car.move(condition);
        Assertions.assertEquals(car.getPosition(), 2);
    }

    @ValueSource(ints = {0, 1, 2, 3})
    @ParameterizedTest
    void 숫자가_3_아러이면_자동차는_전진하지_않는다(final int condition){
        final Car car = new Car("huny");
        car.move(condition);
        Assertions.assertEquals(car.getPosition(), 1);
    }


}