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



}