package calculator.domain;

import static calculator.constant.MessageConstant.INVALID_INPUT_NUMBER_EXCEPTION;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class Command {

    String inputStringNumbers;
    List<Delimiter> delimiters;

    public Command(String inputStringNumbers, List<Character> delimiters) {
        validateInputStringNumbers(inputStringNumbers, delimiters);
        this.inputStringNumbers = inputStringNumbers;
        this.delimiters = delimiters.stream()
                .map(Delimiter::new)
                .collect(Collectors.toList());
    }

    private void validateInputStringNumbers(String inputStringNumbers, List<Character> delimiters) {
        HashSet<Character> delimiterSet = new HashSet<>(delimiters);
        inputStringNumbers.chars()
                .mapToObj(i -> (char)i)
                .forEach(ch -> validateCharNumber(delimiterSet, ch));
    }

    private void validateCharNumber(HashSet<Character> delimiterSet, Character charNumber) {
        if (!delimiterSet.contains(charNumber) & Character.isDigit(charNumber)) {
            throw new IllegalArgumentException(INVALID_INPUT_NUMBER_EXCEPTION);
        }
    }
}
