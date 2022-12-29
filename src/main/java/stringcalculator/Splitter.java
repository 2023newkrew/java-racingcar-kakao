package stringcalculator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static stringcalculator.ErrorMessage.INVALID_DELIMITER_ERROR_MESSAGE;

public class Splitter {

    private Set<String> delimiters;

    public Splitter(List<String> baseDelimiters) {
        validateDelimiters(baseDelimiters);
        this.delimiters = new HashSet<>(baseDelimiters);
    }

    public void addDelimiter(String delimiter) {
        validateDelimiter(delimiter);
        delimiters.add(delimiter);
    }

    public String[] splitByDelimiters(String input) {
        return input.split(delimiters.toString());
    }

    private void validateDelimiter(String delimiter) {
        if (delimiter.length() > 1 || Character.isDigit(delimiter.charAt(0))) {
            throw new RuntimeException(INVALID_DELIMITER_ERROR_MESSAGE);
        }
    }

    private void validateDelimiters(List<String> baseDelimiters) {
        baseDelimiters.forEach(this::validateDelimiter);
    }

    @Override
    public String toString() {
        return String.join("|", delimiters);
    }

}
