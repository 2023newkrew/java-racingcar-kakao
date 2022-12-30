package racingcar.view;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @DisplayName("입력 받은 이름은 콤마로 구분하고 앞뒤 공백을 제거한다.")
    @Test
    void splitByCommaAndTrim() {
        InputStream inputStream = new ByteArrayInputStream("ethan    ,\t\tverus  , pobi   \t\n".getBytes());
        InputView inputView = new InputView(System.out, inputStream);

        List<String> names = inputView.inputCarNames();

        Assertions.assertThat(names)
                .hasSize(3)
                .contains("ethan", "verus", "pobi");
    }

    @DisplayName("공백을 제거하고 중복된 자동차 이름을 입력할 수 없다.")
    @Test
    void inputDistinctNames() {
        InputStream inputStream = new ByteArrayInputStream("verus, verus, pobi".getBytes());
        InputView inputView = new InputView(System.out, inputStream);

        Assertions.assertThatThrownBy(inputView::inputCarNames)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("시도 횟수를 입력한다.")
    @Test
    void inputTryCount() {
        InputStream inputStream = new ByteArrayInputStream("012".getBytes());
        InputView inputView = new InputView(System.out, inputStream);

        int tryCount = inputView.inputMaxTryCount();

        Assertions.assertThat(tryCount).isEqualTo(12);
    }

    @DisplayName("시도 횟수는 숫자여야 한다.")
    @Test
    void inputNotNumberTryCount() {
        InputStream inputStream = new ByteArrayInputStream("abc".getBytes());
        InputView inputView = new InputView(System.out, inputStream);

        Assertions.assertThatThrownBy(inputView::inputMaxTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("100 이상의 시도 횟수를 입력 시 예외가 발생한다.")
    @Test
    void inputOver100TryNumber() {
        InputStream inputStream = new ByteArrayInputStream("100".getBytes());
        InputView inputView = new InputView(System.out, inputStream);

        Assertions.assertThatThrownBy(inputView::inputMaxTryCount)
                .isInstanceOf(IllegalArgumentException.class);
    }
}
