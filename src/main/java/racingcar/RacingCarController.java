package racingcar;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingCarController {
    private static final int MAX_COUNT = 100;
    private static final int MIN_COUNT = 0;

    private RacingCarModel model;
    private final RacingCarView view;

    public static RacingCarController create() {
        return new RacingCarController(RacingCarView.create());
    }

    public static RacingCarController from(RacingCarView view) {
        return new RacingCarController(view);
    }

    private RacingCarController(RacingCarView view) {
        this.view = view;
    }

    public void start() {
        createModel();
        simulate();
        printWinner();
    }

    private void createModel() {
        while (Objects.isNull(model)) {
            tryCreateModel();
        }
    }

    private void tryCreateModel() {
        try {
            createModelByInput();
        } catch (RuntimeException ex) {
            view.printError(ex.getMessage());
        }
    }

    private void createModelByInput() {
        List<String> names = inputNames();
        List<Car> cars = createCarsFromNames(names);
        model = RacingCarModel.from(cars);
    }

    private List<String> inputNames() {
        String nameLine = view.inputNameLine();
        return RacingCarModel.parseNames(nameLine);
    }

    private static List<Car> createCarsFromNames(List<String> names) {
        return names.stream()
                .map(RacingCarController::createCar)
                .collect(Collectors.toList());
    }

    private static Car createCar(String name) {
        return Car.of(name, Engine.defaultEngine);
    }

    private void simulate() {
        int count = inputCount();
        view.printResultText();
        for (int i = 0; i < count; ++i) {
            model.progress();
            view.printProgressResult(model.getCarInfos());
        }
    }

    private int inputCount() {
        Integer count;
        do {
            count = tryInputCount();
        } while (Objects.isNull(count));
        return count;
    }

    Integer tryInputCount() {
        try {
            int count = view.inputCount();
            checkCountIsInRange(count);
            return count;
        } catch (RuntimeException e) {
            view.printError(e.getMessage());
            return null;
        }
    }

    private static void checkCountIsInRange(int count) {
        if (MAX_COUNT < count) {
            throw new RuntimeException(String.format("count is too big. must be less than %d. your count: %s", MAX_COUNT, count));
        }
        if (MIN_COUNT > count) {
            throw new RuntimeException(String.format("count is too small. must be less than %d. your count: %s", MIN_COUNT, count));
        }
    }

    private void printWinner() {
        view.printWinners(model.getWinners());
    }
}
