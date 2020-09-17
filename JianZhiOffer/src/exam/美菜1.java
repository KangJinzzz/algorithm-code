package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 美菜1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String str = sc.nextLine();
            String[] strs = str.split("#");
            int row = strs.length;
            int col = strs[0].split(",").length;
            int[][] arr = new int[row][col];
            for (int i = 0; i < row; i++) {
                String[] tmp = strs[i].split(",");
                for (int j = 0; j < col; j++) {
                    arr[i][j] = Integer.valueOf(tmp[j]);
                }
            }
            List<Integer> list = new ArrayList<>();
            print(arr, list);
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    System.out.print(list.get(i) + ",");
                } else {
                    System.out.print(list.get(i));
                }
            }
        }


    }

    private static void print(int[][] arr, List<Integer> list) {
        int top = 0;
        int tail = arr.length - 1;
        int left = 0;
        int right = arr[0].length - 1;
        while (top <= tail && left <= right) {
            if (top <= tail && left <= right) {
                for (int i = left; i <= right; i++) {
                    list.add(arr[top][i]);
                }
                top++;
            }
            if (top <= tail && left <= right) {
                for (int i = top; i <= tail; i++) {
                    list.add(arr[i][right]);
                }
                right--;
            }
            if (top <= tail && left <= right) {
                for (int i = right; i >= left; i--) {
                    list.add(arr[tail][i]);
                }
                tail--;
            }
            if (top <= tail && left <= right) {
                for (int i = tail; i >= top; i--) {
                    list.add(arr[i][left]);
                }
                left++;
            }
        }
    }
}
