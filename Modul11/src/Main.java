import java.util.Scanner;

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

            String separator = " ";
            if (commandMessage) {
                System.out.printf("Type a command (use underscore '%s' as separator):\n", separator);
                //System.out.println(separator);
            }

            //takes input from console and converts to lowercase
            String originalnput = sc.nextLine().toLowerCase();
            String[] input = originalnput.split(separator);

            /* For debugging
            System.out.printf("input size: %d\n", input.length);
            for (int i = 0; i < input.length; i++) {
                System.out.println(input[i]);
                input[i].trim();
            }*/

            try {
                switch (input[0]) {
                    case "hashcodes":
                        for (int i = 0; i < myhouse.getAmountOfRooms(); i++) {
                            System.out.println(myhouse.getARoom(i).hashCode());
                        }
                        break;

                    case "lol":
                        System.out.println(myhouse.hashCode());

                        break;

                    case "setrooms":
                        int rooms = 0;
                        try {
                            rooms = myhouse.setAmountOfRooms(Integer.valueOf(input[1]));
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("Amount of rooms not defsrtjhsrtjined / " + ex);
                        }
                        if (rooms != -1) {
                            System.out.printf("Amount of rooms set to %d\n", rooms);
                        }
                        break;


                    case "getrooms":
                        System.out.printf(
                                "There are %s rooms in the house\n", myhouse.getAmountOfRooms()
                        );
                        break;

                    case "printhouse":
                        //myhouse.printHouse();
                        myhouse.houseMaker(5);
                        break;

                    case "makenew":
                        if (input.length == 2) {
                            myhouse.makeNewRoom(input[1], "1");
                        } else {
                            myhouse.makeNewRoom(input[1], input[2]);
                            /*try {
                                myhouse.makeNewRoom(input[1], input[2]);
                            } catch (ArrayIndexOutOfBoundsException ex) {
                                System.out.println("Please use this command with room type");
                            }*/
                        }
                        break;

                    case "makespecific":
                        String specType = "";
                        if (input.length == 1) {
                            System.out.println("Bedroom or bathroom?");
                            specType = sc.next().toLowerCase();
                        } else {
                            try {
                                specType = input[1].toLowerCase();
                            } catch (ArrayIndexOutOfBoundsException ex) {

                            }
                        }
                        myhouse.makeSpecific(specType);
                        System.out.println();
                        break;

                    case "delete":
                        try {
                            myhouse.deleteRooms(input[1]);
                        } catch (ArrayIndexOutOfBoundsException ex) {
                            System.out.println("You did not enter an amount, please try again");
                        }
                        break;

                    case "checkstats":
                        myhouse.checkStats();
                        break;

                    case "printroom":
                        String typeToPrint = "";
                        if (input.length == 1) {
                            typeToPrint = "all";
                        } else {
                            if (input.length >= 2) {
                                typeToPrint = input[1];
                            }
                        }
                        myhouse.printRoom(typeToPrint);
                        break;

                    case "makepeople":
                        myhouse.makeInhabitant(input[1]);
                        break;

                    case "printpeople":
                        myhouse.printPeople(input[1]);
                        break;

                    case "namecheck":
                        myhouse.nameCheck(input[1]);
                        break;

                    case "printnames":
                        myhouse.printNames();
                        break;

                        //Sets commandMessage to the value opposite of itself
                    case "cmd":
                        commandMessage ^= true;
                        break;

                    case "stop":
                        running = false;
                        System.out.println("Program stopped manually by user");
                        System.exit(0);
                        break;

                    case "help":
                        System.out.println("Try commands: ");
                        System.out.println("setrooms | getrooms | makenew | makespecific | printroom | cmd");
                        break;

                    default:
                        System.out.println("Invalid command");
                        break;
                }
            } catch (ArrayIndexOutOfBoundsException ex) {
                System.out.println("You did not enter enough arguments, please try again");
            }
        }
    }
}
