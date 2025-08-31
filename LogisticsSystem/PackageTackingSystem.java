import java.util.*;

public class PackageTackingSystem {
    static Scanner scan = new Scanner(System.in);
    static HashMap<String, Shipment> shipments = new HashMap<>();

    public static void main(String[] args) {
        while (true) { 
            printMenu();
            int choice = scan.nextInt();
            scan.nextLine();

            switch(choice){
                case 1 -> addShipment();
                case 2 -> addCheckpoint();
                case 3-> viewTrackingInfo();
                case 4 -> {
                    System.out.println("Exiting Package Tracking System...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
            

        }
    }

    public static void printMenu(){
        System.out.println("\n===== PACKAGE TRACKING SYSTEM =====");
        System.out.println("1. Add New Shipment");
        System.out.println("2. Add Checkpoint to Shipment");
        System.out.println("3. View Tracking Info");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }
   //Insert validations for the following methods:
    static void addShipment(){
        System.out.print("Enter Shipment ID: ");
        String id = scan.nextLine();
        shipments.put(id, new Shipment(id));
        System.out.println("Shipment " + id + " created successfully!");
    }

    static void addCheckpoint(){
        System.out.print("Enter Shipment ID: ");
        String id = scan.nextLine();
        Shipment shipment = shipments.get(id);
        if (shipment == null){
            System.out.println("Shipment not found!");
            return;
        }
        System.out.print("Enter Checkpoint Location: ");
        String location = scan.nextLine();
        System.out.print("Enter Time (YYY-MM-DD HH:MM): ");
        String time = scan.nextLine();
        shipment.addCheckpoint(location, time);
    }

    static void viewTrackingInfo(){
        System.out.print("Enter Shipment ID: ");
        String id = scan.nextLine();
        Shipment shipment = shipments.get(id);
        if(shipment == null){
            System.out.println("Shipment not found!");
            return;
        }
        shipment.viewTrackingInfo();
    }
}

    
