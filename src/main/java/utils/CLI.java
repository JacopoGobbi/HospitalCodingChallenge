package utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Command Line Interface class
 * Currently its role it's just to validate the input
 */
public class CLI {
    private static final Pattern ARGUMENTS_PATTERN = Pattern.compile(
      "^[A-z](,[A-z])*$"
    );

    /**
     * Validates the input size and format.
     *
     * @param args The input strings sent as params to the program
     * @throws IllegalArgumentException if the number of arguments is not correct
     * @throws IllegalArgumentException if the arguments have an invalid format
     * @return success if validated correctly
     */
    public static List<String> validate(String[] args) {
        final int argsLength = args.length;
        if (argsLength == 1 || argsLength == 2) {
            List<String> strArgs = Arrays.stream(args).filter(argument ->
                    ARGUMENTS_PATTERN.matcher(argument).matches()).collect(Collectors.toList());
            if (strArgs.size() == argsLength) {
                return strArgs;
            } else {
                throw new IllegalArgumentException(
                        "Please provide a list of patients and (optional) drugs as single chars separated by a comma");
            }
        } else {
            throw new IllegalArgumentException("Please provide a list of patients and (optional) drugs");
        }
    }
}
