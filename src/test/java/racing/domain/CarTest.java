package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void 자동차의_위치_기본값은_0입니다() {
        Car car = new Car("test");
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    void 자동차의_위치를_지정해서_생성할_수_있습니다() {
        Car car = new Car("test", 3);
        assertThat(car.getPosition()).isEqualTo(3);
    }

}