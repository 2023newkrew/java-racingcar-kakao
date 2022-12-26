package racingcar;

public class Race {
    String nameStr;

    public Race() {
        this.nameStr = "pobi,crong,honux";
    }

    public Race(String nameStr) {
        this.nameStr = nameStr;
    }

    public boolean verifyName(String input) {
        if(input.length() < 6){
            return true;
        }
        return false;
    }

    public String[] nameSplit() {
        return nameStr.split(",");
    }
}
