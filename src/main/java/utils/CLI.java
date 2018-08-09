package utils;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CLI {
    private static final Pattern ARGUMENTS_PATTERN = Pattern.compile(
      "^[A-z](,[A-z])*$"
    );

    public String process(String[] args) {
        final int argsLength = args.length;
        if (argsLength == 1 || argsLength == 2) {
            List<String> strArgs = Arrays.stream(args).filter(argument ->
                    ARGUMENTS_PATTERN.matcher(argument).matches()).collect(Collectors.toList());
            if (strArgs.size() == argsLength) {
                return "Good";
            } else {
                throw new IllegalArgumentException(
                        "Please provide a list of patients and (optional) drugs as single chars separated by a comma");
            }
        } else {
            throw new IllegalArgumentException("Please provide a list of patients and (optional) drugs");
        }
    }
}
