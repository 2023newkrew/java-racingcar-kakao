package racing.service;

import org.junit.jupiter.api.Test;
import racing.model.Car;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingSplitterTest {
    private final RacingSplitter racingSplitter;

    RacingSplitterTest(){
        racingSplitter = new RacingSplitter();
    }

    @Test
    void Car_이름이_컴마로_구분된_문자열이_입력될_때_Car_리스트를_반환(){
        //given
        String input = "aaa,bbb,ccc";
        List<Car> expected = new ArrayList<>();
        expected.add(new Car("aaa", 0));
        expected.add(new Car("bbb", 0));
        expected.add(new Car("ccc", 0));

        //when
        List<Car> result = racingSplitter.split(input);

        //then
        assertThat(result).hasSameElementsAs(expected);
    }
}
