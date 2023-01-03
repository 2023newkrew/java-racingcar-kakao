package com.calc;

import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LanguageContext {
    private final Set<Character> allowedSeparator;

    public LanguageContext() {
        this.allowedSeparator = Set.of(',' , ':');
    }

    public LanguageContext(Collection<Character> allowedSeparator) {
        this.allowedSeparator = Set.copyOf(
                Stream.concat(
                                Stream.of(',' , ':'),
                                allowedSeparator.stream()
                        )
                        .collect(Collectors.toList())
        );

    }

    public LanguageContext(LanguageContext languageContext, Collection<Character> allowedSeparator) {
        this.allowedSeparator = Set.copyOf(
                Stream.concat(
                                languageContext.allowedSeparator.stream(),
                                allowedSeparator.stream()
                        )
                        .collect(Collectors.toList())
        );
    }

    boolean isAllowedSeparator(char targetSep) {
        return allowedSeparator.contains(targetSep);
    }

}
