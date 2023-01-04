package racingcar.view;

import racingcar.domain.RacingCar;
import racingcar.utils.CarNameValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingGameInfoReader {

    private static final RacingGameInfoReader instance = new RacingGameInfoReader(new Scanner(System.in));

    private final Scanner scanner;

    private RacingGameInfoReader(Scanner scanner) {
        this.scanner = scanner;
    }

    public static RacingGameInfoReader getInstance(){
        return instance;
    }

    public List<RacingCar> readRacingCars() {
        String[] racingCarNames = readNamesAndSplit();
        CarNameValidator.validateRacingCarNames(racingCarNames);
        return Arrays.stream(racingCarNames).map(RacingCar::new).collect(Collectors.toList());
    }

    private String[] readNamesAndSplit(){
        System.out.println(Message.NAME_INPUT_MESSAGE.getMessage());
        String input = scanner.next();
        return input.split(",");
    }

    public int readRound() {
        System.out.println(Message.ROUND_INPUT_MESSAGE.getMessage());
        int round = scanner.nextInt();
        return round;
    }
}
