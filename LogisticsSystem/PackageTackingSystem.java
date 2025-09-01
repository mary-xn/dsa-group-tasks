import java.util.*;
import java.util.regex.Pattern;

public class PackageTackingSystem {
    static Scanner scan = new Scanner(System.in);
    static HashMap<String, Shipment> shipments = new HashMap<>();
    static int choice;

    public static void main(String[] args) {
        while (true) { 
                printMenu();
                String strChoice = scan.nextLine().trim();

                if (strChoice.isEmpty()){
                    System.out.println("Choice cannot be empty. Please enter numbers 1–4 only.");
                    continue;
                }

            try {
                choice = Integer.parseInt(strChoice);
            } catch (NumberFormatException e) {
                System.out.println("Please enter numbers 1-4 only.");
                continue;
            }

            if (choice < 1 || choice > 4) {
                System.out.println("Please enter numbers 1–4 only.");
                continue;                            
            }

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
        System.out.println("\n=========================================");
        System.out.println("          PACKAGE TRACKING SYSTEM ");
        System.out.println("=========================================");
        System.out.println("1. Add New Shipment");
        System.out.println("2. Add Checkpoint to Shipment");
        System.out.println("3. View Tracking Info");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

   private static String getValidatedInput(String prompt, String regex, String errorMsg) {
        while (true) {
            System.out.print(prompt);
            String input = scan.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Input cannot be empty. Try again.");
                continue;
            }
            if (!Pattern.matches(regex, input)) {
                System.out.println(errorMsg);
                continue;
            }
            return input;
        }
    }


    static void addShipment(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("ADD NEW SHIPMENT\n");
        String id = getValidatedInput(
        "Enter Shipment ID (format: PKG-Number, e.g., PKG-101): ",
        "^PKG-\\d+$",
        "Invalid Shipment ID. Format must be PKG- followed by numbers (e.g., PKG-101)."
        );
        shipments.put(id, new Shipment(id));
        System.out.println("Shipment " + id + " created successfully!");
    }

    static void addCheckpoint(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("ADD NEW CHECKPOINT\n");
        String id = getValidatedInput(
        "Enter Shipment ID (format: PKG-Number, e.g., PKG-101): ",
        "^PKG-\\d+$",
        "Invalid Shipment ID. Format must be PKG- followed by numbers (e.g., PKG-101)."
        );
        Shipment shipment = shipments.get(id);
        if (shipment == null){
            System.out.println("Shipment not found!");
            return;
        }
        
        String location = getValidatedInput("Enter Checkpoint Location: ", "^[A-Za-z0-9 ]+$", "Invalid Location Input. Use only letters and/or numbers.");
        String time = getValidatedInput("Enter Time (YYYY-MM-DD HH:MM AM/PM):", "^(?:\\d{4})-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]) (?:[01]\\d|2[0-3]):[0-5]\\d (AM|PM)$", "Invalid Time Input. Use the format YYYY-MM-DD HH:MM AM/PM");
        shipment.addCheckpoint(location, time);
    }

    static void viewTrackingInfo(){
        System.out.println("-----------------------------------------------------------------------");
        System.out.println("VIEW TRACKING INFORMATION" );
        String id = getValidatedInput(
        "Enter Shipment ID (format: PKG-Number, e.g., PKG-101): ",
        "^PKG-\\d+$",
        "Invalid Shipment ID. Format must be PKG- followed by numbers (e.g., PKG-101)."
        );
        Shipment shipment = shipments.get(id);
        if(shipment == null){
            System.out.println("Shipment not found!");
            return;
        }
        shipment.viewTrackingInfo();
    }
}

    
