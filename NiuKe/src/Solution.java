import java.util.*;


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