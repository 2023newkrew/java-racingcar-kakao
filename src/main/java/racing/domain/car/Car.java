package racing.domain.car;

import org.jetbrains.annotations.NotNull;
import racing.strategy.interfaces.MovableStrategy;
import racing.strategy.strategy.RandomNumberMovableStrategy;

public class Car implements Comparable<Car> {
    private final Name name;
    private Position position;
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
        return position.getPosition();
    }

    public void movePositionIfMovable() {
        if(movableStrategy.isMovable()) {
            position.increase();
        }
    }

    @Override
    public int compareTo(@NotNull Car car) {
        return position.compare(car.position);
    }

    public boolean isEqualPosition(Car car) {
        return position.compare(car.position) == 0;
    }

    public static class Builder {
        private final Name name;
        private Position position = new Position();
        private MovableStrategy movableStrategy = new RandomNumberMovableStrategy();

        public Builder(String name) {
            this.name = new Name(name);
        }

        public Builder position(int position) {
            this.position = new Position(position);
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
