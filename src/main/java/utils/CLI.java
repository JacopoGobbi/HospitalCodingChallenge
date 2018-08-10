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
    private static final Pattern PATIENTS_FORMAT = Pattern.compile(
            "^[FHDTX](,[FHDTX])*$"
    );
    private static final Pattern DRUGS_FORMAT = Pattern.compile(
            "^([IP]|As|An)(,([IP]|As|An))*$"
    );

    /**
     * Validates the input size and format.
     *
     * @param args The input strings sent as params to the program
     * @return success if validated correctly
     * @throws IllegalArgumentException if the number of arguments is not correct
     * @throws IllegalArgumentException if the arguments have an invalid format
     */
    public static Tuple<String, String> validate(String[] args) {
        if (
                (args.length == 1 && PATIENTS_FORMAT.matcher(args[0]).matches())
                        ||
                (args.length == 2 &&
                    PATIENTS_FORMAT.matcher(args[0]).matches() &&
                    DRUGS_FORMAT.matcher(args[1]).matches())
        ) {
            return new Tuple<>(args[0], args[1]);
        } else {
            throw new IllegalArgumentException("Please provide a list of patients and (optional) drugs");
        }
    }
}
