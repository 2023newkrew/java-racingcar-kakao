package calculator.delimiter;

import calculator.domain.calculator.delimiter.Delimiter;
import calculator.domain.calculator.delimiter.Delimiters;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitersTest {
    private Delimiters delimiters;

    @BeforeEach
    void setUp() {
        delimiters = new Delimiters();
    }

    @Test
    @DisplayName("Delimiter를 추가하는 테스트")
    public void add() throws NoSuchFieldException, IllegalAccessException {
        Delimiter delimiter = new Delimiter("?");
        delimiters.add(delimiter);
        assertThat(this.getDelimiters().size()).isEqualTo(3);
        assertThat(this.getDelimiters()).contains(delimiter);
    }

    @Test
    @DisplayName("기본 Regex 생성 테스트")
    public void getRegexWithDefaultDelimiter() {
        assertThat(delimiters.getRegex()).isEqualTo("[:,]");
    }

    @Test
    @DisplayName("커스텀 구분자가 추가된 Regex 생성 테스트")
    public void getRegexWithCustomDelimiter() {
        delimiters.add(new Delimiter("?"));
        assertThat(delimiters.getRegex()).isEqualTo("[:,?]");
    }

    @SuppressWarnings("unchecked")
    private List<Delimiter> getDelimiters() throws NoSuchFieldException, IllegalAccessException {
        Field field = delimiters.getClass()
                        .getDeclaredField("delimiters");
        field.setAccessible(true);
        return (List<Delimiter>) field.get(delimiters);
    }
}
