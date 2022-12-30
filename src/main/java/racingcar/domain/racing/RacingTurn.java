package racingcar.domain.racing;

import racingcar.util.StringParser;

public class RacingTurn {
    private int turn;

    public RacingTurn(String input) {
        int parsedTurn = StringParser.parseTurn(input);

        if (!isValidTurn(parsedTurn)) throw new IllegalArgumentException();

        turn = parsedTurn;
    }

    public static boolean isValidTurn(int turn) {
        return turn > 0;
    }

    public void proceed() {
        turn--;
    }

    public boolean isEnd() {
        return turn == 0;
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof RacingTurn)) return false;

        RacingTurn cp = (RacingTurn) obj;

        return this.turn == cp.turn;
    }
}
