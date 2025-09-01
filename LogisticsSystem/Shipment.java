import java.util.*;
public class Shipment{
    String shipmentID;
    String sender;
    String recipient;
    String destination;
    String status;
    Checkpoint head;

    public Shipment(String shipmentID, String sender, String recipient, String destination, String status){
        this.shipmentID = shipmentID;
        this.sender = sender;
        this.recipient = recipient;
        this.destination = destination;
        this.status = status;
    }
    
    public void addCheckpoint(String location, String time){
        Checkpoint newCheckpoint = new Checkpoint(location, time);
        if (head == null){
            head = newCheckpoint;
        }else{
            Checkpoint temp = head;
            while (temp.next != null){
                temp = temp.next;
            }
            temp.next = newCheckpoint;
        }

        if(location.equalsIgnoreCase(destination)){
            status = "Delivered";
            System.out.println("Checkpoint added successfully! Shipment has reached its destination.");
        }else{
            System.out.println("Checkpoint added successfully!");
        }
    }

    public void viewTrackingInfo(){
        System.out.println("Tracking information for " + shipmentID + ": ");
        System.out.println("Sender: " + sender);
        System.out.println("Recipient: " + recipient);
        System.out.println("Destination: " + destination);
        System.out.println("Status: " + status);

        List<Checkpoint> checkpoints = new ArrayList<>();

        Checkpoint temp = head;
        while(temp != null){
            checkpoints.add(temp);
            temp = temp.next;
        }

        checkpoints.sort(Comparator.comparing(c-> c.dateTime));
        System.out.println("\nCheckpoints: ");
        for (Checkpoint c: checkpoints){
            System.out.println(c.time + " -> " + c.location);
        }

    }
}