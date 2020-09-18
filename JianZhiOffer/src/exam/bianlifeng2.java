package exam;

import java.util.*;

public class bianlifeng2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String ss = sc.nextLine();
            Map<Character, List<Character>> map = new HashMap<>();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                char key = str.charAt(0);
                set.add(key);
                char value = str.charAt(str.length() - 1);
                List<Character> list = map.getOrDefault(key, new ArrayList<Character>());
                list.add(value);
                map.put(key, list);
            }
            boolean flag = false;
            for (char c : set) {
                if (f(c, map)) {
                    flag = true;
                    break;
                }
            }
            if (flag) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }
    public static boolean f(char c, Map<Character, List<Character>> map) {
        Queue<Character> queue = new LinkedList<>();
        queue.offer(c);
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            List<Character> list = map.getOrDefault(ch, new ArrayList<Character>());
            for (char cha : list) {
                if (cha == c) {
                    return false;
                }
                queue.offer(cha);
            }
        }
        return true;
    }

}
