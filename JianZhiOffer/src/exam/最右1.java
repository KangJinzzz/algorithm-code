package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 最右1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String string = sc.nextLine();
            if (string == null || string.length() == 0) {
                System.out.println(0);
                continue;
            }
            Map<Character, Integer> map = new HashMap<>();
            int left = 0;
            if (string.charAt(0) == '-' || string.charAt(0) == '+') {
                left++;
            }
            for (int i = 0; i < 36; i++) {
                if (i < 10) {
                    map.put((char)('0' + i), i);
                } else {
                    map.put((char)('a' + i - 10), i);
                }
            }
            long res = 0;
            int pow = 0;
            for (int i = string.length() - 1; i >= left; i--) {
                char c = string.charAt(i);
                if (c == '-' || c == '+' || c >= '0' && c <= '9' || c >= 'a' && c <= 'z') {
                    res += Math.pow(36, pow++) * map.get(c);
                } else {
                    System.out.println(0);
                    return;
                }
            }
            res = string.charAt(0) == '-' ? (-1 * res) : res;
            System.out.println(res);
        }
    }
}
