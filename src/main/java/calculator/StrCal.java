package calculator;

public class StrCal {
    private final String str;
    private String regex = ",|:";

    public StrCal(String str) {
        if (str.contains("-"))
            throw new RuntimeException("negative value passed");
        this.str = str;
    }

    public StrCal(String del, String str) {
        if (!del.contains("-") && str.contains("-"))
            throw new RuntimeException("negative value passed");

        del = del.substring(2);
        for (int i = 0; i < del.length(); i++)
            regex += "|\\" + del.charAt(i);

        this.str = str;
    }

    public int calculate() {
        if (str == null || str.length() == 0)
            return 0;

        int sum = 0;
        String[] numbers = str.split(regex);
        for (String number : numbers) sum += Integer.parseInt(number);

        return sum;
    }
}
