package stringcalculator;

public interface Parser<T> {
    Integer[] parse(T input);
}
