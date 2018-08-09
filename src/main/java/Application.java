import utils.CLI;

class Application {
    public static void main(String[] args) {
        System.out.println(new CLI().parseInput(args));
    }
}