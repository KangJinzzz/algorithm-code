package exam;

import java.util.*;

public class 便利蜂1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            StringBuilder builder = new StringBuilder(str);
            int flag = 0;
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) >= '0' || str.charAt(i) <= '9') {
                    builder.append(str.charAt(i));
                }
            }
            Map<Character, List<Character>> map = new HashMap<>();

            for (int i = 0; i < builder.length() - 1; i += 2) {
                char c = builder.charAt(i);
                List<Character> list = map.getOrDefault(c, new ArrayList<Character>());
                list.add(builder.charAt(i + 1));
                map.put(builder.charAt(i), list);
            }
//            for ()
        }
    }

//    public static boolean f(Map<Character, List<Character>> map, char c) {
//
//    }
}
