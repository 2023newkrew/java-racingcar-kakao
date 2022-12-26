package calculator;

public class StrCal {
    private String str;
    private String regex = ",|:";

    public StrCal(String str) {
        if(str == null || str.length() == 0){
            this.str = str;
            return;
        }
        this.str = str;
        if (str.startsWith("//"))
            customDelimiter();
        if (!this.regex.contains("-") && str.contains("-"))
            throw new RuntimeException();
    }

    private void customDelimiter(){
        String deli = "";
        String[] tmp = str.split("\n");

        deli = tmp[0].substring(2);
        this.str = tmp[1];
        for(Character c : deli.toCharArray())
            regex += "|\\" + c;
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
