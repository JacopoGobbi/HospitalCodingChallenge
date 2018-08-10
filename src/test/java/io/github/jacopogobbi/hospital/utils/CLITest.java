package io.github.jacopogobbi.hospital.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CLITest {
    @Test
    void testCLIArgumentsLength() {
        String[] input = {};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments should have been rejected");
    }

    @Test
    void testCLIArgumentsFormat() {
        String[] input = {"1,2", "E,C"};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments format should have been rejected");
    }

    @Test
    void testCLIArgumentsAcceptingDifferentLettersForPatientsAndDrugs() {
        String[] input = {"A,H", "X,P"};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments letters should have been rejected");
    }

    @Test
    void testCLIArgumenatsShorterThanExpected() {
        String[] input = {"F,H,D,T", "A,I"};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> CLI.validate(input),
                "Arguments letters should have been rejected");
    }
}
