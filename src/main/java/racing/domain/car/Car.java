package racing.domain.car;

import org.jetbrains.annotations.NotNull;
import racing.strategy.interfaces.MovableStrategy;
import racing.strategy.strategy.RandomNumberMovableStrategy;

public class Car implements Comparable<Car> {
    private static final int DEFAULT_POSITION = 0;

    private final Name name;
    private int position;
    private MovableStrategy movableStrategy;

    public Car(Builder builder) {
        this.name = builder.name;
        this.position = builder.position;
        this.movableStrategy = builder.movableStrategy;

    }

    public String getName() {
        return name.getName();
    }

    public int getPosition() {
        return position;
    }

    public void movePositionIfMovable() {
        if(movableStrategy.isMovable()) {
            this.position++;
        }
    }

    @Override
    public int compareTo(@NotNull Car car) {
        return this.position - car.position;
    }

    public boolean isEqualPosition(Car car) {
        return compareTo(car) == 0;
    }

    public static class Builder {
        private final Name name;
        private int position = DEFAULT_POSITION;
        private MovableStrategy movableStrategy = new RandomNumberMovableStrategy();

        public Builder(String name) {
            this.name = new Name(name);
        }

        public Builder position(int position) {
            this.position = position;
            return this;
        }

        public Builder movableStrategy(MovableStrategy movableStrategy) {
            this.movableStrategy = movableStrategy;
            return this;
        }

        public Car build() {
            return new Car(this);
        }
    }
}
