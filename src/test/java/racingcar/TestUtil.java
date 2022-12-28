package racingcar;

import org.assertj.core.api.ThrowableAssert;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class TestUtil {

    public static void throwRuntimeExceptionBy(ThrowableAssert.ThrowingCallable callable) {
        assertThatThrownBy(callable).isInstanceOf(RuntimeException.class);
    }
}
