package racing.domain;

import java.util.Random;

public class Car {

    private final static int INITIAL_POSITION = 1;
    private final int MAX_NAME_LENGTH = 5;
    private final static int MAX_VALUE = 10;
    private final static int THRESHOLD = 4;

    private int position;
    private String name;

    public Car(int position, String name) {
        this.position = position;
        if (name == null || name.isBlank()) {
            throw new RuntimeException("빈칸은 입력할 수 없습니다.");
        }
        if (name.length() > MAX_NAME_LENGTH) {
            throw new RuntimeException("다섯 글자 이하로 입력해주세요.");
        }
        this.name = name;
    }

    public Car(String name) {
        this(INITIAL_POSITION, name);
    }

    public int createRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_VALUE);
    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= THRESHOLD;
    }

    public void moveCar(boolean move) {
        if(move) {
            position++;
        }
    }

    public void carEvent() {
        moveCar(isMove(createRandomNumber()));
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public String getWinnerName(int maxPosition) {
        if(maxPosition == position) {
            return name;
        }
        return null;
    }

    public String getLog() {
        return name + " : " + "-".repeat(position);
    }

}
