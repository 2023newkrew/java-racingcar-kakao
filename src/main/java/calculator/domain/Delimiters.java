package calculator.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Delimiters {
    private final List<String> delimiters;

    public Delimiters() {
        this.delimiters = new ArrayList<>(Arrays.asList(":", ","));
    }

    public void add(String group) {
        delimiters.add(group);
    }

    public String getRegex() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        delimiters.forEach(sb::append);
        sb.append(']');
        return sb.toString();
    }
}
