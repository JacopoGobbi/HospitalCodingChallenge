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
    void testCLIArgumentsLength() {
        String[] input = {};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> cli.process(input),
                "Arguments should have been rejected");
    }

    @Test
    void testCLIArgumentsFormat() {
        String[] input = {"1,2", "E,C"};
        Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> cli.process(input),
                "Arguments format should have been rejected");
    }
}
