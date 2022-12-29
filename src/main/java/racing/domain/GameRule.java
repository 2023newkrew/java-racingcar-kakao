package racing.domain;

import racing.common.exception.InvalidInputFormatException;
import racing.domain.player.RacingPlayer;
import racing.domain.tactic.GameTacticStrategy;
import racing.domain.tactic.RandomTacticStrategy;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameRule {
    private static final Integer STANDARD_SCORE = 4;

    private static final GameTacticStrategy GAME_PLAYER_STRATEGY = new RandomTacticStrategy();

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
