import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String text;
    public Calculator(String text) {
        this.text = text;
    }

    public int run() throws RuntimeException {
        if(this.isEmptyOrNull()) return 0;

        return toInteger(this.text);
    }

    private int toInteger (String possibleNumber) throws RuntimeException {
        try {
            int number = Integer.parseInt(possibleNumber);

            if(number<0) throw new RuntimeException();

            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public boolean isEmptyOrNull() {
        return text==null || text.equals("");
    }

    public List<Integer> splitText() {
        String[] numbers = this.text.split("[,:]");
        List<Integer> arr = new ArrayList<>();

        Arrays.stream(numbers).forEach(e-> arr.add(toInteger(e)));

        return arr;
    }
}
