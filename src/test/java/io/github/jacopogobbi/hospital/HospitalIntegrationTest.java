package io.github.jacopogobbi.hospital;

import io.github.jacopogobbi.hospital.domain.Divinity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HospitalIntegrationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final class MalignantDivinity implements Divinity {}
    private Hospital hospital;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        hospital = new Hospital(new MalignantDivinity());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
    }

    @Test
    void testExample1() {
        final var expected = "F:0,H:0,D:0,T:0,X:2";
        hospital.treatPatients(new String[] {"D,D"});
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testExample2() {
        final var expected = "F:0,H:1,D:0,T:0,X:0";
        hospital.treatPatients(new String[] {"F", "P"});
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testAntibioticCuringTubercolosis() {
        final var expected = "F:0,H:1,D:0,T:0,X:1";
        hospital.treatPatients(new String[] {"F,T", "An"});
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testInsulinPreventDiabeticFromDying() {
        final var expected = "F:0,H:0,D:2,T:0,X:1";
        hospital.treatPatients(new String[] {"D,D,T", "I"});
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testInsulinAndAntibioticKillsEverybody() {
        final var expected = "F:0,H:0,D:0,T:0,X:6";
        hospital.treatPatients(new String[] {"F,H,D,T,T,X", "I,An"});
        assertEquals(expected, outContent.toString().trim());
    }

    /**
     * Test if "hasReceivedEffectiveTreatment" logic works allowing people to die if they did not receive a valid
     * treatment
     */
    @Test
    void testEverybodyDies() {
        final var expected = "F:0,H:0,D:0,T:0,X:4";
        hospital.treatPatients(new String[] {"F,F,D,X", "An"});
        assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testEverythingTogether() {
        final var expected = "F:0,H:0,D:0,T:0,X:10";
        hospital.treatPatients(new String[] {"X,T,D,H,F,F,H,D,T,X", "I,As,An,P"});
        assertEquals(expected, outContent.toString().trim());
    }
}
