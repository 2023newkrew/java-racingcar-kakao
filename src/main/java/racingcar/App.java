package racingcar;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        InputParser inputParser = new InputParser();
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        Referee referee = new Referee();

        RacingCar racingCar = new RacingCar(inputParser, randomNumberGenerator, referee, console);

        racingCar.run();
    }
}
