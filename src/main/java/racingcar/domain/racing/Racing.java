package racingcar.domain.racing;

import racingcar.domain.car.CarDTO;
import racingcar.util.StringParser;

import java.util.List;

public class Racing {
    //    private final List<Car> cars = new ArrayList<>();
    private final RacingCar cars;
    private final RacingTurn turn;

    public Racing(String nameInput, String turn) {
        this(StringParser.parse(nameInput), turn);
    }

    public Racing(List<String> names, String turn) {
        this.cars = new RacingCar(names);
        this.turn = new RacingTurn(turn);
    }

    public List<CarDTO> proceedTurn() {
        cars.move();
        turn.proceed();

        return cars.getCarDTOs();
    }

    public boolean isEnd() {
        return turn.isEnd();
    }

    public RacingWinner getWinners() {
        if (!isEnd()) throw new IllegalStateException();

        return new RacingWinner(cars.getCarDTOs());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Racing)) return false;

        Racing cp = (Racing) obj;

        return cars.equals(cp.cars) && turn.equals(cp.turn);
    }
}
