package racing.domain.tactic;

public final class RandomTacticStrategy implements GameTacticStrategy {

    @Override
    public Integer generateScore() {
        return (int) (Math.random() * 9);
    }
}
