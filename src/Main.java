public class Main {
    public static void main(String[] args) {
        MyHashSet<String> myHashMap = new MyHashSet<>();
        myHashMap.put("12e");
        myHashMap.put("12eq");
        myHashMap.put("12eqq");
        myHashMap.put("12ee");
        myHashMap.put("12err");
        myHashMap.delete("12e");

        myHashMap.printHashMap();
    }
}