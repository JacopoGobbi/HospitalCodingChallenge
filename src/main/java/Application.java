import utils.CLI;

class Application {
    public static void main(String[] args) {
        try {
            CLI.validate(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}