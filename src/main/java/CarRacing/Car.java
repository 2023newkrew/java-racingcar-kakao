package CarRacing;

public class Car {

    private int position;

    public Car() {
        position = 1;
    }
    public void moveCar(boolean move) {
        if(move) {
            position++;
        }
    }

    public int getPosition() {
        return position;
    }
}
