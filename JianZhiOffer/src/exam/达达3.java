package exam;

import java.util.*;

public class 达达3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int n = Integer.valueOf(sc.nextLine());
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                String[] strs = str.split(",");
                int key = Integer.valueOf(strs[0]);
                int times = Integer.valueOf(strs[1]);
                for (int j = 0; j < times; j++) {
                    list.add(key);
                }
            }
            Random random = new Random();
            while (list.size() > 0) {
                int r = random.nextInt(list.size());
                System.out.println(list.get(r));
                list.remove(r);
            }
        }

    }
}
