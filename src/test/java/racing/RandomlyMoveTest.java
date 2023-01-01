package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.RandomlyMove;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomlyMoveTest {

    @DisplayName("4 미만의 숫자에서 전진 여부가 거짓으로 판단되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    public void carStopTest(int numberUnderFour) {
        RandomlyMove randomlyMove = new RandomlyMove() {
            @Override
            protected int createRandomNumber() {
                return numberUnderFour;
            }
        };
        assertThat(randomlyMove.movable()).isEqualTo(false);
    }

    @DisplayName("3 초과의 숫자에서 전진 여부가 참으로 판단되는지 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    public void carMoveTest(int numberOverThree) {
        RandomlyMove randomlyMove = new RandomlyMove() {
            @Override
            protected int createRandomNumber() {
                return numberOverThree;
            }
        };
        assertThat(randomlyMove.movable()).isEqualTo(true);
    }

}
