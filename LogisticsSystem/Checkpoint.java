import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Checkpoint{
    String location;
    String time;
    LocalDateTime dateTime;
    Checkpoint next;

    private static final DateTimeFormatter FORMATTER =
        DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm a");

    public Checkpoint(String location, String time){
        this.location = location;
        this.time = time;
        this.dateTime = LocalDateTime.parse(time, FORMATTER);
        this.next = null;

    }
}