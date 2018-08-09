import utils.CLI;

class Application {
    public static void main(String[] args) {
        try {
            System.out.println(new CLI().process(args));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}