package racing.domain.player;

import org.jetbrains.annotations.NotNull;

public final class Car implements RacingPlayer {
    private final String name;

    private Integer position;
    public Car(String name) {
        this.name = name;
        this.position = 1;
    }

    @Override
    public void proceedNextTurn(@NotNull Boolean proceed) {
        if (proceed) {
            this.position += 1;
        }
    }

    @Override
    public Integer getScore() {
        return this.position;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return name + " : " + "-".repeat(position);
    }
}
