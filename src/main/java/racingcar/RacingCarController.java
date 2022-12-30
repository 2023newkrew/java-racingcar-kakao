package racingcar;

import racingcar.domain.Car;
import racingcar.domain.RacingCars;
import racingcar.domain.engine.EngineImpl;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarController {

    private static final String SEPARATOR = ",";

    private static final int MAX_COUNT = 100;

    private final RacingCarView view;

    public static RacingCarController create() {
        return new RacingCarController();
    }

    private RacingCarController() {
        view = RacingCarView.create();
    }

    public void start() {
        RacingCars racingCars = createRacingCars();
        simulate(racingCars);
        printWinner(racingCars);
    }

    private RacingCars createRacingCars() {
        RacingCars racingCars = null;
        while (Objects.isNull(racingCars)) {
            racingCars = tryCreateRacingCars();
        }
        return racingCars;
    }

    private RacingCars tryCreateRacingCars() {
        try {
            return createRacingCarsByInput();
        } catch (RuntimeException ex) {
            view.printError(ex.getMessage());
            return null;
        }
    }

    private RacingCars createRacingCarsByInput() {
        List<String> names = inputNames();
        List<Car> cars = createCarsFromNames(names);
        return RacingCars.from(cars);
    }

    private List<String> inputNames() {
        String nameLine = view.inputNameLine();
        return List.of(nameLine.split(SEPARATOR));
    }

    private static List<Car> createCarsFromNames(List<String> names) {
        return names.stream()
                .map(RacingCarController::createCar)
                .collect(Collectors.toList());
    }

    private static Car createCar(String name) {
        return Car.from(name, EngineImpl.getRandomEngine());
    }

    private void simulate(RacingCars racingCars) {
        int count = inputCount();
        view.printResultText();
        for (int i = 0; i < count; ++i) {
            racingCars.progress();
            view.printProgressResult(racingCars.getCarDtos());
        }
    }

    private int inputCount() {
        int count = 0;
        while (count == 0) {
            count = tryInputCount();
        }
        return count;
    }

    private int tryInputCount() {
        int count = view.inputCount();
        if (count > MAX_COUNT) {
            view.printError("Count too large.");
            return 0;
        }
        return count;
    }

    private void printWinner(RacingCars racingCars) {
        view.printWinners(racingCars.getWinners());
    }
}
