package racingcar;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        view.input();
        view.runRound();
        view.printWinner();
    }
}
