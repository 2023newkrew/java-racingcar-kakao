package racing.service;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import racing.domain.CarName;
import racing.domain.Cars;
import racing.domain.GameRepeat;
import racing.dto.CarDTO;
import racing.dto.CarDtoDistanceComparator;

public class Game {
    private static final String CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE = "[ERROR] 이름은 중복될 수 없습니다.";
    private static final String NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE = "[ERROR] 잘못된 입력입니다.";
    private final Comparator<CarDTO> distanceComparator = new CarDtoDistanceComparator();
    private final Cars cars;
    private GameRepeat gameRepeat;


    public Game(final List<String> rawCarNames) {
        if (Objects.isNull(rawCarNames) || rawCarNames.isEmpty()) {
            throw new IllegalArgumentException(NULL_OR_EMPTY_INPUT_EXCEPTION_MESSAGE);
        }
        validateUniqueness(rawCarNames);
        List<CarName> carNames = wrapCarNames(rawCarNames);
        cars = new Cars(carNames);
    }

    private void validateUniqueness(List<String> rawCarNames) {
        int distinctNameCount = getDistinctNameCount(rawCarNames);
        if (distinctNameCount != rawCarNames.size()) {
            throw new IllegalArgumentException(CAR_NAME_DUPLICATE_EXCEPTION_MESSAGE);
        }
    }

    private int getDistinctNameCount(List<String> names) {
        return names.stream()
                .map(String::trim)
                .collect(Collectors.toSet())
                .size();
    }

    private List<CarName> wrapCarNames(List<String> rawCarNames) {
        return rawCarNames.stream()
                .map(CarName::new)
                .collect(Collectors.toList());
    }

    public void setRepeat(final int repeat) {
        this.gameRepeat = new GameRepeat(repeat);
    }

    public boolean isOver() {
        return !(gameRepeat.hasRemaining());
    }

    public void play() {
        gameRepeat.reduce();
        cars.play();
    }

    public List<CarDTO> getStatus() {
        return cars.getCarDtoList();
    }

    public List<CarName> getWinners() {
        return cars.getWinners(distanceComparator);
    }
}
