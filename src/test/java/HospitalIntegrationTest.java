import domain.Divinity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class HospitalIntegrationTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final class MalignantDivinity implements Divinity {}
    private Hospital hospital;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        hospital = new Hospital(new MalignantDivinity());
    }

    @AfterEach
    void tearDown() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testExample1() {
        String expected = "F:0,H:0,D:0,T:0,X:2";
        hospital.treatPatients(new String[] {"D,D"});
        Assertions.assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testExample2() {
        String expected = "F:0,H:1,D:0,T:0,X:0";
        hospital.treatPatients(new String[] {"F", "P"});
        Assertions.assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testAntibioticCuringTubercolosis() {
        String expected = "F:0,H:1,D:0,T:0,X:1";
        hospital.treatPatients(new String[] {"F,T", "An"});
        Assertions.assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testInsulinePreventDiabeticFromDying() {
        String expected = "F:0,H:0,D:2,T:0,X:1";
        hospital.treatPatients(new String[] {"D,D,T", "I"});
        Assertions.assertEquals(expected, outContent.toString().trim());
    }

    @Test
    void testInsulineAndAntibioticKillsEverybody() {
        String expected = "F:0,H:0,D:0,T:0,X:6";
        hospital.treatPatients(new String[] {"F,H,D,T,T,X", "I,An"});
        Assertions.assertEquals(expected, outContent.toString().trim());
    }
}
