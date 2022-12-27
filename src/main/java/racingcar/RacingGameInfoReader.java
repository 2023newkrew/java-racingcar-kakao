package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameInfoReader {

    private final Scanner scanner;

    public RacingGameInfoReader() {
        this.scanner = new Scanner(System.in);
    }

    public List<RacingCar> readRacingCars() {
        String input = scanner.next();
        String[] racingCarNames = input.split(",");
        validateRacingCarNames(racingCarNames);
        return Arrays.stream(racingCarNames).map(RacingCar::new).collect(Collectors.toList());
    }

    public void close() {
        if (scanner != null) {
            scanner.close();
        }
    }

    private void validateRacingCarNames(String[] racingCarNames) {
        for (String racingCarName : racingCarNames) {
            validateRacingCarName(racingCarName);
        }
    }

    private void validateRacingCarName(String racingCarName) {
        if (racingCarName.isBlank() || racingCarName.length() > 5) {
            throw new IllegalArgumentException("잘못된 이름입니다!");
        }
    }

    public int readRound() {
        return scanner.nextInt();
    }
}
