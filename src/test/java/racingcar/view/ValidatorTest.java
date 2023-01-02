package racingcar.view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.ClassBasedNavigableIterableAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ValidatorTest {
    @Test
    void 유효한_자동차_이름들인_경우_true_를_반환한다() {
        assertTrue(Validator.isValidCarNames(List.of("name1", "name2")));
        assertTrue(Validator.isValidCarNames(List.of("가나", "다라", "마바")));
    }

    @Test
    void 자동차_이름들_중_5자_초과_이름을_포함할_경우_false_를_반환한다() {
        assertFalse(Validator.isValidCarNames(List.of("abcdef", "gh")));
        assertFalse(Validator.isValidCarNames(List.of("가나", "다라", "마바사아자차")));
    }

    @ValueSource(ints = {0, 1, 5, 10, 100, 1000})
    @ParameterizedTest
    void 유효한_게임_실행횟수인_경우_true_를_반환한다(int roundCnt) {
        assertTrue(Validator.isValidGameRoundCnt(roundCnt));
    }

    @ValueSource(ints = {-1, -345, -9999})
    @ParameterizedTest
    void 게임_실행횟수가_음수인_경우_false_를_반환한다(int roundCnt) {
        assertFalse(Validator.isValidGameRoundCnt(roundCnt));
    }
}