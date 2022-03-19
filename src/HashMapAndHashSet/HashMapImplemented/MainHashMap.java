package HashMapAndHashSet.HashMapImplemented;

public class MainHashMap {
    public static void main(String[] args) throws Exception {
        HashMapImplemented<String, Integer> obj = new HashMapImplemented<>();
        //insert Put
        obj.put("Aditya", 200);
        obj.put("rahul", 100);
        obj.put("rohit", 300);
        obj.put("ramesh", 140);
        obj.display();
        System.out.println();
        //update put
        obj.put("ramesh", 180);
        obj.display();
        //get
        System.out.println(obj.get("Aditya"));
        //contains Key
        System.out.println(obj.containsKey("Aditya"));
        //remove node
        System.out.println(obj.removeNode("rohit"));
        // size
        System.out.println(obj.size());
        //key set
        System.out.println(obj.keySet());
    }
}
