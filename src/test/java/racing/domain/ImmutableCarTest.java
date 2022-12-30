package racing.domain;

import static org.junit.jupiter.api.Assertions.*;
import static racing.constant.MessageConstant.INVALID_METHOD_CALL_EXCEPTION;

import org.junit.jupiter.api.Test;

class ImmutableCarTest {

    @Test
    void 객체의_상태를_변경하는_메서드는_호출할_수_없다() {
        ImmutableCar immutableCar = new ImmutableCar(new RacingCar("test"));
        Throwable exception = assertThrows(UnsupportedOperationException.class, immutableCar::move);
        assertEquals(INVALID_METHOD_CALL_EXCEPTION, exception.getMessage());
    }

}