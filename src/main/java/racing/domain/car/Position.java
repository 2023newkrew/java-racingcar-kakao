package racing.domain.car;

public class Position {
    private static final int DEFAULT_POSITION = 0;

    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(int position) {
        this.position = position;
    }

    public void increase() {
        position++;
    }

    public int compare(Position position) {
        return this.position - position.position;
    }

    public int getPosition() {
        return position;
    }
}
