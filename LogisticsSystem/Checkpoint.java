public class Checkpoint{
    String location;
    String time;
    Checkpoint next;

    public Checkpoint(String location, String time){
        this.location = location;
        this.time = time;
        this.next = null;

    }
}