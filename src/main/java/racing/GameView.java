package racing;

import racing.domain.Game;
import racing.util.PrintUtils;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

import static racing.util.PrintUtils.*;


public class GameView {

    private final Scanner scanner;
    private final Game game;
    private int tryNum;

    private static final String REQUEST_CAR_INPUT = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
    private static final String REQUEST_TRY_NUM_INPUT = "시도할 회수는 몇회인가요?";

    public GameView(Game game) {
        this.game = game;
        this.scanner = new Scanner(System.in);
    }

    public void init() {
        receiveCarNamesFromUser();
        receiveTryNumFromUser();
    }

    private void receiveCarNamesFromUser() {
        System.out.println(REQUEST_CAR_INPUT);
        game.initialize(scanner.nextLine());
    }


    private void receiveTryNumFromUser() {
        System.out.println(REQUEST_TRY_NUM_INPUT);
        tryNum = scanner.nextInt();
    }

    public void gameStart() {
        System.out.println("실행 결과");
        IntStream.range(0, tryNum)
                .forEach(i -> gamePlay());
    }


    public void gamePlay() {
        game.play();
        Map<String, Integer> status = game.getStatus();
        for (Map.Entry<String, Integer> entry  : status.entrySet()) {
            System.out.println(entry.getKey() + " : " + getHyphen(entry.getValue()));
        }
        System.out.println();
    }

    public void gameFinish() {
        List<String> winners = game.decideWinners();
        System.out.println(String.join(", ", winners) + " 가 최종 우승했습니다.");
    }
}
