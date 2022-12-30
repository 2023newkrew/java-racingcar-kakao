package com.calc;

import java.util.List;

public class Calc {
    private static final OrParser PARSER = new OrParser(List.of(
            CustomSeparator.PARSER,
            Separator.PARSER,
            PositiveInteger.PARSER
    ));

    static Expression parse(String input) {
        var temp = PARSER.parse(new LanguageContext(), input);
        if (!temp.getValue()
                .isEmpty()) {
            throw new RuntimeException("not consume all input");
        }
        return temp.getKey();
    }
}
