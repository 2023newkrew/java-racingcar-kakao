package CarRacing;

public class Racing {
    public String[] nameSplit(String inputString) {
        return inputString.split(",");
    }

    public void nameException(String name) {
        if (name.length() > 5) {
            throw new RuntimeException("다섯 글자 이상입니다.");
        }
    }
}
