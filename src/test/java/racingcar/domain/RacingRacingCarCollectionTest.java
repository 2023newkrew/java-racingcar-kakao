package racingcar.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import racingcar.domain.car.RacingCar;
import racingcar.domain.collection.RacingCarCollection;
import racingcar.domain.dto.RacingCarDto;
import racingcar.exception.BusinessException;
import racingcar.exception.ErrorCode;

import java.util.ArrayList;
import java.util.List;

public class RacingRacingCarCollectionTest {

    @Test
    void duplicatedNameException() {
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new MockRacingCarImpl("lion"));
        cars.add(new MockRacingCarImpl("lion"));
        Assertions.assertThatExceptionOfType(BusinessException.class)
                .isThrownBy(() -> new RacingCarCollection(cars))
                .withMessage(ErrorCode.DUPLICATE_CAR_NAME_EXCEPTION.getMessage());
    }

    @Test
    void selectWinners() {
        //given
        ArrayList<RacingCar> cars = new ArrayList<>();
        cars.add(new MockRacingCarImpl("lion"));
        cars.add(new MockRacingCarImpl("jordy"));
        cars.add(new MockRacingCarImpl("muzi"));
        RacingCarCollection racingCarCollection = new RacingCarCollection(cars);
        cars.get(0)
                .move();

        //when
        List<RacingCarDto> winner = racingCarCollection.selectWinners();

        //then
        Assertions.assertThat(winner)
                .hasSize(1);
    }
}
