package problem;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashTablesRansomNote {
    Map<String, Integer> magazineMap;
    Map<String, Integer> noteMap;
    String magazine;
    String note;

    public HashTablesRansomNote(String magazine, String note) {
        this.magazine = magazine;
        this.note = note;
    }

    public boolean solve() {

        this.magazineMap = createStringMap(this.magazine);
        this.noteMap = createStringMap(this.note);

        for (Map.Entry<String, Integer> entry : this.noteMap.entrySet()) {
            if (this.magazineMap.containsKey(entry.getKey()) && this.magazineMap.get(entry.getKey()).equals(entry.getValue())) {
                continue;
            } else
                return false;
        }
        return true;
    }

    private Map<String, Integer> createStringMap(String s) {
        Map<String, Integer> map = new HashMap<>();
        String[] strings = s.split(" ");
        for (String st : strings) {
            if (map.containsKey(st)) {
                map.put(st, map.get(st).intValue() + 1);
            } else {
                map.put(st, 1);
            }
        }
        return map;
    }

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int m = scanner.nextInt();
//        int n = scanner.nextInt();

        // Eat whitespace to beginning of next line
//        scanner.nextLine();

        HashTablesRansomNote s = new HashTablesRansomNote("give me one grand today night", "give one grand today");
//        scanner.close();

        boolean answer = s.solve();
        if (answer)
            System.out.println("Yes");
        else System.out.println("No");

    }
}
