package car_racing.model;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GameRule {
    private static final Integer STANDARD_SCORE = 4;

    private static final GamePlayStrategy gp = new RandomPlayStrategy();

    public static Boolean isAbleToProceed() {
        return gp.generateScore() >= STANDARD_SCORE;
    }

    public static RacingPlayer[] getWinners(List<RacingPlayer> players) {
        Integer maxScore = players.stream().max(Comparator.comparingInt(RacingPlayer::getScore)).get().getScore();
        return players.stream().filter(p -> Objects.equals(p.getScore(), maxScore)).toArray(RacingPlayer[]::new);
    }

    private GameRule() {}
}
