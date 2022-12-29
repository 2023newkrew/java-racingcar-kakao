/**
 * - 5자 이하로 이루어진 이름을 가진다
 * - 현재 자동차의 위치 정보를 가진다
 * - 자동차는 한 번에 한 칸 전진할 수 있다
 *  - 값이 4 이상일 경우 한 칸 전진한다
 *  - 값이 3 이하일 경우 정지한다
 */

package racingcar;

public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final String name;
    private int position;

    Car(String name) {
        this.name = name;
        position = 0;
    }

    public int move(int condition) {
        if (condition >= MOVE_THRESHOLD) position++;
        return position;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
