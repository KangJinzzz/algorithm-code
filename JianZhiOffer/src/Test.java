import java.util.ArrayList;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] numbers = {0,1,2,3,4,5,6};
        reOrderArray(numbers);

        System.out.println(Arrays.toString(numbers));

    }

    //面试题3：
    // 1.数组中重复的数字
    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length <= 0) {
                return false;
            }
            int[] arr = new int[length];
            for (int i = 0; i < length; i++) {
                if(numbers[i] < 0 || numbers[i] > length - 1) {
                    return false;
                }
            arr[numbers[i]]++;
        }
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] > 1) {
                duplication[0] = i;
                return true;
            }
        }
        return false;

//        if(numbers == null || length <= 0) {
//            return false;
//        }
//        for (int i = 0; i < length; i++) {
//            if(numbers[i] < 0 || numbers[i] > length - 1) {
//                return false;
//            }
//        }
//        for(int i = 0; i < length; i++) {
//            while(numbers[i] != i) {
//                if(numbers[i] == numbers[numbers[i]]) {
//                    duplication[0] = numbers[i];
//                    return true;
//                }
//                int temp = numbers[i];
//                numbers[i] = numbers[temp];
//                numbers[temp] = temp;
//            }
//        }
//        return false;
    }

    //面试题4：二维数组中的查找
    public boolean Find(int target, int [][] array) {
        if(array == null) {
            return false;
        }
        int row = 0;
        int col = array[0].length - 1;

        while(row <= array.length - 1 && col >= 0) {
            if(array[row][col] > target) {
                col--;
            }
            else if(array[row][col] < target) {
                row++;
            }
            else if(array[row][col] == target) {
                return true;
            }
        }
        return false;
    }

    //面试题5：替换空格
    public String replaceSpace(StringBuffer str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') {
                builder.append("%20");
            } else {
                builder.append(str.charAt(i));
            }
        }
        String string = builder.toString();
        return string;
    }

    //面试题6：从尾到头打印链表

    ArrayList list = new ArrayList();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null) {
            printListFromTailToHead(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }

    //面试题10：斐波那契数列
    //题目一：求斐波那契数列的第n行
    public int Fibonacci(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }
        int a = 0;
        int b = 1;
        int c = 0;
        for(int i = 1; i < n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    //青蛙跳台阶问题
    public int JumpFloor(int target) {
        int a = 1;
        int b = 2;
        int c = 0;
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        for(int i = 2; i < target; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return c;
    }
    //递归
//        if(target == 1) {
//           return 1;
//        }
//        if(target == 2) {
//            return 2;
//        }
//        return JumpFloor(target - 1) + JumpFloor(target - 2);

    // 面试题11：旋转数组的的最小数字
    public int minNumberInRotateArray(int [] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int index1 = 0;
        int index2 = array.length - 1;
        int mid = (index1 + index2) / 2;
        while(index1 < index2) {
            if(index2 - index1 == 1) {
                return array[index2];
            }
            //判断是否为  1111111  或  1011111 或 1111101 的情况，是则需要顺序查找
            if(array[index1] == array[index2] && array[index1] == array[mid]) {
                int resoult = array[index1];
                for(int i = 1; i < array.length; i++) {
                    if(resoult > array[i]) {
                        return array[i];
                    }
                }
                return resoult;
            }
            mid = (index1 + index2) / 2;
            if(array[index1] > array[mid]) {
                index2 = mid;
            } else {
                index1 = mid;
            }
        }
        return 0;
    }

    //面试题14：剪绳子
    public int cutRope(int target) {
        if(target < 2) {
            return 0;
        }
        if(target == 2) {
            return 1;
        }
        if(target == 3) {
            return 2;
        }
        int max = 0;
        //products[i]中每个元素代表长度为i的绳子剪成若干段后各段长度乘积的最大值(包括1*i，i可能是长度大于i的绳子剪下的)
        int[] products = new int[target + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;
        for(int i = 4; i <= target; i++) {
            max = 0;
            for(int j = 1; j <= target / 2; j++) {
                int product = products[j] * products[i - j];
                if(max < product) {
                    max = product;
                }
            }
            products[i] = max;
        }
        return max;
    }
    //面试题15：二进制中1的个数
    public int NumberOf1(int n) {
        int count = 0;
        while(n != 0) {
            n = n & (n - 1) ;
            count++;
        }
        return count;
    }
    //面试题16：整数的整次方
    public double Power(double base, int exponent) {
        boolean flag = true;
        if(exponent < 0) {
            flag = false;
            exponent = -exponent;
        }
        double resoult = getPower(base, exponent);
        return flag? resoult : 1 / resoult;
    }
    public double getPower(double base, int exponent) {
        if(exponent == 0) {
            return 1;
        }
        if(exponent == 1) {
            return base;
        }

        double resoult = getPower(base, exponent >> 1);
        resoult *=resoult;
        if((exponent & 1) == 1) {
            resoult *= base;
        }
        return resoult;
    }
    //面试题18：删除链表中重复的结点
    public ListNode deleteDuplication(ListNode pHead) {
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while(cur != null) {
            if(cur.next != null && cur.val == cur.next.val) {
                while(cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                newTail.next = new ListNode(cur.val);
                cur = cur.next;
                newTail = newTail.next;
            }

        }
        return newHead.next;
    }

    //面试题21：调整数组顺序使奇数位于偶数前面
    public static void reOrderArray(int [] array) {

        int len = array.length;
        if(len <= 1){ // 数组空或长度为1
            return;
        }

        int i = 0;
        while(i < len){
            int j = i + 1;
            if(array[i]%2 == 0){ // a[i]为偶数，j前进，直到替换
                while(array[j]%2 == 0){ // j为偶数，前进
                    if(j==len-1)// i为偶数，j也为偶数，一直后移到了末尾，证明后面都是偶数
                        return;
                    j++;
                }
                // 此时j为奇数
                int count = j-i;
                int temp = array[i];
                array[i] = array[j];
                while(count>1){
                    array[i+count] = array[i+count-1];//数组后移
                    count--;
                }
                array[i+1] = temp;
            }
            i++;
        }


   }
}

