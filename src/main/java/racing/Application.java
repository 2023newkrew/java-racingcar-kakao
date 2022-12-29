package racing;

import racing.Controller.RacingController;
import racing.domain.Simulator;

import java.util.Random;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        RacingController racingController = new RacingController();
        racingController.run();
    }
}
