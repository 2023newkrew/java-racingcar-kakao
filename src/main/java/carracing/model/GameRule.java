package carracing.model;

import carracing.common.exception.InvalidInputFormatException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameRule {
    private static final Integer STANDARD_SCORE = 4;

    private static final GamePlayerStrategy GAME_PLAYER_STRATEGY = new RandomPlayerStrategy();

    public static Boolean isAbleToProceed() {
        return GAME_PLAYER_STRATEGY.generateScore() >= STANDARD_SCORE;
    }

    public static List<RacingPlayer> getWinners(List<RacingPlayer> players) {
        Integer maxScore = players.stream()
            .mapToInt(RacingPlayer::getScore)
            .max()
            .orElseThrow(InvalidInputFormatException::new);

        return players.stream()
            .filter(p -> Objects.equals(p.getScore(), maxScore))
            .collect(Collectors.toList());
    }

    private GameRule() {}
}
