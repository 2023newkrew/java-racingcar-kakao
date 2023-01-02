package addcal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalNumTest {
    @Nested
    @DisplayName("유효성 테스트")
    class validNumTest {
        @Test
        @DisplayName("성공")
        void success() {
            assertThatCode(() -> new CalNum(30)).doesNotThrowAnyException();
        }

        @Test
        @DisplayName("실패")
        void fail() {
            assertThatIllegalArgumentException().isThrownBy(() -> new CalNum(-30));
        }
    }

    @Test
    @DisplayName("덧셈 테스트")
    void addTest() {
        CalNum num1 = new CalNum(10);
        CalNum num2 = new CalNum(20);
        num1.add(num2);
        assertEquals(num1.getNum(), 30);
    }
}
