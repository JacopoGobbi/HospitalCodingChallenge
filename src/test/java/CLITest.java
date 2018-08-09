import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import utils.CLI;

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
}
