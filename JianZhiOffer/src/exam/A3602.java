package exam;

import java.util.*;

public class A3602 {
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int s = sc.nextInt();
            int t = sc.nextInt();
            Map<Integer, List<List<Integer>>> map = new HashMap<>();
            Map<Integer, Integer> used = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                int p = sc.nextInt();
                List<List<Integer>> t1 = map.getOrDefault(u, new ArrayList<>());
                List<Integer> t2 = new ArrayList<>();
                t2.add(v);
                t2.add(p);
                t1.add(t2);
                map.put(u, t1);
                used.put(u, 0);
                used.put(v, 0);
            }
            dfs(map, used, s, 0, s, t);
            System.out.println(min);
        }
    }

    public static void dfs(Map<Integer, List<List<Integer>>> map, Map<Integer, Integer> used, int cur, int len, int s, int t) {
        if (cur == t) {
            if (min > len) {
                min = len;
            }
            return;
        }
        List<List<Integer>> list = map.get(cur);
        if (list == null || list.size() == 0) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            int key = list.get(i).get(0);
            if (used.get(key) == 0) {
                used.put(key, 1);
                dfs(map, used, key, len + list.get(i).get(1), s, t);
                used.put(key, 0);
            }

        }
    }
}


//5 6 1 5
//1 5 100
//1 2 10
//2 5 5
//1 3 3
//3 4 2
//4 5 1