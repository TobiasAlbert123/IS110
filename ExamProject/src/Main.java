import java.util.Scanner;

public class Main {
    private static House h;

    public static void main(String[] args) {
        h = new House();
        Scanner();
    }

    public static void Scanner() {
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            //takes input from console and converts to lowercase
            String input = sc.nextLine().toLowerCase();
            String[] lines = input.split(" ");
            for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }
            switch (lines[0]) {
                case "getrooms":       //todo
                    System.out.println("Rooms: " + h.getAmountOfRooms());
                    break;

                case "setrooms":       //todo
                    try {
                        h.setAmountOfRooms(Integer.parseInt(lines[1]));
                    } catch (IndexOutOfBoundsException err) {
                        System.out.println("You did not enter amount of rooms, try again");
                    }
                    break;

                case "printrooms":       //todo
                    if (lines.length >= 2) {
                        h.printRooms(lines[1]);
                    } else {
                        h.printRooms("all");
                    }
                    break;

                case "4":       //todo
                    break;

                case "5":       //todo
                    break;

                case "stop":
                    running = false;
                    System.out.println("Program stopped manually by user");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }
}
