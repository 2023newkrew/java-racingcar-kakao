package racingcar;

public class Race {
    public boolean verifyName(String input) {
        if(input.length() < 6){
            return true;
        }
        return false;
    }
}
