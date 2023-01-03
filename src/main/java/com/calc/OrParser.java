package com.calc;

import java.util.List;
import java.util.Map;

public class OrParser implements Parser {
    private final List<Parser> parserList;

    public OrParser(List<Parser> parserList) {
        this.parserList = parserList;
    }

    @Override
    public Map.Entry<Expression, String> parse(LanguageContext languageContext, String input) {
        for (Parser parser : parserList) {
            try {
                return parser.parse(languageContext, input);
            } catch (Exception ignored) {

            }
        }
        throw new RuntimeException("not expected list");
    }
}
