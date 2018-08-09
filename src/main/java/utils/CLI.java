package utils;

public class CLI {
    public String process(String[] args) {
        if (args.length == 1 || args.length == 2) {
            return "Good";
        } else {
            throw new IllegalArgumentException("Please provide a list of patients and (optional) drugs");
        }
    }
}
