import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainAppAutomation {

    // ANSI color codes for better console output
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {
        clearScreen(); // Clear the screen for better readability
        System.out.println(ANSI_GREEN + "=============================================================================");
        System.out.println("|              Welcome to Home Automation                                   |");
        System.out.println("=============================================================================");

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        House house = null; // Initialize the house

        do {
            System.out.println(ANSI_CYAN + "| " + ANSI_YELLOW + "1. Manage House                                                          " + ANSI_CYAN + "|");
            System.out.println("| " + ANSI_YELLOW + "2. Exit Application                                                      " + ANSI_CYAN + "|");
            System.out.println("=============================================================================" + ANSI_RESET);
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (house == null) {
                        System.out.println("Create House!!");
                        house = manageHouse(sc);
                    } else {
                        manageHouseOperations(sc, house);
                    }
                    break;
                case 2:
                    System.out.println("Exiting Application...");
                    break;
                default:
                    System.out.println(ANSI_RED + "Invalid choice! Please enter again." + ANSI_RESET);
            }
        } while (choice != 2);
    }

    private static House manageHouse(Scanner sc) {
        ArrayList<Room> rooms = new ArrayList<>();
        int reqRooms = 0;
        boolean fine = false;
        while (!fine) {
            try {
                clearScreen();
                System.out.println("=================================================================");
                System.out.println(ANSI_GREEN + "                  Create Your House                 ");
                System.out.println("=================================================================");

                System.out.println("Enter the total number of rooms you want to add to your house:");
                reqRooms = sc.nextInt();
                sc.nextLine();
                if (reqRooms < 2) {
                    throw new RoomsException("Rooms should be minimum 2");
                }
                fine = true;
            } catch (RoomsException e) {
                System.out.println(ANSI_RED + e.getMessage() + ANSI_RESET);
            } catch (InputMismatchException e) {
                System.out.println(ANSI_RED + "Invalid input! Please enter a number." + ANSI_RESET);
                sc.nextLine();
            }
        }

        for (int i = 0; i < reqRooms; i++) {
            Room room = selectRoom(sc);
            rooms.add(room);
        }
        return new House(rooms);
    }

    private static Room selectRoom(Scanner sc) {
        System.out.println("+===================================+");
        System.out.println("|----->  Available Room Types <-----|");
        System.out.println("|===================================|");
        System.out.println("|" + ANSI_YELLOW + "1. Kitchen                         " + ANSI_CYAN + "|");
        System.out.println("|" + ANSI_YELLOW + "2. Living Area                     " + ANSI_CYAN + "|");
        System.out.println("|" + ANSI_YELLOW + "3. Dining Area                     " + ANSI_CYAN + "|");
        System.out.println("|" + ANSI_YELLOW + "4. Bedroom                         " + ANSI_CYAN + "|");
        System.out.println("|" + ANSI_YELLOW + "5. Washroom                        " + ANSI_CYAN + "|");
        System.out.println("|" + ANSI_YELLOW + "6. Corridors                       " + ANSI_CYAN + "|");
        System.out.println("+===================================+");
        System.out.println("Enter Room name : ");
        String type = sc.nextLine();

        ArrayList<Device> devices = new ArrayList<>();
        int deviceType;
        while (true) {
            System.out.println("+===================================+");
            System.out.println("|         Available Devices         |");
            System.out.println("|===================================|");
            System.out.println("|" + ANSI_YELLOW + "1. Light                           " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "2. Air Conditioner                " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "3. Television                      " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "4. Shower                          " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "5. Toaster                         " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "6. Ventilation Fan                 " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "7. selection over..                " + ANSI_CYAN + "|");
            System.out.println("+===================================+");
            System.out.println("Enter device number using above list : ");
            deviceType = sc.nextInt();
            sc.nextLine();

            switch (deviceType) {
                case 1:
                    devices.add(new Light());
                    break;
                case 2:
                    devices.add(new AirConditioner());
                    break;
                case 3:
                    devices.add(new Television());
                    break;
                case 4:
                    devices.add(new Shower());
                    break;
                case 5:
                    devices.add(new Toaster());
                    break;
                case 6:
                    devices.add(new VentilationFan());
                    break;
                case 7:
                    System.out.println("Device selection has been over..");
                    return new Room(type, devices);
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        }
    }

    private static void manageHouseOperations(Scanner sc, House house) {
        int choice;
        do {
            System.out.println("+===================================+");
            System.out.println("|-------------> Menu <--------------|");
            System.out.println("|===================================|");
            System.out.println("|" + ANSI_YELLOW + "1. Add Device                      " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "2. Remove Device                   " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "3. Add Room                        " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "4. Perform Operations on Device    " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "5. Check House Status              " + ANSI_CYAN + "|");
            System.out.println("|" + ANSI_YELLOW + "6. Exit                            " + ANSI_CYAN + "|");
            System.out.println("+===================================+");
            System.out.println("Enter the choice :");
            choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    if (addDevice(sc, house)) {
                        System.out.println("Device added successfully!!");
                    } else {
                        System.out.println("Failed to add device.");
                    }
                    break;
                case 2:
                    System.out.println("Enter the name of the room:");
                    String roomName = sc.nextLine();
                    System.out.println("Enter the name of the device to remove from room:");
                    String deviceName = sc.nextLine();
                    for (Room room : house.getRooms()) {
                        if (room.getType().equalsIgnoreCase(roomName)) {
                            room.removeDevice(deviceName);
                            break;
                        }
                    }
                    System.out.println("Device removed successfully!!");
                    break;
                case 3:
                    house.addRooms(selectRoom(sc));
                    break;
                case 4:
                    performOperations(sc, house);
                    break;
                case 5:
                    house.checkHouseStatus();
                    break;
                case 6:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Please enter again.");
            }
        } while (choice != 6);
    }

    private static boolean addDevice(Scanner sc, House house) {
        System.out.println("Enter the name of the room:");
        String roomName = sc.nextLine();

        for (Room room : house.getRooms()) {
            if (room.getType().equalsIgnoreCase(roomName)) {
                System.out.println("Enter the type of device to add:");
                System.out.println("+===================================+");
                System.out.println("|         Available Devices         |");
                System.out.println("|===================================|");
                System.out.println("|" + ANSI_YELLOW + "1. Lights                          " + ANSI_CYAN + "|");
                System.out.println("|" + ANSI_YELLOW + "2. Air Conditioner                 " + ANSI_CYAN + "|");
                System.out.println("|" + ANSI_YELLOW + "3. Television                      " + ANSI_CYAN + "|");
                System.out.println("|" + ANSI_YELLOW + "4. Shower                          " + ANSI_CYAN + "|");
                System.out.println("|" + ANSI_YELLOW + "5. Toaster                         " + ANSI_CYAN + "|");
                System.out.println("|" + ANSI_YELLOW + "6. Ventilation Fan                 " + ANSI_CYAN + "|");
                System.out.println("+===================================+");
                System.out.println("Enter your choice:");
                int deviceChoice = sc.nextInt();
                sc.nextLine();

                System.out.println("Enter the name of the device:");
                String deviceName = sc.nextLine();
                boolean deviceExists = false;
                for (Device device : room.getDevice()) {
                    if (device.getDeviceType().equalsIgnoreCase(deviceName)) {
                        deviceExists = true;
                        break;
                    }
                }

                if (deviceExists) {
                    System.out.println("Device already exists in room " + roomName + ". Device not added.");
                    return false;
                }

                switch (deviceChoice) {
                    case 1:
                        room.addDevice(new Light());
                        break;
                    case 2:
                        room.addDevice(new AirConditioner());
                        break;
                    case 3:
                        room.addDevice(new Television());
                        break;
                    case 4:
                        room.addDevice(new Shower());
                        break;
                    case 5:
                        room.addDevice(new Toaster());
                        break;
                    case 6:
                        room.addDevice(new VentilationFan());
                        break;
                    default:
                        System.out.println("Invalid choice! Device not added.");
                        return false;
                }
                System.out.println("Device added successfully to room " + roomName);
                return true;
            }
        }

        System.out.println("Room not found! Device not added.");
        return false;
    }

    public static boolean performOperations(Scanner sc, House house) {
        System.out.println("Select the  operation you want to perform");
        System.out.println("+===================================+");
        System.out.println("|-----------> Operations <----------|");
        System.out.println("|===================================|");
        System.out.println("|" + ANSI_YELLOW + "1. Turn On Device                  " + ANSI_CYAN + "|");
        System.out.println("|" + ANSI_YELLOW + "2. Turn Off Device                 " + ANSI_CYAN + "|");
        System.out.println("+===================================+");
        System.out.println("Enter your choice:");

        int operationChoice = sc.nextInt();
        sc.nextLine();

        switch (operationChoice) {
            case 1:
                return turnOnDevice(sc, house);
            case 2:
                return turnOffDevice(sc, house);
            default:
                System.out.println("Invalid choice! Please enter again.");
                return false;
        }
    }

    private static boolean turnOffDevice(Scanner sc, House house) {
        System.out.println("Enter the name of the room:");
        String roomName = sc.nextLine();
        System.out.println("Enter the name of the device to turn off:");
        String deviceName = sc.nextLine();
        return house.turnOffDevice(roomName, deviceName);
    }

    private static boolean turnOnDevice(Scanner sc, House house) {
        System.out.println("Enter the name of the room:");
        String roomName = sc.nextLine();
        System.out.println("Enter the name of the device to turn on:");
        String deviceName = sc.nextLine();
        return house.turnOnDevice(roomName, deviceName);
    }

    private static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
