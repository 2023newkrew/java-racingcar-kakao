package racing.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class RacingServiceTest {
    private RacingService racingService;

    @BeforeEach
    void setUp(){
        racingService = new RacingService();
    }

    @Test
    @DisplayName("Cars 생성 테스트")
    void givenRacingCarString_whenRacingCarSplit_thenReturnCarList(){
        String input = "aaa,bbb,ccc";
        List<Car> carList = List.of(
                new Car("aaa"),
                new Car("bbb"),
                new Car("ccc")
        );
        Cars expected = new Cars(carList);
        Cars result = racingService.createCarsByNames(input);

        assertThat(result).hasSameElementsAs(expected);
    }
}
