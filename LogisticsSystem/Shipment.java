public class Shipment{
    String shipmentID;
    Checkpoint head;

    public Shipment(String shipmentID){
        this.shipmentID = shipmentID;
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

        System.out.println("Checkpoint added successfully!");
    }

    public void viewTrackingInfo(){
        System.out.println("Tracking information for " + shipmentID + ": ");
        Checkpoint temp = head;
        while(temp != null){
            System.out.println(temp.time + " -> " + temp.location);
            temp = temp.next;
        }
    }
}