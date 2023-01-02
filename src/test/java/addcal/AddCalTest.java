package addcal;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AddCalTest {

    @Test
    @DisplayName("AddCal 객체 생성 테스트")
    void generateInstanceTest() {
        assertThatCode(() -> new AddCal("123,45")).doesNotThrowAnyException();
    }

    @Nested
    @DisplayName("구분자 테스트")
    class parseSeparatorTest {
        @Test
        @DisplayName("기본 구분자")
        void defaultSeparatorTest() {
            assertThat(new AddCal("123,456,662").getSeparator()).isEqualTo(",|;");
        }

        @Test
        @DisplayName("커스텀 구분자")
        void customSeparatorTest() {
            assertThat(new AddCal("//;\n123;456;662").getSeparator()).isEqualTo(";");
        }

        @Test
        @DisplayName("커스텀 구분자2")
        void customSeparatorTest2() {
            assertThat(new AddCal("//T\n1T23T456T662").getSeparator()).isEqualTo("T");
        }
    }

    @Test
    void isBlankTest() {
        assertTrue(AddCal.isBlank(""));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4", "2,2,2,2,2", "3,5,2", "3,3,1,3"})
    void sumTest(String inputString) {
        assertThat(new AddCal(inputString).getResultSum()).isEqualTo(10);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,-3", "-1,-3,5", "a,3,2", "12,-1231,-123,-13", "-1", "a"})
    void Test(String input) {
        assertThatCode(() -> new AddCal(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void SplitTest() {
        String inputString = "123,45";
        AddCal addCal = new AddCal(inputString);
        List<CalNum> calNumList = addCal.getNumList();
        List<CalNum> tmp = new ArrayList(List.of(new CalNum(123), new CalNum(45)));
        assertThat(calNumList).usingRecursiveComparison().isEqualTo(tmp);
    }

}
