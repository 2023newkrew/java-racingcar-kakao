package string_addition_calculator;// 1, 2, 3 -> 6

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AdditionTest {
    @Test
    void add_three_test() {
        Addition addition = new Addition();
        AdditionResult result = addition.addThree(1, 2, 3);
        assertThat(result.getValue()).isEqualTo(6);
    }

    @Test
    void add_two_test() {
        Addition addition = new Addition();
        AdditionResult result = addition.addTwo(1, 2);
        assertThat(result.getValue()).isEqualTo(3);
    }

    @Test
    void add_null_test() {
        Addition addition = new Addition();
        AdditionResult result = addition.addNull();
        assertThat(result.getValue()).isEqualTo(0);
    }

    @Test
    void add_three_to_all_test() {
        Addition addition = new Addition();
        AdditionResult result = addition.addAll(1, 2, 3);
        assertThat(result.getValue()).isEqualTo(6);
    }

    @Test
    void add_two_to_all_test() {
        Addition addition = new Addition();
        AdditionResult result = addition.addAll(1, 2);
        assertThat(result.getValue()).isEqualTo(3);
    }

    @Test
    void add_null_to_all_test() {
        Addition addition = new Addition();
        AdditionResult result = addition.addAll();
        assertThat(result.getValue()).isEqualTo(0);
    }

    @Test
    void add_all_test() {
        Addition addition = new Addition();
        AdditionResult result = addition.addAll(1,2,3,4,5,6,7,8,9,10);
        assertThat(result.getValue()).isEqualTo(55);
    }
}
