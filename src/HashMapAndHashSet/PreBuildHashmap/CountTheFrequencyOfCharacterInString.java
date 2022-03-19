package HashMapAndHashSet.PreBuildHashmap;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

public class CountTheFrequencyOfCharacterInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Any String");
        String str = sc.next();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character ch = str.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }
        Set<Character> set = map.keySet();
        Character chr = str.charAt(0);
        for (Character c : set) {
            if (map.get(c) > map.get(chr)) {
                chr = c;
            }
        }
        System.out.println(chr);
    }
}
