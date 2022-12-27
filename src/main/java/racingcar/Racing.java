package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    private List<Car> cars;
    private final RacingUI racingUi;
    private final RacingService racingService;

    Racing() {
        cars = new ArrayList<>();
        racingUi = new RacingUI();
        racingService = new RacingService();
    }

    public void makeCars(List<String> carNames) {
        for (String carName : carNames)
            this.cars.add(new Car(carName));
    }

    public int getCarNo() {
        return cars.size();
    }

    public void endTurn() {
        racingUi.displayPosition(getCarDTOs());
    }

    public List<CarDTO> getCarDTOs() {
        return cars.stream().map(e -> e.toDTO()).collect(Collectors.toList());
    }

    public void endRace() {
        List<String> result = racingService.getWinners(getCarDTOs());
        racingUi.displayWinner(result);
    }
}
