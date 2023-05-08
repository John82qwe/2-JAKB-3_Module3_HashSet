import java.util.*;

public class MyBucket {
    private List<MyItemEntry> entries;

    public MyBucket() {
        this.entries = new LinkedList<>();
    }

    public List<MyItemEntry> getEntries() {
        return entries;
    }
    public void addEntry(MyItemEntry entry){
        entries.add(entry);
    }
    public void removeEntry(MyItemEntry entry){
        entries.remove(entry);
    }
}