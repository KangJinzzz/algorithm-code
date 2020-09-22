package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 达达1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            int ways = Integer.valueOf(sc.nextLine());
            int n = Integer.valueOf(sc.nextLine());
            List<Xian> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String str = sc.nextLine();
                String[] strs = str.split(",");
                int s = Integer.valueOf(strs[0]);
                int e = Integer.valueOf(strs[1]);
                list.add(new Xian(s, e));
            }
            String string = sc.nextLine();
            String[] strs1 = string.split(",");
            int findS = Integer.valueOf(strs1[0]);
            int findE = Integer.valueOf(strs1[1]);
            List<Xian> res = new ArrayList<>();
            if (ways == 1) {
                res = f1(findS, findE, list);
            } else if (ways == 2) {
                res = f2(findS, findE, list);
            }
            for (Xian x : res) {
                System.out.println(x.start + "," + x.end);
            }
        }
    }

    public static List<Xian> f1(int findS, int findE, List<Xian> list) {
        List<Xian> res = new ArrayList<>();
        for (Xian x : list) {
            if (x.start >= findE && x.end <= findE) {
                res.add(new Xian(x.start, x.end));
            }
        }
        return res;
    }
    public static List<Xian> f2(int findS, int findE, List<Xian> list) {
        List<Xian> res = new ArrayList<>();
        for (Xian x : list) {
            if (findS >= x.start && findS <= x.end || findE >= x.start && findE <= x.end) {
                res.add(new Xian(x.start, x.end));
            }
        }
        return res;
    }
}




class Xian {
    public int start = 0;
    public int end = 0;

    public Xian(int start, int end) {
        this.start = start;
        this.end = end;
    }
}