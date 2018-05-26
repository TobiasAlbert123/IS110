public class EksamenException extends RuntimeException {

    public EksamenException(String input) {
        if (input.equals("Not 2")) {
            System.out.println("Program shutting down fine");
            System.exit(1);
        }
        System.out.println("Program crashing with exception");
    }

    public EksamenException(int index) {
        super("This is exception with super and inserted number: " + index);
    }
}
