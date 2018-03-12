import java.util.ArrayList;
import java.util.Scanner;
import java.lang.Integer;

public class Main {
    static House myhouse = new House(0);

    public static void main(String[] args) {
        Scanner();
    }

    public static void Scanner() {
        Scanner sc = new Scanner(System.in);

        boolean commandMessage = true;

        boolean running = true;
        while (running) {

            String separator = "_";
            if (commandMessage) {
                System.out.printf("Type a command (use underscore '%s' as separator):\n", separator);
            }

            //takes input from console and converts to lowercase
            String originalnput = sc.next().toLowerCase();
            String[] input = originalnput.split(separator);

            switch (input[0]) {
                case "setrooms":    System.out.printf(
                                        "Amount of rooms set to %d\n", myhouse.setAmountOfRooms(Integer.parseInt(input[1]))
                                    );
                                    break;

                case "getrooms":    System.out.printf(
                                        "There are %s rooms in the house", myhouse.getAmountOfRooms()
                                    );
                                    break;

                case "makenew":     String toBeMade = input[1];
                                    int amountToBeMade = 1;
                                    if (input.length >= 3) {
                                        try {
                                            amountToBeMade = Integer.parseInt(input[2]);
                                        } catch (NumberFormatException ex) {
                                            System.out.printf("'%s' is not an integer, making default amount of rooms (%d)\n", input[2], amountToBeMade);
                                            System.out.println("Please enter an integer next time");
                                        }
                                    }
                                    switch(toBeMade) {
                                        case "bedroom": for (int i = 0; i < amountToBeMade; i++) {
                                            Bedroom newBedRoom = new Bedroom();
                                            myhouse.rooms.add(newBedRoom);
                                            myhouse.bedrooms.add(newBedRoom);
                                        }
                                        break;
                                        case "bathroom": for (int i = 0; i < amountToBeMade; i++) {
                                            Bathroom newBathRoom = new Bathroom();
                                            myhouse.rooms.add(newBathRoom);
                                            myhouse.bathrooms.add(newBathRoom);
                                        }
                                    }
                                break;

                case "makespecific":      //todo
                                break;

                case "printroom":   String typeToPrint = "all";
                                    if (input.length >= 2) {
                                        typeToPrint = input[1];
                                    }
                                    switch (typeToPrint) {
                                        case "all": for (Room oneRoom: myhouse.rooms) {
                                            oneRoom.PrintStats();
                                        }
                                        break;
                                        case "bedroom": for (Bedroom oneBedroom: myhouse.bedrooms) {

                                        }
                                        default:    System.out.printf("Could not print rooms: %s\n", typeToPrint);
                                    }
                                break;


                                //Sets commandMessage to the value opposite of itself
                case "cmd":     commandMessage ^=true;
                                break;

                case "stop":    running = false;
                                System.out.println("Program stopped manually by user");
                                System.exit(0);
                                break;

                default:        System.out.println("Invalid command");
                                break;
            }
        }
    }
}
