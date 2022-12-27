package CarRacing;

public class Car {

    private int position;
    private String name;

    public Car(String name) {
        position = 1;
        this.name = name;
    }

    }

    public boolean isMove(int randomNumber) {
        return randomNumber >= 4;
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
