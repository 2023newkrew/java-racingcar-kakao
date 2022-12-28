package com.calc;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class SeparatorTest {
    @Test
    void defaultSeparatorTest() {
        Separator sepComma = new Separator(",");
        Separator sepColon = new Separator(":");
        Separator sepAnother = new Separator("a");

        sepComma.checkDefaultSep();
        sepColon.checkDefaultSep();
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> sepAnother.checkDefaultSep());
    }

    @Test
    void customSeparatorTest() {
        String allowSep = ";";
        Separator sepAnother = new Separator(";");
        Separator sepNotAnother = new Separator("_");

        sepAnother.checkCustomSep(allowSep);
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> sepNotAnother.checkCustomSep(allowSep));
    }


}
