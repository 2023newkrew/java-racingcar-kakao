package racing.strategy.strategy;

import racing.strategy.interfaces.MovableStrategy;

public class AlwaysMovableStrategy implements MovableStrategy {
    @Override
    public boolean isMovable() {
        return true;
    }
}
