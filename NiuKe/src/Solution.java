import java.util.*;

//day_17 火车进站
//day_16 洗牌
//day_19 子串判断
//day_25 人民币转换
//day_31简单错误记录
//day_32 2的个数
//day_37 地下迷宫

public class Solution {

    //输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向
    public TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if(pRootOfTree.left == null && pRootOfTree.right== null) {
            return pRootOfTree;
        }
        TreeNode left = Convert(pRootOfTree.left);
        TreeNode leftTail = left;
        while(leftTail != null && leftTail.right != null) {
            leftTail = leftTail.right;
        }
        if(left != null) {
            leftTail.right = pRootOfTree;
            pRootOfTree.left = leftTail;
        }
        TreeNode right = Convert(pRootOfTree.right);
        if(right != null) {
            pRootOfTree.right = right;
            right.left = pRootOfTree;
        }
        return left != null ? left : pRootOfTree;

    }



}

//[编程题]旧键盘 (20)
class Main0 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<Character> actual = new HashSet<>();
        Set<Character> print = new HashSet<>();
        while (scanner.hasNext()) {
            String s1 = scanner.next();
            String s2 = scanner.next();
            s1 = s1.toUpperCase();
            s2 = s2.toUpperCase();
            for(int i = 0; i < s2.length(); i++) {
                actual.add(s2.charAt(i));
            }
            for(int i = 0; i < s1.length(); i++) {
                char c = s1.charAt(i);
                //
                if(actual.contains(c)) {
                    continue;
                }
                if(print.contains(c)) {
                    continue;
                }
                System.out.print(c);
                print.add(c);
            }
        }
    }
}


//下厨房
class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Set<String> set = new HashSet<>();

        while(scanner.hasNext()) {
            String material = scanner.next();

            String[] arr = material.split(" ");
            for (String str : arr) {
                set.add(str);
            }
        }
        System.out.println(set.size());
    }
}

//Fibonacci数列
class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int a = 0;
            int b = 1;
            int c = a + b;
            while (true) {
                if(n == c) {
                    System.out.println(0);
                    return;
                } else if(n > c) {
                    a = b;
                    b = c;
                    c = a + b;
                } else {
                    int min = n - b;
                    if((c - n) < min) {
                        min = c - n;
                    }
                    System.out.println(min);
                    return;
                }
            }

        }
    }
}

//字符串中找出连续最长的数字串
class Main3 {
    public static void fun(String str) {
        StringBuilder sb = new StringBuilder();
        String print = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                sb.append(str.charAt(i));
            } else {
                if (sb.toString().length() > print.length()) {
                    print = sb.toString();
                } else if (sb.length() > 0) {
                    sb.delete(0, sb.length());
                }
            }
            if (i == str.length() - 1) {
                if (sb.toString().length() > print.length()) {
                    print = sb.toString();
                }
            }
        }
        System.out.println(print);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            fun(str);
        }
    }
}

//统计回文
class Main4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String A;
        String B;
        int ret = 0;
        while (!sc.hasNext("0")) {
            A = sc.nextLine();
            B = sc.nextLine();
            for (int i = 0; i <= A.length(); i++) {
                StringBuilder builder = new StringBuilder(A);
                builder.insert(i, B);
                if (fun(builder.toString())) {
                    ret++;
                }
            }
        }
        System.out.println(ret);
    }
    public static Boolean fun(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right)  {
            if (str.charAt(left) == str.charAt(right)) {
                left++;
                right--;
            } else {
                return false;
            }
        }
        return true;
    }
}

//寻找第k大
class Finder {
    public int findKth(int[] a, int n, int K) {
        return quickSort(a, 0, n - 1, K);
    }

    public int quickSort(int[] a, int left, int right, int K) {
        int pivotIndex = partion(a, left, right);
        if (pivotIndex + 1== K) {
            return a[pivotIndex];
        }
        if (pivotIndex + 1 > K) {
            return quickSort(a, left, pivotIndex - 1, K);
        }
        return quickSort(a, pivotIndex + 1, right, K);
    }

    public int partion(int[] a, int left, int right) {
        int i = left;
        int j = right;
        int pivot = a[left];
        while (i < j) {
            while (i < j && a[j] <= pivot) {
                j--;
            }
            while (i < j && a[i] >= pivot) {
                i++;
            }
            swap(a, i, j);
        }
        swap(a, i, left);
        return i;
    }

    public void swap(int[] a, int left, int right) {
        int temp = a[left];
        a[left] = a[right];
        a[right] = temp;
    }
}

//汽水瓶
class Main5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int drink = 0;
            int blank = 0;
            blank = sc.nextInt();
            if (blank > 0 && blank <= 100) {
                while (blank >= 3) {
                    drink += blank / 3;
                    blank = blank / 3 + blank % 3;
                }
                if (blank == 2) {
                    drink++;
                }
                System.out.println(drink);
            }

        }
    }
}

//数组中的逆序对
//利用归并排序
class AntiOrder {

    public int count(int[] A, int n) {
        return mergeSort(A, 0, n);
    }
    public int mergeSort(int[] a, int left, int right){
        if (left >= right || right -  left == 1) {
            // 空区间或者区间只有一个元素, 都不需要进行归并排序
            return 0;
        }
        int mid = (right + left) / 2;
        return mergeSort(a, left, mid) + mergeSort(a, mid, right) + merge(a, left, mid, right);
    }


    public int merge(int[] a, int left, int mid, int right) {
        int[] extra = new int[right - left];
        int index = 0;
        int i = left;
        int j = mid;
        int reverseNum = 0;
        while (i < mid && j < right) {
            if (a[i] <= a[j]) {
                extra[index++] = a[i++];
            } else {
                extra[index++] = a[j++];
                reverseNum += (mid - i);
            }
        }
        while (i < mid) {
            extra[index++] = a[i++];
        }
        while (j < right) {
            extra[index++] = a[j++];
        }
        for (int t = 0; t < extra.length; t++) {
            a[left + t] = extra[t];
        }
        return reverseNum;
    }
}

//逆序对
class Main6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int left = 0;
        int flag = 0;
        int max = 0;
        int i = 0;
        while (i < str.length()) {
            if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                left = i;
                while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                    i++;
                }
                if (i - left > max) {
                    flag = left;
                    max = i - left;
                }
            } else {
                i++;
            }
        }
        System.out.println(str.substring(flag, flag + max));
    }
}

//括号匹配
class Parenthesis {
    public boolean chkParenthesis(String A, int n) {
        Stack<Character> stack = new Stack<>();
        for (char ch : A.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            }
            else if (ch == ')') {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

//买苹果
class Main7 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            if (n < 1 || n > 100) {
                return;
            }
            if (n < 6 || n == 10 || n % 2 == 1) { //6和8可以组成大于10的任意一个偶数
                System.out.println(-1);
            } else if (n % 8 == 0){
                System.out.println(n / 8);
            } else {
                System.out.println(1 + n / 8); //对于10以上的偶数，只要对8取余数不为0，就要从前面的1或者2个8中
                                                // 拿出2个，把余数补为6（本来余数就是6，就不用拿）。所以+1；
            }
        }
    }
}

//删除公共字符串
class Main8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            StringBuilder builder = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str2.length(); i++) {
                set.add(str2.charAt(i));
            }
            for (int i = 0; i < str1.length(); i++) {
                if (!set.contains(str1.charAt(i))) {
                    builder.append(str1.charAt(i));
                }
            }
            System.out.println(builder.toString());
        }
    }
}

//神奇的口袋
class Main9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[][] dp = new int[n + 1][40 + 1];
        System.out.println(f(arr, dp));

    }
    public static int f(int[] arr, int[][] dp) {
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= 40; j++) {
                if (j < arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i- 1][j] + dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        return dp[arr.length][40];
    }
}

//用两个栈实现队列
class Solution1 {

}

//计算糖果
class Main10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] arr = new int[4];
        arr[0] = sc.nextInt();
        arr[1] = sc.nextInt();
        arr[2] = sc.nextInt();
        arr[3] = sc.nextInt();
        if (arr[0] - arr[2] + arr[1] + arr[3] != 0) {
            System.out.println("No");
            return;
        }
        int C = (arr[3] - arr[1]) / 2;
        int B = (arr[1] + arr[3]) / 2;
        int A = arr[2] - (arr[1] + arr[3]) / 2;

        System.out.println(A + " " + B + " " + C);
    }
}

//n个数里出现次数大于等于n/2的数
class Main11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (sc.hasNextInt()) {
            list.add(sc.nextInt());
        }
        Collections.sort(list);
        System.out.println(list.get(list.size() / 2));
    }
}

//不要二
class Main12{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt(); //行
            int n = sc.nextInt(); //列
            int prevCount = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
            int lastCount = (n / 4) * 2 + (n % 4 > 2 ? 1 : 0);
            int ret = (m / 4) * (2 * prevCount + 2 * lastCount);
            if (m % 4 == 0) {
                System.out.println(ret);
                return;
            } else if (m % 4 == 1) {
                ret += prevCount;
            } else if (m % 4 == 2) {
                ret += 2 * prevCount;
            } else {
                ret += (2 * prevCount + lastCount);
            }
            System.out.println(ret);
        }
    }
}

//求最小公倍数
class Main13{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int max = A > B ? A : B;
            int ret = max;
            while (true) {
                if (ret % A == 0 && ret % B == 0) {
                    System.out.println(ret);
                    return;
                } else {
                    ret += max;
                }
            }
        }
    }
}

//删数
class Main14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            Queue<Integer> queue = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                queue.offer(i);
            }
            int cyc = 0;
            while (queue.size() > 1) {
                if (cyc == 2) {
                    queue.poll();
                    cyc = 0;
                } else {
                    queue.offer(queue.poll());
                    cyc++;
                }
            }
            System.out.println(queue.peek());
        }
    }
}

//n个数里最小的k个
class Main15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            String[] s = str.split(" ");
            int[] arr = new int[s.length - 1];
            for (int i = 0; i < s.length - 1; i++) {
                arr[i] = Integer.parseInt(s[i]);
            }
            int k = Integer.parseInt(s[s.length - 1]);
            fun(arr, 0, arr.length - 1, k);
            int[] print = new int[k];
            for (int i = 0; i < k; i++) {
                print[i] = arr[i];
            }
            Arrays.sort(print);
            for (int i = 0; i < print.length; i++) {
                System.out.print(print[i]);
                if (i != k - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
    public static void fun(int[] arr, int left, int right, int k) {
        int pivotIndex = partion(arr, left, right);
        if (pivotIndex == k - 1) {
            return;
        }
        if (pivotIndex > k - 1) {
            fun(arr, left, pivotIndex - 1, k);
            return;
        }
        fun(arr, pivotIndex + 1, right, k);
    }
    public static int partion(int[] arr, int left, int right) {
        int pivot = arr[left];
        int pivotIndex = 0;
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && arr[j] >= pivot) {
                j--;
            }
            while (i < j && arr[i] <= pivot) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);
        return i;
    }

    public static void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}

//末尾0的个数
//10由5*偶数构成，只要统计5的个数
//1、 每隔5个，会产生一个0，比如 5， 10 ，15，20.。。
//2 、每隔 5×5 个会多产生出一个0，比如 25，50，75，100
//3 、每隔 5×5×5 会多出一个0，比如125.
class Main16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            int count = 0;
            while (n > 0) {
                n = n / 5;
                count += n;
            }
            System.out.println(count);
        }
    }
}

//数字颠倒
class Main17 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            print(n);
        }
    }
    public static void print(int n) {
        System.out.print(n % 10);
        if (n >= 10) {
            print(n / 10);
        }
    }
}

//Fibonacci数列
class Main18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            System.out.println(fun(n));
        }
    }
    public static int fun(int n) {
        int a = 0;
        int b = 1;
        int c = a + b;
        while (c < n) {
            a = b;
            b = c;
            c = a + b;
        }
        if (c == n) {
            return 0;
        }
        return c - n < n - b ? c - n : n - b;
    }
}

//机器人走方格I
class Robot {
    public int countWays(int x, int y) {
        if  (x == 0 || y == 0) {
            return 0;
        }
        if (x == 1|| y == 1) {
            return 1;
        }
        return countWays(x - 1, y) + countWays(x, y - 1);
    }
}

//个位数统计
class Main19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            int[] arr = new int[10];
            String n = sc.nextLine();
            for (int i = 0; i < n.length(); i++) {
                int index = n.charAt(i) - '0';
                arr[index]++;
            }
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) {
                    System.out.println(i + ":" + arr[i]);
                }
            }
        }
    }
}

//构建乘积数组
class Solution2 {
    public int[] multiply(int[] A) {

        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            B[i] = B[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = A.length - 2; i >= 0; i--) {
            temp *= A[i + 1];
            B[i] *= temp;
        }
        return B;
    }
}

//无缓存交换
class Exchange {
    public int[] exchangeAB(int[] AB) {
        AB[0] = AB[0] ^ AB[1];
        AB[1] = AB[0] ^ AB[1];
        AB[0] = AB[0] ^ AB[1];
        return AB;
    }
}

//生成格雷码
class GrayCode {
    public static void main(String[] args) {
        String[] strs = getGray(2);
        for (String str : strs) {
            System.out.print(str + " ");
        }
    }
    public static String[] getGray(int n) {
        if (n == 1) {
            return new String[] {"0", "1"};
        }
        String[] str = getGray(n - 1);
        String[] newStr = new String[str.length * 2];
        for (int i = 0,j = newStr.length - 1; i < j; i++,j--) {
            newStr[i] = str[i];
            newStr[j] = str[i];
        }
        for (int i = 0; i < newStr.length; i++) {
            if (i <= newStr.length / 2 - 1) {
                newStr[i] = "0" + newStr[i];
            } else {
                newStr[i] = "1" + newStr[i];
            }
        }
        return newStr;
    }
}

//跟奥巴马一起编程
class Main20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            char c = sc.next().charAt(0);
            int row = n / 2;
            if (n % 2 == 1) {
                row++;
            }
            int col = n;
            for (int i = 0; i < row; i++) {
                for (int j = 0; j < col; j++) {
                    if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                        System.out.print(c);
                        if (j == col - 1) {
                            System.out.println();
                        }
                    } else {
                        System.out.print(' ');
                    }
                }
            }
        }
    }
}

//超长正整数相加
class Main21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            StringBuilder builder = new StringBuilder();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            while (str1.length() != str2.length()) {
                if (str1.length() < str2.length()) {
                    str1 = "0" + str1;
                }else {
                    str2 = "0" + str2;
                }
            }
            int car = 0;
            for (int i = str1.length() - 1; i >= 0; i--) {
                int sum = 0;
                int a = str1.charAt(i) - '0';
                int b = str2.charAt(i) - '0';
                sum = a + b + car;
                builder.append(sum % 10);
                car = sum / 10;
            }
            if (car != 0) {
                builder.append(car);
            }
            System.out.println(builder.reverse().toString());
        }
    }
}

//组个最小数
class Main22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] arr = new int[10];
            for (int i = 0; i < 10; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 1; i < 10; i++) {
                if (arr[i] > 0) {
                    System.out.print(i);
                    arr[i]--;
                    break;
                }
            }
            for (int i = 0; i < 10; i++) {
                while (arr[i] > 0) {
                    System.out.print(i);
                    arr[i]--;
                }
            }
        }
    }
}

//尼科彻斯定理
class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int m = sc.nextInt();
            int sum = 0;
            for (int i = 1; i <= m - 1; i++) {
                sum += i;
            }
            int start = 2 * sum + 1;
            for (int i = 0; i < m; i++) {
                System.out.print(start);
                start += 2;
                if (i != m - 1) {
                    System.out.print("+");
                }
            }
            System.out.println();
        }
    }
}

//另类加法
//A ^ B = A + B (但没有包括进位) 1 ^ 1 = 0, 1 ^ 0 = 1, 0 ^ 0, = 0
//A & B = A + B 各位的进位   1 & 1 = 1, 1 & 0 = 0, 0 & 0 = 0
class UnusualAdd {
    public int addAB(int A, int B) {
        int xor = 0;
        int and = 0;
        while (B != 0) {
            xor = A ^ B;
            and = (A & B) << 1;
            A = xor;
            B = and;
        }
        return xor;
    }
}

//饥饿的小易
//4 * x + 3 是执行了 2 次 2 * x + 1
//8 * x + 7 是执行了 3 次
class Main23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = sc.nextInt();
            int count = 0;
            while (x != 0 && count <= 300000) {
                x = ((x << 1) + 1) % 1000000007;
                count++;
            }
            int res = (count + 2) / 3;
            System.out.println(res > 100000 ? -1 : res);
        }
    }
}


//洗牌
/**
 * 每次读取一个数之后，算出他经过k次洗牌后的位置，只用一个长度为2n数组用来输出
 * 根据当前数的位置，可以算出经过一次洗牌后的位置
 * 如果当前数小于等于n（即在左手），则他下次出现的位置是 2*当前位置-1
 * 如果当前位置大于n（即在右手）,则他下次出现的位置是 2*（当前位置 - n）
 * 个人建议在线面试题的时候如果5分钟内没想到好方法建议就使用暴力方法，
 * 毕竟测试用例不通过什么都没用
 */
class Main24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int groups = sc.nextInt();
        while (groups-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] res = new int[2*n];
            for(int i=0;i<2*n;i++){
                int tmp = i + 1;
                for(int j = 0; j < k;j++){
                    if (tmp <= n) tmp = 2*tmp - 1;
                    else tmp = 2 * (tmp - n);
                }
                res[tmp - 1]=sc.nextInt();
            }
            //输出
            if(res.length> 0) System.out.print(res[0]);
            for(int i = 1;i< 2*n;i++){
                System.out.print(" "+res[i]);
            }
            System.out.println();
        }
    }
}

//统计同成绩学生人数
class Main25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            if (n == 0) {
                return;
            }
            for (int i  = 0; i < n; i++) {
                int score = sc.nextInt();
                int num = map.getOrDefault(score, 0);
                map.put(score, num + 1);
            }
            int get_score = sc.nextInt();
            System.out.println(map.getOrDefault(get_score, 0));

        }
    }
}




//二叉树的镜像
class Solution3 {
    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        Mirror(root.left);
        Mirror(root.right);
    }
}

//DNA序列
class Main26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int n = sc.nextInt();
            int max = 0;
            int index = 0;
            for (int i = 0; i <= str.length() - n; i++) {
                int count = 0;
                for (int j = i; j < i + n; j++) {
                    if (str.charAt(j) == 'G' || str.charAt(j) == 'C') {
                        count++;
                    }
                }
                if (count > max) {
                    max = count;
                    index = i;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(str.charAt(index++));
            }
        }
    }
}

//百万富翁问题
class Main27 {
    public static void main(String[] args){
        long sumRich=0;
        long sumStranger=0;
        for(int i=1;i<=30;i++){
            sumRich+=10;
            sumStranger=sumStranger+(long)Math.pow(2,i-1);
        }
        System.out.print(sumRich+" "+sumStranger);
    }
}

//子串判断
class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.contains(p[i]);
        }
        return res;
    }
}

//成绩排序
class Student {
    public String name;
    public  int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}
class Main28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            List<Student> list = new ArrayList<>();
            int n = sc.nextInt();
            int sortWay = sc.nextInt();
            for (int i = 0; i < n; i++) {
                String name = sc.next();
                int score = sc.nextInt();
                Student student = new Student(name, score);
                list.add(new Student(name, score));
            }
            if (sortWay == 1) {
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.score - o2.score;
                    }
                });
            } else if (sortWay == 0) {
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.score - o1.score;
                    }
                });
            }
            for (Student stu : list) {
                System.out.println(stu.name + " " + stu.score);
            }
        }
    }
}

//微信红包
class Gift {
    public int getValue(int[] gifts, int n) {
        int count = 0;
        int temp = 0;
        for (int i = 0; i < n; i++) {
            if (count == 0) {
                temp = gifts[i];
                count++;
            } else {
                if (temp == gifts[i]) {
                    count++;
                } else {
                    count--;
                }
            }
        }
        count = 0;
        for (int i = 0; i < n; i++) {
            if (gifts[i] == temp) {
                count++;
            }
        }
        return (count > n / 2) ? temp : 0;
    }
}

//链表分割
class Partition {
    public ListNode partition(ListNode pHead, int x) {
        ListNode sHead = new ListNode(-1);
        ListNode sTail = sHead;
        ListNode bHead = new ListNode(-1);
        ListNode bTail = bHead;
        for (ListNode node = pHead; node != null; node = node.next) {
            if (node.val < x) {
                sTail.next = new ListNode(node.val);
                sTail = sTail.next;
            } else {
                bTail.next = new ListNode(node.val);
                bTail = bTail.next;
            }
        }
        sTail.next = bHead.next;
        return sHead.next;
    }
}

//统计每个月兔子的总数
//每个月兔子的数量与斐波那契数列一致，即可用递归
class Main29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int month = sc.nextInt();
            int m1 = 1;    //月份为1的兔子数量
            int m2 = 0;    //月份为2的兔子数量
            int m3 = 0;    //成熟的兔子数量
            //循环month - 1次
            while (--month > 0) {
                m3 += m2;
                m2 = m1;
                m1 = m3;
            }
            System.out.println(m1 + m2 + m3);
        }
    }
}

//最难得问题
class Main30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String hibun = sc.nextLine();
            for (int i = 0; i < hibun.length(); i++) {
                char ch = hibun.charAt(i);
                if (ch >= 'F' && ch <= 'Z') {
                    System.out.print((char)(ch - 5));
                } else if (ch >= 'A' && ch <= 'E') {
                    System.out.print((char)(ch + 21));
                } else {
                    System.out.print(ch);
                }
            }
            System.out.println();
        }
    }
}

//到底买不买
class Main31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            HashMap<Character, Integer> map = new HashMap<>();
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            for (int i = 0; i < str1.length(); i++) {
                int count = map.getOrDefault(str1.charAt(i), 0);
                map.put(str1.charAt(i), count + 1);
            }
            int lack = 0;
            for (int i = 0; i < str2.length(); i++) {
                if (map.containsKey(str2.charAt(i)) && map.get(str2.charAt(i)) > 0) {
                    int count = map.get(str2.charAt(i));
                    map.put(str2.charAt(i), count - 1);
                } else {
                    lack++;
                }
            }
            if (lack > 0) {
                System.out.println("No " + lack);
            } else {
                System.out.println("Yes " + (str1.length() - str2.length()));
            }
        }
    }
}

//链式A+B
class Plus {
    public ListNode plusAB(ListNode a, ListNode b) {
        ListNode listNode = new ListNode(-1);
        ListNode tail = listNode;
        int car = 0;
        while (a != null || b != null || car != 0) {
            int aVal = a != null ? a.val : 0;
            int bVal = b != null ? b.val : 0;
            int sum = aVal + bVal + car;
            int nu = sum % 10;
            car = sum / 10;
            tail.next  = new ListNode(nu);
            tail = tail.next;
            a = a != null ? a.next : null;
            b = b != null ? b.next : null;
        }
        return listNode.next;
    }
}

//二叉树平衡检查
class Balance {
    public boolean isBalance(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            return false;
        }
        return isBalance(root.left) && isBalance(root.right);
    }
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        return 1 + (leftDepth > rightDepth ? leftDepth : rightDepth);
    }
}

//数字分类
class Main32 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int A1 = 0;
            int count1 = 0;
            int A2 = 0;
            int count2 = 0;
            int A3 = 0;

            double A4 = 0;
            int count4 = 0;
            int A5 = 0;
            int count5 = 0;
            while (n-- > 0) {
                int num = sc.nextInt();
                switch(num % 5) {
                    case 0:
                        if (num % 2 == 0) {
                            count1++;
                            A1 += num;
                        }
                        break;
                    case 1:
                        A2 += (num * Math.pow(-1, count2++));
                        break;
                    case 2:
                        A3++;
                        break;
                    case 3:
                        A4 += num;
                        count4++;
                        break;
                    case 4:
                        A5 = A5 > num ? A5 : num;
                        count5++;
                        break;
                    default:
                        break;
                }
            }
            A4 /= count4;
            if (count1 > 0) {
                System.out.print(A1 + " ");
            } else {
                System.out.print("N ");
            }
            if (count2 > 0) {
                System.out.print(A2 + " ");
            } else {
                System.out.print("N ");
            }
            if (A3 > 0) {
                System.out.print(A3 + " ");
            } else {
                System.out.print("N ");
            }
            if (count4 > 0) {
                System.out.printf("%.1f ", A4);
            } else {
                System.out.print("N ");
            }
            if (count5 > 0) {
                System.out.println(A5);
            } else {
                System.out.println("N");
            }
        }
    }
}

//小易的升级之路
class Main33 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int init = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                if(init >= arr[i]) {
                    init += arr[i];
                } else {
                    int gcd = GCD(init, arr[i]);
                    init += gcd;
                }
            }
            System.out.println(init);
        }
    }
    public static int GCD(int a, int b) {
        if (b % a == 0) {
            return a;
        }
        return GCD(b % a, a);
    }
}

//最高分是多少
class Main34 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int oper = sc.nextInt();
            ArrayList<Integer> result = new ArrayList<>();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            for (int i = 0; i < oper; i++) {
                char C = sc.next().charAt(0);
                int A = sc.nextInt();
                int B = sc.nextInt();
                if (C == 'Q') {
                    int max = arr[A];
                    for (int j = A; j <= B; j++) {
                        max = max > arr[j] ? max : arr[j];
                    }
                    result.add(max);
                }
                if (C == 'U') {
                    arr[A] = B;
                }
            }
            for (int x : result) {
                System.out.println(x);
            }
        }
    }
}

//学分绩点
class Main35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] credit = new int[n];
            int creSum = 0;
            double[] grade = new double[n];
            double graSum = 0;
            for (int i = 0; i < n; i++) {
                credit[i] = sc.nextInt();
                creSum += credit[i];
            }
            for (int i = 0; i < n; i++) {
                int score = sc.nextInt();
                if (score >= 90 && score <= 100) {
                    grade[i] = 4.0 * credit[i];
                } else if (score >= 85 && score <= 89) {
                    grade[i] = 3.7 * credit[i];
                } else if (score >= 82 && score <= 84) {
                    grade[i] = 3.3 * credit[i];
                } else if (score >= 78 && score <= 81) {
                    grade[i] = 3.0 * credit[i];
                } else if (score >= 75 && score <= 77) {
                    grade[i] = 2.7 * credit[i];
                } else if (score >= 72 && score <= 74) {
                    grade[i] = 2.3 * credit[i];
                } else if (score >= 68 && score <= 71) {
                    grade[i] = 2.0 * credit[i];
                } else if (score >= 64 && score <= 67) {
                    grade[i] = 1.5 * credit[i];
                }else if (score >= 60 && score <= 63) {
                    grade[i] = 1.0 * credit[i];
                } else {
                    grade[i] = 0;
                }
                graSum += grade[i];
            }
            System.out.printf("%.2f",graSum / creSum);
        }
    }
}

//数字之和
class Main36 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int n2 = n * n;
            int nSum = 0;
            int n2Sum = 0;
            while (n > 0) {
                nSum += (n % 10);
                n /= 10;
            }
            while (n2 > 0) {
                n2Sum += (n2 % 10);
                n2 /= 10;
            }
            System.out.println(nSum + " " + n2Sum);
        }
    }
}

//计票统计
class Main37 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int invalid = 0;
            int n = sc.nextInt();
            HashMap<String, Integer> map = new LinkedHashMap<>();
            for (int i = 0; i < n; i++) {
                map.put(sc.next(), 0);
            }
            int votes = sc.nextInt();
            for (int i = 0; i < votes; i++) {
                String name = sc.next();
                if (map.containsKey(name)) {
                    int count = map.get(name);
                    map.put(name, count + 1);
                } else {
                    invalid++;
                }
            }

            for(Map.Entry entry : map.entrySet()) {
                System.out.println(entry.getKey()+" : "+entry.getValue());
            }
            System.out.println("Invalid : "+invalid);
        }
    }
}

//找x
class Main38 {
    public static void main(String[] ags) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            Map<Integer, Integer> map = new HashMap<>();
            int n = sc.nextInt();
            int index = 0;
            for (int i = 0; i < n; i++) {
                map.put(sc.nextInt(), index++);
            }
            int result = sc.nextInt();
            if (map.containsKey(result)) {
                System.out.println(map.get(result));
            } else {
                System.out.println(-1);
            }
        }
    }
}

//整数与IP地址间的转换
class Main39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strIp = sc.next();
            long result1 = ipTOLong(strIp);
            Long longIp = sc.nextLong();
            String result2 = longToIp(longIp);
            System.out.println(result1);
            System.out.println(result2);
        }
    }

    private static String longToIp(long ip) {
        StringBuilder builder = new StringBuilder();
        String binary = Long.toBinaryString(ip);
        int len = 32 - binary.length();
        for (int i = 0; i < len; i++) {
            binary = "0" + binary;
        }
        String[] strs = new String[] {binary.substring(0, 8), binary.substring(8, 16)
                , binary.substring(16, 24), binary.substring(24, 32)};
        for (int i = 0; i < strs.length; i++) {
            int temp = 0;
            String str = strs[i];
            int index = 0;
            for (int j = 7; j >= 0; j--) {
                if (str.charAt(index++) == '1') {
                    temp += ((int)Math.pow(2, j));
                }
            }
            builder.append(temp);
            if (i != strs.length - 1) {
                builder.append(".");
            }
        }
        return builder.toString();
    }

    public static long ipTOLong(String ip) {
        String[] strs = ip.split("\\.");
        StringBuilder builder = new StringBuilder();
        long ret = 0;
        for (int i = 0; i < strs.length; i++) {
            ret += Long.parseLong(strs[i]);
            if (i != strs.length - 1) {
                ret <<= 8;
            }
        }
        return ret;
    }
}

//守形数
class Main40 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            boolean flag = true;
            int n2 = n * n;
            while (n > 0) {
                if ((n % 10) != (n2 % 10)) {
                    flag = false;
                    break;
                }
                n /= 10;
                n2 /= 10;
            }
            if (flag) {
                System.out.println("Yes!");
            } else {
                System.out.println("No!");
            }
        }
    }
}

//密码验证合格程序
class Main41 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            fun(str);
        }
    }
    public static void fun(String str) {
        //1.密码长度超过8位
        if (str.length() <= 8) {
            System.out.println("NG");
            return;
        }
        //2.种类出现3种及以上
        int types = 0;
        int upper = 0;
        int lower = 0;
        int num = 0;
        int other = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch >= 'A' && ch <= 'Z') {
                upper++;
            } else if (ch >= 'a' && ch <= 'z') {
                lower++;
            } else if (ch >= '0' && ch <= '9') {
                num++;
            } else {
                other++;
            }
        }
        types = (upper > 0 ? 1 : 0) + (lower > 0 ? 1 : 0) + (num > 0 ? 1 : 0) + (other > 0 ? 1 : 0);
        if (types < 3) {
            System.out.println("NG");
            return;
        }
        //3.子串长度不超过2
        for (int i = 3; i < str.length() - 2; i++) {
            for (int j = 0; j < i - 2; j++) {
                if (str.charAt(i) == str.charAt(j) && str.charAt(i + 1) == str.charAt(j + 1) && str.charAt(i + 2) == str.charAt(j + 2)) {
                    System.out.println("NG");
                    return;
                }
            }
        }
        System.out.println("OK");
    }
}

//年会抽奖
class Main42 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            double result = fenZi(n) / fenMu(n);
            result *= 100;
            System.out.printf("%.2f%%\n", result);
        }
    }

    public static float fenMu(int n) {
        if (n == 1) {
            return 1;
        }
        return n * (fenMu(n - 1));
    }

    public static float fenZi(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return (n - 1) * (fenZi(n - 2) + fenZi(n - 1));
    }
}

//数字和为 sum 的方法数
class Main43 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int sum = sc.nextInt();
            int[] arr = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                arr[i] = sc.nextInt();
            }
            int[][] dp = new int[n + 1][sum + 1];
            for (int i = 0; i <= n; i++) {
                dp[i][0] = 1;
            }
            for (int j = 1; j <= sum; j++) {
                dp[0][j] = 0;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= sum; j++) {
                    /*
                    这里分两种情况：
                    1.第 i 个数大于 j，说明第i个数不可能包含在任意的方案中
                        这里很好理解，因为如果第 i 个数在一个方案中，那么这个方案的数字和
                        肯定大于 j 所以前 i 个数之和为 j 的方案数就等于前 i - 1 个数之和
                        为 j 的的方案数，即 dp[i][j] == dp[i - 1][j]
                    2.第 i 个数小于等于 j，此时所有的方案可以分成两部分
                        a）把第 i 个数不加入到方案:
                            则此时和为 j 共有 dp[i - 1][j] 种方案
                        b) 把第 i 个数加入到方案：
                            此时要求的和为 j 已经满足了 arr[i],只要在前 i - 1 个数中找到
                            和为 j - arr[i] 的方案数即可，即 dp[i - 1][j - arr[i]]
                        因此情况2共有 dp[i - 1][j] + dp[i - 1][j - arr[i]] 中方案
                    */
                    if (arr[i] <= j) {
                        dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i]];
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[n][sum]);
        }
    }
}

class Main45 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            for (int i = 0; i < str.length(); i++) {
                int count = 0;
                StringBuilder builder = new StringBuilder();
                char c = str.charAt(i);
                for (int j = 0; j < 7; j++) {
                    int and = ((c >> j) & 1);
                    builder.append(and);
                    if (and == 1) {
                        count++;
                    }
                }
                if (count % 2== 0) {
                    builder.append(1);
                } else {
                    builder.append(0);
                }
                System.out.println(builder.reverse().toString());
            }
        }
    }
}

//大整数排序
class Main46 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }
            for (int i = 0; i < arr.length - 1; i++) {
                boolean flag = true;
                for (int j = 0; j < arr.length - 1 - i; j++) {
                    compare(arr, j, j + 1);
                    flag = false;
                }
                if (flag) {
                    break;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.println(arr[i]);
            }
        }
    }
    public static void compare(String[] arr, int a, int b) {
        if (arr[a].length() > arr[b].length()) {
            swap(arr, a, b);
        } else if (arr[a].length() == arr[b].length()){
            for (int i = 0; i < arr[a].length(); i++) {
                if (arr[a].charAt(i) != arr[b].charAt(i)) {
                    if (arr[a].charAt(i) > arr[b].charAt(i)) {
                        swap(arr, a, b);
                    }
                    return;
                }
            }
        }

    }
    public static void swap(String[] arr, int a, int b) {
        String temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

//说反话
class Main47 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            char[] arr = str.toCharArray();
            int left = 0;
            int right = str.length() - 1;
            while (left < right) {
                char temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++;
                right--;
            }
            left = 0;
            right = 0;
            while (left < arr.length) {
                int index = 0;
                while (arr[right] != ' ') {
                    right++;
                    if (right == arr.length) {
                        break;
                    }
                }
                index = right;
                right--;
                while (left < right) {
                    char temp = arr[left];
                    arr[left] = arr[right];
                    arr[right] = temp;
                    right--;
                    left++;
                }
                left = index + 1;
                right = left;
            }
            System.out.println(arr);
        }
    }
}

//在霍格沃茨找零钱
class Main48 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] w = new int[]{17 * 29, 29, 1};
        while (sc.hasNext()) {
            String p = sc.next();
            String a = sc.next();
            String[] sp = p.split("\\.");
            String[] sa = a.split("\\.");

            int[] tp = new int[]{Integer.parseInt(sp[0]), Integer.parseInt(sp[1]), Integer.parseInt(sp[2])};
            int[] ta = new int[]{Integer.parseInt(sa[0]), Integer.parseInt(sa[1]), Integer.parseInt(sa[2])};

            int rp = tp[0] * w[0] + tp[1] * w[1] + tp[2] * w[2];
            int ra = ta[0] * w[0] + ta[1] * w[1] + ta[2] * w[2];

            int result = ra - rp;
            if (result < 0) {
                result = (-result);
                System.out.print("-");
            }
            System.out.println(result / w[0] + "." + result % w[0] / w[1] + "." + result % w[0] % w[1]);
        }
    }
}

//锤子剪刀布
class Main49 {

    static class Person {
        public int win;
        public int draw;
        public int lose;
        Map<String , Integer> map = new HashMap<>();

        public Person() {
            map.put("C", 0);
            map.put("J", 0);
            map.put("B", 0);
        }
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            Person jia = new Person();
            Person yi = new Person();
            for (int i = 0; i < n; i++) {
                String jiaRes = sc.next();
                String yiRes = sc.next();
                judge(jiaRes, yiRes, jia, yi);
            }
            System.out.println(jia.win + " " + jia.draw + " " + jia.lose);
            System.out.println(yi.win + " " + yi.draw + " " + yi.lose);

            System.out.print(advantage(jia.map) + " " + advantage(yi.map));
        }
    }

    private static void judge(String js, String ys, Person jia, Person yi) {
        if (js.equals("C")) {
            if (ys.equals("J")) {
                jia.win++;
                yi.lose++;
                jia.map.put(js, jia.map.get(js) + 1);
            } else if (ys.equals("C")) {
                jia.draw++;
                yi.draw++;
            } else {
                jia.lose++;
                yi.win++;
                yi.map.put(ys, yi.map.get(ys) + 1);
            }
        }
        if (js.equals("J")) {
            if (ys.equals("B")) {
                jia.win++;
                yi.lose++;
                jia.map.put(js, jia.map.get(js) + 1);
            } else if (ys.equals("J")) {
                jia.draw++;
                yi.draw++;
            } else {
                jia.lose++;
                yi.win++;
                yi.map.put(ys, yi.map.get(ys) + 1);
            }
        }
        if (js.equals("B")) {
            if (ys.equals("C")) {
                jia.win++;
                yi.lose++;
                jia.map.put(js, jia.map.get(js) + 1);
            } else if (ys.equals("B")) {
                jia.draw++;
                yi.draw++;
            } else {
                jia.lose++;
                yi.win++;
                yi.map.put(ys, yi.map.get(ys) + 1);
            }
        }
    }

    private static String advantage(Map<String, Integer> map) {
        if (map.get("B") == (map.get("C")) && map.get("B") >= map.get("J")) {
            return "B";
        }
        if (map.get("B") == map.get("J") && map.get("B") >= map.get("C")) {
            return "B";
        }
        if (map.get("C") == map.get("J") && map.get("C") >= map.get("B")) {
            return "C";
        }
        int max = 0;
        String ret = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() > max) {
                max = entry.getValue();
                ret = entry.getKey();
            }
        }
        return ret;

    }
}

//上楼梯
class GoUpstairs {

    public int countWays(int n) {
        // write code here
        long[] pre = {1, 2, 4};
        if(n<=0) return 0;
        else if(n<=3) return (int)pre[n-1];
        else{
            for(int i=4; i<=n; i++){
                long tmp = ((pre[0] + pre[1])%1000000007 +pre[2])%1000000007;
                pre[0] = pre[1];
                pre[1] = pre[2];
                pre[2] = tmp;
            }
        }
        return (int)pre[2];
    }
}

//broken keyboard
class Main50{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ideal = sc.next();
            String actual = sc.next();
            ideal = ideal.toUpperCase();
            actual = actual.toUpperCase();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < actual.length(); i++) {
                set.add(actual.charAt(i));
            }
            Set<Character> ret = new HashSet<>();
            for (int i = 0; i < ideal.length(); i++) {
                if (!set.contains(ideal.charAt(i))) {
                    if(!ret.contains(ideal.charAt(i))) {
                        ret.add(ideal.charAt(i));
                        System.out.print(ideal.charAt(i));
                    }
                }
            }

        }
    }
}

//球的半径和体积
class Main51 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int[] x = new int[3];
            int[] y = new int[3];
            for (int i = 0; i < 3; i++) {
                x[i] = sc.nextInt();
            }
            for (int i = 0; i < 3; i++) {
                y[i] = sc.nextInt();
            }
            double r = Math.sqrt((y[0] - x[0]) * (y[0] - x[0]) + (y[1] - x[1]) * (y[1] - x[1]) + (y[2] - x[2]) * (y[2] - x[2]));
            double v = (double) 4 / (double) 3 * Math.acos(-1) * Math.pow(r, 3);
            System.out.printf("%.3f %.3f", r, v);
        }
    }
}

//百万富翁问题
class Main52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long richer = 0;
        long stranger = 0;
        for (int i = 0; i < 30; i++) {
            richer += 10;
            stranger += Math.pow(2, i);
        }
        System.out.println(richer + " " + stranger);
    }
}

//中国牛市
class Solution5 {
    /**
     * 计算你能获得的最大收益
     *
     * @param prices Prices[i]即第i天的股价
     * @return 整型
     */
    //把股票买卖的最佳时机1问题分成两部分(0, i), (i + 1, prices.length - 1)
    public int calculateMax(int[] prices) {
        int n = prices.length;
        int max1 = 0;
        int max2 = 0;
        int MAX = 0;
        for (int i = 0; i < n; i++) {
            max1 = getMax(prices, 0, i);
            max2 = getMax(prices, i + 1, n - 1);
            if (max1 + max2 > MAX)  {
                MAX = max1 + max2;
            }
        }
        return MAX;
    }

    public int getMax(int[] prices, int left, int right) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int i = left; i <= right; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
        }
        return max;
    }
}

//字母统计
class Main53 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            Map<Character, Integer> map = new HashMap<>();
            String word = "QWERTYUIOPLKJHGFDSAZXCVBNM";
            for (int i = 0; i < word.length(); i++) {
                map.put(word.charAt(i), 0);
            }
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (c >= 'A' && c <= 'Z') {
                    map.put(c, map.get(c) + 1);
                }
            }
            List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());
            list.sort(new Comparator<Map.Entry<Character, Integer>>() {
                @Override
                public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                    return o1.getKey() - o2.getKey();
                }
            });
            for (Map.Entry entry : list) {
                System.out.println(entry.getKey() + ":" + entry.getValue());
            }
        }
    }
}

//进制转换
class Main54 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            String str = sc.next().substring(2);
            char[] arr = str.toCharArray();
            int decimal = 0;
            int index = 0;
            for (int i = arr.length - 1; i >= 0; i--) {
                if (arr[index] >= 'A' && arr[index] <= 'Z') {
                    decimal += (arr[index] - 55) * Math.pow(16, i);
                } else {
                    decimal += ((arr[index] - '0') * Math.pow(16, i));
                }
                index++;
            }
            System.out.println(decimal);
        }
    }
}

//木棒拼图
//        木棍集合中找出一根最长的，记为 max_len
//        除了这一根外，剩下的长度之和，记为 Len
//        则必须满足 Len > max_len 。
//        换言之， 设总长度为 Tlen，
//        则仅当 Tlen - max_len > max_len 时，才能组成面积大于0 的简单多边形
class Main55 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> ls= new ArrayList<>();
        for (int i=0;i<n;i++){
            int op = sc.nextInt();
            int length = sc.nextInt();
            if (op==1){
                ls.add(length);
            }else{
                int idx = ls.indexOf(length);
                ls.remove(idx);
            }
            if (ls.size() < 3){
                System.out.println("No");
            }else{
                Collections.sort(ls,Collections.reverseOrder());
                int max = ls.get(0);
                int sum = 0;
                for (int j=1;j<ls.size();j++){
                    sum += ls.get(j);
                }
                if(sum>max){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}

//最近公共组先

//利用这个关系，如果a ！= b，就让其中的较大数除以2， 如此循环知道a == b，
//即是原来两个数的最近公共祖先
class LCA {
    public int getLCA(int a, int b) {
        while (a != b) {
            if (a > b) {
                a /= 2;
            } else {
                b /= 2;
            }
        }
        return a;
    }
}

//空格替换
class Replacement {
    public String replaceSpace(String iniString, int length) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            if(iniString.charAt(i) != ' ') {
                builder.append(iniString.charAt(i));
            } else {
                builder.append("%20");
            }
        }
        return builder.toString();
    }
}

//二维数组打印
class Printer {
    public int[] arrayPrint(int[][] arr, int n) {
        int[] ret = new int[n * n];
        int index = 0;
        for (int col = n - 1; col >= 0; col--) {
            int i = 0;
            int j = col;
            while (i < n  && j < n) {
                ret[index++] = arr[i++][j++];
            }
        }
        for (int row = 1; row < n; row++) {
            int i = row;
            int j = 0;
            while (i < n  && j < n) {
                ret[index++] = arr[i++][j++];
            }
        }
        return ret;
    }
}

//回文串
class Main56 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.next();
            int left = 0;
            int right = str.length() - 1;
            int missCount = 0;
            while (left < right) {
                if (str.charAt(left) != str.charAt(right)) {
                    if (str.charAt(left) == str.charAt(right - 1)) {
                        right--;
                    } else {
                        left++;
                    }
                    missCount++;
                } else {
                    left++;
                    right--;
                }
            }
            if (missCount == 1) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}

//删除公共字符串
class Main57 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            StringBuilder builder = new StringBuilder();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str2.length(); i++) {
                set.add(str2.charAt(i));
            }
            for (int i = 0; i < str1.length(); i++) {
                if (!set.contains(str1.charAt(i))) {
                    builder.append(str1.charAt(i));
                }
            }
            System.out.print(builder.toString());
        }
    }
}

//句子逆序
class Main58 {
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder builder = new StringBuilder();
            String[] arr = str.split(" ");
            for (int i = 0; i < arr.length; i++) {
                arr[i] = builder.append(arr[i]).reverse().toString();
                builder.delete(0, builder.length());
            }
            for (int i = 0; i < arr.length; i++) {
                builder.append(arr[i]);
                if (i != arr.length - 1) {
                    builder.append(" ");
                }
            }
            System.out.print(builder.reverse().toString());
        }
    }
}

//最大连续和
class Main59 {
    //temp[i]表示前i个的最大连续和，如果temp[i - 1] <= 0,则前i个数的最大连续和就是temp[i],否则就是temp[i - 1] + temp[i]
    //max就是temp[i]中最大的一个
    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (temp <= 0) {
                    temp = arr[i];
                } else {
                    temp += arr[i];
                }
                if (temp > max) {
                    max = temp;
                }
            }
            System.out.println(max);
        }
    }
}

//坐标移动
class Main60 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int x = 0;
            int y = 0;
            String str = sc.nextLine();
            String[] arr = str.split(";");
            for (String s : arr) {
                if (judge(s)) {
                    int operateNum = Integer.parseInt(s.substring(1, s.length()));
                    if (s.charAt(0) == 'A') {
                        x -= operateNum;
                    }
                    if (s.charAt(0) == 'W') {
                        y += operateNum;
                    }
                    if (s.charAt(0) == 'S') {
                        y -= operateNum;
                    }
                    if (s.charAt(0) == 'D') {
                        x += operateNum;
                    }
                }
            }
            System.out.println(x + "," + y);
        }
    }
    public static boolean judge(String str) {
        if (str.length() > 3 || str.length() < 2) {
            return false;
        }
        if (str.charAt(0) != 'A' && str.charAt(0) != 'W' && str.charAt(0) != 'S' && str.charAt(0) != 'D') {
            return false;
        }
        if (str.length() == 3 && (str.charAt(1) <= '0' || str.charAt(1) > '9' || str.charAt(2) < '0' || str.charAt(2) > '9')) {
            return false;
        }
        if (str.length() == 2 && (str.charAt(1) < '0' || str.charAt(1) > '9')) {
            return false;
        }
        return true;
    }
}

//计算日期到天数转换
class Main61 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int year = sc.nextInt();
            int month = sc.nextInt();
            int day = sc.nextInt();
            int res = getDay(year, month, day);
            System.out.println(res);
        }
    }

    private static int getDay(int year, int month, int day) {
        int res = 0;
        int[] arr = new int[] {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0) {
            arr[1] = 29;
        }
        for (int i = 0; i < month - 1; i++) {
            res += arr[i];
        }
        res += day;
        if (res < 1 || res > 366) {
            return -1;
        }
        return res;
    }
}

//字符串加解密
class Main62 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str1 = sc.next();
            String str2 = sc.next();
            str1 = encrypt(str1);
            str2 = unEncrypt(str2);
            System.out.println(str1);
            System.out.println(str2);
        }
    }

    private static String encrypt(String str1) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str1.length(); i++) {
            char c = str1.charAt(i);
            if (c == 'Z') {
                builder.append('a');
            } else if (c == 'z') {
                builder.append('A');
            } else if (c == '9') {
                builder.append('0');
            } else if (c >= 'A' && c <= 'Y') {
                builder.append((char)(c + 33));
            } else if (c >= 'a' && c <= 'y') {
                builder.append((char)(c - 31));
            } else {
                builder.append((char)(c + 1));
            }
        }
        return builder.toString();
    }

    private static String unEncrypt(String str2) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str2.length(); i++) {
            char c = str2.charAt(i);
            if (c == 'A') {
                builder.append('z');
            } else if (c == 'a') {
                builder.append('Z');
            } else if (c == '0') {
                builder.append('9');
            } else if (c >= 'B' && c <= 'Z') {
                builder.append((char)(c + 31));
            } else if (c >= 'b' && c <= 'z') {
                builder.append((char)(c - 33));
            } else {
                builder.append((char)(c - 1));
            }
        }
        return builder.toString();
    }
}



