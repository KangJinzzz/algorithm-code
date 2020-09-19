package exam;

import java.util.Scanner;

public class 四达1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String ss = sc.nextLine();
        MyQueue queue = new MyQueue(s);
        int offerTimes = 0;
        int pollTimes = 0;
        while (sc.hasNext()) {
            String option = sc.nextLine();
            if (option.equals("END")) {
                break;
            }
            char[] chars = option.toCharArray();
            if (chars[0] == 'P') {
                if (!queue.offer(chars[2])) {
                    offerTimes++;
                }
            }
            if (chars[0] == 'D') {
                if (!queue.poll()) {
                    pollTimes++;
                }
            }
        }
        System.out.println(offerTimes);
        System.out.println(pollTimes);
        for (int i = 0; i < queue.length; i++) {
            System.out.print(queue.arr[(queue.head + i) % queue.size]);
        }
    }
}

class MyQueue {
    char[] arr;
    int size = 0;
    int length = 0;
    int head = 0;
    int tail = 0;

    public MyQueue(int size) {
        this.size = size;
        arr = new char[size];
    }

    public boolean offer(char val) {
        if (length < size - 1) {
            arr[tail] = val;
            tail = (tail + 1) % size;
            length++;
            return true;
        }
        return false;
    }

    public boolean poll() {
        if (length <= 0) {
            return false;
        }
        head = (head + 1) % size;
        length--;
        return true;
    }

}
