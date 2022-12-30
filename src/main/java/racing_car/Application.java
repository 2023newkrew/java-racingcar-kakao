package racing_car;

import racing_car.model.Car;
import racing_car.model.Racing;
import racing_car.view.GameView;

import java.util.Arrays;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        String names = GameView.getNames();
        int round = GameView.getRound();

        Racing racing = new Racing(names, round);

        System.out.println("\n실행결과");
        while(!racing.isEnd()){
            racing.race();
            GameView.printGameProcess(racing.getCars());
        }

        Car[] winners = racing.getWinners();
        GameView.printGameResult(winners);
    }
}
