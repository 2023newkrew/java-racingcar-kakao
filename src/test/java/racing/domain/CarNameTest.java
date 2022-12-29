package racing.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CarNameTest {
    private static final String NULL_OR_BLANK_ARGUMENT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private static final String TOO_LONG_NAME_EXCEPTION_MESSAGE = "[ERROR] 이름의 길이는 최대 5글자까지만 가능합니다.";

    @DisplayName("name 인자가 null이거나 blank인 경우 예외가 발생한다.")
    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {" ", "   "})
    void name_인자가_null이거나_blank인_경우_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NULL_OR_BLANK_ARGUMENT_EXCEPTION_MESSAGE);
    }

    @DisplayName("이름 길이가 5 초과인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"123455", "가나다라마바사"})
    void 이름_길이가_5_초과인_경우_예외가_발생한다(String name) {
        assertThatThrownBy(() -> new CarName(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(TOO_LONG_NAME_EXCEPTION_MESSAGE);
    }

    @DisplayName("이름 길이가 1 이상 5 이하인 경우 예외가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"12345", "가나다"})
    void 이름_길이가_1_이상_5_이하인_경우_예외가_발생하지_않는다(String name) {
        assertThat(new CarName(name).toString())
                .isEqualTo(name);
    }

    @DisplayName("String name이 동등하면 Carname 객체도 동등하다")
    @Test
    void String_name이_동등하면_CarName_객체도_동등하다() {
        CarName carName1 = new CarName("12345");
        CarName carName2 = new CarName(new String("12345"));
        CarName carName3 = new CarName("  12345 ");
        Assertions.assertAll(
                () -> assertThat(carName1.equals(carName2)).isEqualTo(true),
                () -> assertThat(carName2.equals(carName3)).isEqualTo(true),
                () -> assertThat(carName3.equals(carName1)).isEqualTo(true)
        );
    }

    @DisplayName("String name이 동등하지 않으면 Carname 객체도 동등하지 않다")
    @Test
    void String_name이_동등하지_않으면_CarName_객체도_동등하지_않다() {
        CarName carName1 = new CarName("12345");
        CarName carName2 = new CarName(new String("1345"));
        CarName carName3 = new CarName("  1 345 ");
        Assertions.assertAll(
                () -> assertThat(carName1.equals(carName2)).isEqualTo(false),
                () -> assertThat(carName2.equals(carName3)).isEqualTo(false),
                () -> assertThat(carName3.equals(carName1)).isEqualTo(false)
        );
    }
}
