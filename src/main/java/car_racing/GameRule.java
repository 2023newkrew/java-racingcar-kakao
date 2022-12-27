package car_racing;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class GameRule {
    private static final Integer STANDARD_SCORE = 4;
    private static final ScoreStrategy SCORE_STRATEGY = new RandomScoreStrategy();

    private GameRule() {}

    public static Boolean isAbleToProceed() {
        return SCORE_STRATEGY.generateScore() >= STANDARD_SCORE;
    }

    public static RacingPlayer[] getWinners(List<RacingPlayer> players) {
        Integer maxPosition = players.stream().max(Comparator.comparingInt(RacingPlayer::getPosition)).get().getPosition();
        return players.stream().filter(p -> Objects.equals(p.getPosition(), maxPosition)).toArray(RacingPlayer[]::new);
    }
}
