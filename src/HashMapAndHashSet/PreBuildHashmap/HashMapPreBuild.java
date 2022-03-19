package HashMapAndHashSet.PreBuildHashmap;

import java.util.HashMap;
import java.util.Set;

public class HashMapPreBuild {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Aditya", 20);
        map.put("Rahul", 22);
        map.put("Rohit", 23);
        map.put("Arjun", 24);
        map.put("Krishna", 26);
        map.put("Ram", 21);
        System.out.println(map);
        map.remove("Rahul");
        System.out.println(map);
        System.out.println(map.get("Aditya"));
        System.out.println(map.containsKey("Aditya"));

        Set<String> keySet = map.keySet();
        System.out.println(keySet);

        for (String key : keySet) {
            Integer val = map.get(key);
            System.out.println(key + " " + val);
        }
    }
}
