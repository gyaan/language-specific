package problem;

import java.util.*;

public class MakeTwoStringAnagram {
    public static int numberNeeded(String first, String second) {

        Map<Character, Integer> map1 = MakeTwoStringAnagram.createHashMap(first);
        Map<Character, Integer> map2 = MakeTwoStringAnagram.createHashMap(second);

        //iterate through map
        int count = 0;

        for (Iterator<Map.Entry<Character, Integer>> it = map1.entrySet().iterator(); it.hasNext(); ) {
            Map.Entry<Character, Integer> entry = it.next();
            Integer currentMapValue = entry.getValue();
            if (map2.containsKey(entry.getKey())) {
                Integer secondMapValue = map2.get(entry.getKey());
                if (currentMapValue != secondMapValue) {
                    count = count + Math.abs(currentMapValue - secondMapValue);
                }
                map2.remove(entry.getKey());
            } else {
                count = count + currentMapValue;
            }
            it.remove();

        }

        if (!map2.isEmpty()) {
            for (Map.Entry<Character, Integer> entry : map2.entrySet()) {
                count = count + entry.getValue();
            }
        }

        return count;
    }

    private static Map<Character, Integer> createHashMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char key = s.charAt(i);
            if (map.containsKey(key)){
                Integer integer = map.get(key);
                map.put(key, integer + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
