package racingcar;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.getInputCarNames();
        view.getInputRoundNum();
        view.runRound();
        view.printWinner();
    }
}
