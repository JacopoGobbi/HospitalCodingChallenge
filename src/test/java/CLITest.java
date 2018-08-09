import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.CLI;

class CLITest {
    private CLI cli;

    @BeforeEach
    void setUp() {
        cli = new CLI();
    }

    @Test
    void testCLIParsing() {
        String[] input = {};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> cli.process(input),
                "Arguments should have been rejected");
    }
}
