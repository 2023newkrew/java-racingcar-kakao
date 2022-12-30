package racing.strategy.strategy;

import racing.strategy.interfaces.MovableStrategy;

public class AlwaysNotMovableStrategy implements MovableStrategy {
    @Override
    public boolean isMovable() {
        return false;
    }
}
