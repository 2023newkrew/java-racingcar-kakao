import racing.controller.GameController;
import racing.controller.RacingController;

public class Application {
    public static void main(String[] args) {

//        StringParser parser = new StringParser();
//        CalculatorRunner runner = new CalculatorRunner(parser);
//
//        runner.run();

        GameController racingController = new RacingController();
        racingController.run();
    }
}
