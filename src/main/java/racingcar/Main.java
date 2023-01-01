package racingcar;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.getInput();
        view.runRound();
        view.printWinner();
    }
}
