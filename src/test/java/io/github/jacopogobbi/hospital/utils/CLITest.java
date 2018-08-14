package io.github.jacopogobbi.hospital.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class CLITest {
    @Test
    void testCLIArgumentsLength() {
        final String[] input = {};
        assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments should have been rejected"
        );
    }

    @Test
    void testCLIArgumentsFormat() {
        final String[] input = {"1,2", "E,C"};
        assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments format should have been rejected"
        );
    }

    @Test
    void testCLIArgumentsAcceptingDifferentLettersForPatientsAndDrugs() {
        final String[] input = {"A,H", "X,P"};
        assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments letters should have been rejected"
        );
    }

    @Test
    void testCLIArgumentsShorterThanExpected() {
        final String[] input = {"F,H,D,T", "A,I"};
        assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments letters should have been rejected"
        );
    }
}
