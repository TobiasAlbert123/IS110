import java.util.Scanner;

public class Main {
    private static House h;

    public static void main(String[] args) {
        //initializes house
        h = new House();

        //some commands to happen
        h.setAmountOfRooms(20);
        h.printRooms("all");
        //h.printRooms("bathroom");
        //h.makeSpecificRoom();
        h.printInfo();

        //user is free to use commands
        inputHandler();

    }

    /*
    Handles user input
     */
    public static void inputHandler() {
        Scanner sc = new Scanner(System.in);

        //loop can be stopped
        boolean running = true;
        while (running) {
            System.out.print(">");
            //takes input from console and converts to lowercase
            String lineFromConsole = sc.nextLine().toLowerCase();
            String[] input = lineFromConsole.split(" ");
            /*for (int i = 0; i < input.length; i++) {
                System.out.println(input[i]);
            }*/
            switch (input[0]) {
                //returns current number of rooms
                case "getrooms":       //todo
                    System.out.println("Rooms: " + h.getAmountOfRooms());
                    break;

                //sets amount of rooms
                case "setrooms":       //todo
                    try {
                        h.setAmountOfRooms(Integer.parseInt(input[1]));
                    } catch (IndexOutOfBoundsException ex) {
                        System.out.println("You did not enter amount of rooms, try again");
                    } catch (NumberFormatException ex) {
                        System.out.printf("%s is not a positive integer\n", input[1]);
                    }
                    break;

                //prints a room by index
                case "printroom":
                    //random exceptions with no use
                    if (input.length < 2) {
                        throw new EksamenException("Not 2");
                    }
                    if (input.length == 3) {
                        throw new EksamenException("3rd");
                    }
                    if (input.length == 4) {
                        throw new EksamenException(4);
                    }
                    h.printRoom(Integer.parseInt(input[1]));
                    break;

                //prints rooms, either all or all by type
                case "printrooms":       //todo
                    if (input.length >= 2) {
                        h.printRooms(input[1]);
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
                    h.printByType(input[1]);
                    break;

                //edits a room by index
                case "editroom":
                    h.editRoom(Integer.parseInt(input[1]));
                    break;

                case "info":
                    h.printInfo();
                    break;

                //stops program
                case "stop":
                    //loop stops -> program stops
                    running = false;
                    System.out.println("Program stopped manually by user");

                    //also causes program to exit
                    System.exit(0);
                    break;

                //lists all available commands (needs to be manually updated)
                case "help":
                    for (int i = 0; i < ValidCommands().length; i++) {
                        System.out.println(ValidCommands()[i]);
                    }
                    System.out.println("Type 'expand' for more, or enter to go back");
                    String next = sc.nextLine();
                    if (next.equals("expand")) {
                        for (int i = 0; i < ValidCommands().length; i++) {
                            System.out.println(ValidCommands()[i] + ":\n- expanded text goes here");
                        }
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

    //returns array of valid commands (manually written)
    public static final String[] ValidCommands() {
        String[] Commands = {"setrooms", "getrooms", "printroom", "printrooms", "makespecific", "printbytype", "editroom", "stop", "help"};
        return Commands;
    }
}
