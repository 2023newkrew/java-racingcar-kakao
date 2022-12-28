package carracing.model;

public class RandomPlayerStrategy implements GamePlayerStrategy {

    @Override
    public Integer generateScore() {
        return (int) (Math.random() * 9);
    }
}
