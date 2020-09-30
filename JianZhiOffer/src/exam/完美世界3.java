package exam;

import java.util.Arrays;
import java.util.Scanner;

public class 完美世界3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] chars = str.toCharArray();
            int left = 0;
            int right = 0;
            int index = 0;
            while (left < chars.length - 1) {
                while (right < chars.length && chars[right] != '_') {
                    right++;
                }
                index = right + 1;
                right--;
                while (left < right) {
                    char tmp = chars[left];
                    chars[left] = chars[right];
                    chars[right] = tmp;
                    left++;
                    right--;
                }
                left = index;
                right = left;
            }
            System.out.println(String.valueOf(chars));
        }
    }
}
