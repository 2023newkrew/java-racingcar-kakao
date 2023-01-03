package racing.domain;

public class Car {

    private final static int INITIAL_POSITION = 1;
    private final int MAX_NAME_LENGTH = 5;

    private int position;
    private String name;

    public Car(int position, String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("빈칸은 입력할 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("다섯 글자 이하로 입력해주세요.");
        }
        this.position = position;
        this.name = name;
    }

    public Car(String name) {
        this(INITIAL_POSITION, name);
    }

    public void move(Move movingStrategy) {
        if (movingStrategy.movable()) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

}
