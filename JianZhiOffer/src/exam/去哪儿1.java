package exam;

import java.util.Scanner;

public class 去哪儿1 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int A = 1;
            int C = 1;
            for (int i = n; i >= 1; i--) {
                A *= i;
            }
            for (int i = 0; i < n; i++) {
                C *= (m - i);
            }
            System.out.println(C / A);
        }
    }
}
