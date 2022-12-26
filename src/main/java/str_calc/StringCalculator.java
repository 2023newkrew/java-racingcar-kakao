package str_calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class StringCalculator {

    private List<String> seperators;

    public StringCalculator() {
        this.seperators = new ArrayList<>();
        this.seperators.add(",");
        this.seperators.add(":");
    }

    public List<String> splitText(String text) {
        return Arrays.asList(text.split(String.join("|",seperators)));
    }
}
