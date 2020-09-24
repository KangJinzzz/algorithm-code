package exam;

import java.util.HashSet;
import java.util.Set;

public class 康冠 {
    static int count = 0;
    public static void main(String[] args) {
        int[] arr = new int[] {1,2,3,4};
        int[] used = new int[4];
        Set<String> set = new HashSet<>();
        dfs(arr, "", set, used);
        for (String s : set) {
            System.out.println(s);
        }
        System.out.println(count);
    }
    public static void dfs(int[] arr, String cur, Set<String> set, int[] used) {
        if (cur.length() >= 3) {
            if (!set.contains(cur)) {
                count++;
                set.add(cur);
            }
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            if (used[i] == 0) {
                used[i] = 1;
                dfs(arr, cur + arr[i], set, used);
                used[i] = 0;
            }
        }
    }
}
