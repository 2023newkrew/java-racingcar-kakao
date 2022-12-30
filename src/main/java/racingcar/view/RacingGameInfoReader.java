package racingcar.view;

import racingcar.domain.RacingCar;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameInfoReader {

    private static final RacingGameInfoReader instance = new RacingGameInfoReader();

    public RacingGameInfoReader() {
    }

    public static RacingGameInfoReader getInstance(){
        return instance;
    }

    public List<RacingCar> readRacingCars() {
        String[] racingCarNames = readNamesAndSplit();
        validateRacingCarNames(racingCarNames);
        return Arrays.stream(racingCarNames).map(RacingCar::new).collect(Collectors.toList());
    }

    private String[] readNamesAndSplit(){
        Scanner scanner = new Scanner(System.in);
        System.out.println(Message.NAME_INPUT_MESSAGE.getMessage());
        String input = scanner.next();
        return input.split(",");
    }

    private void validateRacingCarNames(String[] racingCarNames) {
        for (String racingCarName : racingCarNames) {
            validateRacingCarName(racingCarName);
        }
    }

    private void validateRacingCarName(String racingCarName) {
        if (racingCarName.isBlank() || racingCarName.length() > 5) {
            throw new IllegalArgumentException(Message.WRONG_NAME.getMessage());
        }
    }

    public int readRound() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(Message.ROUND_INPUT_MESSAGE.getMessage());
        int round = scanner.nextInt();
        return round;
    }
}
