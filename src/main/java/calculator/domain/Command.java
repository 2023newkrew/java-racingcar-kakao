package calculator.domain;

import static calculator.constant.MessageConstant.INVALID_INPUT_NUMBER_EXCEPTION;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Command {

    private String inputStringNumbers;
    private List<Delimiter> delimiters;


    public Command() {
        this("0");
    }

    public Command(String inputStringNumbers) {
        this(inputStringNumbers.isBlank() ? "0" : inputStringNumbers, new ArrayList<>());
    }

    public Command(String inputStringNumbers, List<Character> delimiters) {
        setUpDefaultDelimiters();
        this.delimiters.addAll(
                delimiters.stream()
                .map(Delimiter::new)
                .collect(Collectors.toList())
        );
        validateInputStringNumbers(inputStringNumbers);
        this.inputStringNumbers = inputStringNumbers;

    }

    private void setUpDefaultDelimiters() {
        this.delimiters = new ArrayList<>(Arrays.asList(new Delimiter(':'), new Delimiter(',')));
    }

    private void validateInputStringNumbers(String inputStringNumbers) {
        Set<Character> delimiterSet = getDelimiterSet();
        inputStringNumbers.chars()
                .mapToObj(i -> (char) i)
                .forEach(ch -> validateCharNumber(delimiterSet, ch));
    }

    private void validateCharNumber(Set<Character> delimiterSet, Character charNumber) {
        if (!delimiterSet.contains(charNumber) & !Character.isDigit(charNumber)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_EXCEPTION);
        }
    }


    private Set<Character> getDelimiterSet() {
        return delimiters.stream()
                .map(Delimiter::getDelimiter)
                .collect(Collectors.toSet());
    }
    public String getInputStringNumbers() {
        return inputStringNumbers;
    }

    public List<Delimiter> getDelimiters() {
        return delimiters;
    }
}
