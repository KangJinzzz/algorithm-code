package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 完美世界2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                int count = map.getOrDefault(c, 0);
                map.put(c, count + 1);
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (map.get(c) == 1) {
                    System.out.print(c);
                }
            }
            System.out.println();
        }
        sc.close();
    }
}
