package exam;

import java.util.Scanner;

public class 美菜2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            str = str.trim();
            System.out.println(f(str));
        }
    }
    public static int f(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int left = 0;
        int res = 0;
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            left++;
        }
        while (left < str.length()) {
            int c = str.charAt(left++) - '0';
            if (c < 0 || c > 9) {
                break;
            }
            if (res > 214748364 || res == 214748364 && c > 8) {
                return str.charAt(0) == '-' ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = (res * 10 + c);
        }
        return str.charAt(0) == '-' ? -1 * res : res;
    }
}
