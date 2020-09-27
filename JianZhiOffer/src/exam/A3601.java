package exam;

import java.util.Scanner;

public class A3601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int k = sc.nextInt();
            int v = sc.nextInt();
            int res = 0;
            while (a > 0) {
                int gejian = 1;
                while (b > 0 && gejian < k) {
                    b--;
                    gejian++;
                }
                int cap = gejian * v;
                a -= cap;
                res++;
            }
            System.out.println(res);
        }
    }
}
