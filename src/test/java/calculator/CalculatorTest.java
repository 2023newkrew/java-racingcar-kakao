package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

public class CalculatorTest {
    private Method splitString;
    private Method checkDelimiter;
    private Method addNum;

    @BeforeEach
    void setUp() throws NoSuchMethodException {
        splitString = Calculator.class.getDeclaredMethod("splitString");
        checkDelimiter = Calculator.class.getDeclaredMethod("checkDelimiter");
        addNum = Calculator.class.getDeclaredMethod("addNum");

        splitString.setAccessible(true);
        checkDelimiter.setAccessible(true);
        addNum.setAccessible(true);
    }

    @Test
    @DisplayName("구분자를 추가하지 않은 경우 입력 구분 수행")
    void splitTest() throws InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator("1,2,3");

        splitString.invoke(calculator);

        assertThat(calculator.getSplitedNum()).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("구분자를 추가한 경우 입력 구분 수행")
    void delimiterSplitTest() throws InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator("//+\n1,2+3");

        checkDelimiter.invoke(calculator);
        splitString.invoke(calculator);

        assertThat(calculator.getSplitedNum()).isEqualTo(new String[]{"1", "2", "3"});
    }

    @Test
    @DisplayName("구분자 추가 수행")
    void checkDelimiterTest() throws InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator("//+\n1+2+3");

        checkDelimiter.invoke(calculator);

        assertThat(calculator.getInput()).isEqualTo("1,2,3");
    }

    @Test
    @DisplayName("구분자를 추가하지 않은 경우 덧셈 수행")
    void addNumTest() throws InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator("1,2:3");

        checkDelimiter.invoke(calculator);
        splitString.invoke(calculator);

        assertThat(addNum.invoke(calculator)).isEqualTo(6);
    }

    @Test
    @DisplayName("구분자를 추가한 경우 덧셈 수행")
    void delimiterAddNumTest() throws InvocationTargetException, IllegalAccessException {
        Calculator calculator = new Calculator("//+\n1,2:3+4");

        checkDelimiter.invoke(calculator);
        splitString.invoke(calculator);

        assertThat(addNum.invoke(calculator)).isEqualTo(10);
    }

    @Test
    @DisplayName("음수가 포함될 경우 예외 발생")
    void negativeNumThrowExceptionTest() {
        Calculator calculator = new Calculator("-1,2,3");

        try {
            splitString.invoke(calculator);
        } catch (InvocationTargetException | IllegalAccessException e) {
            assertThat(e.getCause().getClass()).isEqualTo(RuntimeException.class);
            assertThat(e.getCause().getMessage()).isEqualTo("0부터 9 사이의 수만 입력할 수 있습니다.");
        }
    }

    @Test
    @DisplayName("문자가 포함될 경우 예외 발생")
    void CharacterThrowExceptionTest() {
        Calculator calculator = new Calculator("a,2,3");

        try {
            splitString.invoke(calculator);
        } catch (InvocationTargetException | IllegalAccessException e) {
            assertThat(e.getCause().getClass()).isEqualTo(RuntimeException.class);
            assertThat(e.getCause().getMessage()).isEqualTo("0부터 9 사이의 수만 입력할 수 있습니다.");
        }
    }
}
