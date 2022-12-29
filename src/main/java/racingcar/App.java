package racingcar;

public class App {
    public static void main(String[] args) {
        Console console = new Console();
        InputHandler inputHandler = new InputHandler();
        Referee referee = new Referee();

        RacingCarService racingCarService = new RacingCarService(inputHandler, referee, console);

        racingCarService.run();
    }
}
