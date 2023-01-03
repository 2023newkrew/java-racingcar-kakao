package addcal;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddCal {
    private final String separator;
    private String processedInputString;
    private final CalNum resultNum;
    private final List<CalNum> numList;

    AddCal(String inputString) {
        separator = parseCustomSeparator(inputString);
        numList = new ArrayList<>();
        resultNum = new CalNum(0);
        splitNums(processedInputString);
        sum();
    }

    private void splitNums(String inputString) {
        if (isBlank(inputString)) {
            numList.add(new CalNum(0));
            return;
        }
        for (String num : inputString.split(separator)) {
            numList.add(new CalNum(Integer.parseInt(num)));
        }
    }

    public static boolean isBlank(String input) {
        return input == null || input.isEmpty();
    }

    private String parseCustomSeparator(String inputString) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputString);
        String customSeparator = ",|;";
        processedInputString = inputString;
        if (m.find()) {
            customSeparator = m.group(1);
            processedInputString = m.group(2);
        }
        return customSeparator;
    }

    public void printResult() {
        System.out.print("result: ");
        resultNum.printNum();
    }

    private void sum() {
        for (CalNum num : numList) {
            resultNum.add(num);
        }
    }

    public String getSeparator() {
        return separator;
    }

    public int getResultSum() {
        return resultNum.getNum();
    }

    public List<CalNum> getNumList() {
        return numList;
    }
}
