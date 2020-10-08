package exam;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder builder = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!set.contains(c)) {
                    builder.append(c);
                    set.add(c);
                }
            }
            System.out.println(builder.toString());
        }
    }
}
