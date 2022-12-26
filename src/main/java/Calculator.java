import java.text.ParseException;

public class Calculator {
    private String text;
    public Calculator(String text) {
        this.text = text;
    }

    public int run() throws RuntimeException {
        if(this.isEmptyOrNull()) return 0;

        try {
            int number = Integer.parseInt(text);

            if(number<0) throw new RuntimeException();

            return number;
        } catch (NumberFormatException e) {
            throw new RuntimeException();
        }
    }

    public boolean isEmptyOrNull() {
        return text==null || text.equals("");
    }
}
