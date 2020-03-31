import java.util.*;

//day_17 火车进站
//day_16 洗牌
//day_19 子串判断
//day_25 人民币转换



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





