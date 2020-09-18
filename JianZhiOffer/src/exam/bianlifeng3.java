package exam;

import java.util.Scanner;
import java.util.Set;

public class bianlifeng3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int money = sc.nextInt();
            String str = sc.nextLine();
            String[] strs = str.split(",");
            int[] items = new int[strs.length];
            for (int i = 0; i < strs.length; i++) {
                items[i] = Integer.valueOf(strs[i]);
            }
//            Set<>
//            dfs()
        }
    }

}
