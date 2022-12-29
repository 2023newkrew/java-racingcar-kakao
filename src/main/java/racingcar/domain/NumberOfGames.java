package racingcar.domain;

public class NumberOfGames {
    private int numberOfGames;

    public NumberOfGames(int numberOfGames) {
        this.numberOfGames = numberOfGames;
    }

    public boolean isGameEnd() {
        return numberOfGames == 0;
    }

    public void move() {
        numberOfGames--;
    }
}
