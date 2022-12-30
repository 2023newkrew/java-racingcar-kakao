package racing.domain;

public class Position implements Comparable<Position> {
    private static final String NEGATIVE_POSITION_EXCEPTION_MESSAGE = "[ERROR] 위치는 음수일 수 없습니다.";
    private static final int DEFAULT_POSITION = 0;
    private static final int MIN_POSITION = 0;
    private static final int DEFAULT_DISTANCE = 1;
    private int position;

    public Position() {
        this(DEFAULT_POSITION);
    }

    public Position(final int position) {
        validateNonNegative(position);
        this.position = position;
    }

    private void validateNonNegative(final int position) {
        if (position < MIN_POSITION) {
            throw new IllegalArgumentException(NEGATIVE_POSITION_EXCEPTION_MESSAGE);
        }
    }

    public int getPosition() {
        return position;
    }

    public void increase() {
        increase(DEFAULT_DISTANCE);
    }

    public void increase(final int distance) {
        position += distance;
    }

    @Override
    public int compareTo(Position opponent) {
        return Integer.compare(position, opponent.position);
    }
}
