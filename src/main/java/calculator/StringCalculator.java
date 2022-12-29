package calculator;

public class StringCalculator {
    private String str;
    private final StringBuilder regex = new StringBuilder(",|:");

    public StringCalculator(String str) {
        if (str == null || str.length() == 0) {
            this.str = str;
            return;
        }
        this.str = str;
        if (str.startsWith("//"))
            customDelimiter();
        if (!this.regex.toString().contains("-") && str.contains("-"))
            throw new RuntimeException();
    }

    private void customDelimiter() {
        String deli;
        String[] tmp = str.split("\n");

        deli = tmp[0].substring(2);
        this.str = tmp[1];
        for (Character c : deli.toCharArray())
            regex.append("|\\").append(c);
    }

    public int calculate() {
        if (str == null || str.length() == 0)
            return 0;

        int sum = 0;
        String[] numbers = str.split(regex.toString());
        for (String number : numbers) sum += Integer.parseInt(number);

        return sum;
    }
}
