import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static House h;

    public static void main(String[] args) {
        //initializes house
        h = new House();

        //some commands to happen
        h.setAmountOfRooms(20);
        //h.printRooms("all");
        h.printRooms("bathroom");
        //h.makeSpecificRoom();

        //user is free to use commands
        inputHandler();
    }

    /*
    Handles user input
     */
    public static void inputHandler() {
        Scanner sc = new Scanner(System.in);

        boolean running = true;
        while (running) {
            System.out.print(">");
            //takes input from console and converts to lowercase
            String input = sc.nextLine().toLowerCase();
            String[] lines = input.split(" ");
            /*for (int i = 0; i < lines.length; i++) {
                System.out.println(lines[i]);
            }*/
            switch (lines[0]) {
                //returns current number of rooms
                case "getrooms":       //todo
                    System.out.println("Rooms: " + h.getAmountOfRooms());
                    break;

                //sets amount of rooms
                case "setrooms":       //todo
                    try {
                        h.setAmountOfRooms(Integer.parseInt(lines[1]));
                    } catch (IndexOutOfBoundsException err) {
                        System.out.println("You did not enter amount of rooms, try again");
                    }
                    break;

                //prints a room by index
                case "printroom":
                    h.printRoom(Integer.parseInt(lines[1]));
                    break;

                //prints rooms, either all or all by type
                case "printrooms":       //todo
                    if (lines.length >= 2) {
                        h.printRooms(lines[1]);
                    } else {
                        h.printRooms("all");
                    }
                    break;

                //makes a specific room
                case "makespecific":       //todo
                    h.makeSpecificRoom();
                    break;

                //prints all rooms by type
                case "printbytype":       //todo
                    h.printByType(lines[1]);
                    break;

                //edits a room by index
                case "editroom":
                    h.editRoom(Integer.parseInt(lines[1]));
                    break;

                //stops program
                case "stop":
                    running = false;
                    System.out.println("Program stopped manually by user");
                    System.exit(0);
                    break;

                case "help":
                    for (int i = 0; i < ValidCommands().length; i++) {
                        System.out.println(ValidCommands()[i]);
                    }
                    System.out.println("Type 'expand' for more, or enter to go back");
                    String next = sc.nextLine();
                    if (next.equals("expand")) {
                        System.out.println("pretend this is expanded help");
                        break;
                    }
                    System.out.println("going back");
                    break;
                //nothing happens if wrong command, loop starts over
                default:
                    System.out.println("Invalid command");
                    break;
            }
        }
    }

    public static final String[] ValidCommands() {
        String[] Commands = {"setrooms", "getrooms", "printroom", "printrooms", "makespecific", "printbytype", "editroom", "stop", "help"};
        return Commands;
    }
}
