package racingcar;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RacingCarControllerTest {

    @Mock
    RacingCarView view;

    @TestInstance(TestInstance.Lifecycle.PER_CLASS)
    @Nested
    class tryInputCount {
        @ParameterizedTest
        @ValueSource(ints = {0, 1, 5, 50, 99, 100})
        void should_getCount_when_countIsInRange(int inputCount) {
            when(view.inputCount()).thenReturn(inputCount);
            RacingCarController controller = RacingCarController.from(view);
            Integer result = controller.tryInputCount();
            assertThat(result).isEqualTo(inputCount);
        }

        @ParameterizedTest
        @ValueSource(ints = {-100, -20, -1, 101, 102, 9999})
        void should_returnNull_when_countIsOutOfRange(int inputCount) {
            when(view.inputCount()).thenReturn(inputCount);
            RacingCarController controller = RacingCarController.from(view);
            Integer result = controller.tryInputCount();
            assertThat(result).isNull();
        }
    }
}