package stringadder;

import java.util.*;

public class StringProcessResult {
    private final List<String> splitToken = new ArrayList<>();;
    private final String numString;

    public StringProcessResult(String customDelimiter, String numString) {
        this.splitToken.addAll(Arrays.asList(",", ":"));
        if (customDelimiter != null) {
            this.splitToken.add(customDelimiter);
        }
        this.numString = numString;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StringProcessResult that = (StringProcessResult) o;
        return splitToken.equals(that.splitToken) && numString.equals(that.numString);
    }

    @Override
    public int hashCode() {
        return Objects.hash(splitToken, numString);
    }

    private void checkNumberPositive(int number) {
        if (number < 0) {
            throw new RuntimeException();
        }
    }

    public int[] split() {
        String[] splitNumStrings = numString.split(getDelimiterPattern());
        int[] numbers = new int[splitNumStrings.length];
        for (int i = 0; i < splitNumStrings.length; i++) {
            numbers[i] = Integer.parseInt(splitNumStrings[i]);
            checkNumberPositive(numbers[i]);
        }
        return numbers;
    }

    private String getDelimiterPattern() {
        return String.join("|", splitToken);
    }
}
