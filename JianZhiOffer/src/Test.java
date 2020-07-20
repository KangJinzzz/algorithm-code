import java.beans.IntrospectionException;
import java.util.*;

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

    //面试题22: 链表中倒数第k个结点
    public ListNode FindKthToTail(ListNode head,int k) {
        int size = size(head);
        //边界一定要考虑清楚！！！
        if(head == null || k <= 0 || k > size) {
            return null;
        }
        for (int i = 0; i < size - k ; i++) {
            head = head.next;
        }
        return head;
    }
    public int size(ListNode head) {
        int size = 0;
        for (; head != null; head = head.next) {
            size++;
        }
        return size;
    }
}

// 23：链表中环的节点
    //用哈希表简单
class Solution23 {

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode meetNode = getMeetNode(head);
        if (meetNode == null) {
            return null;
        }

        ListNode node1 = head;

        while (node1 != meetNode) {
            node1 = node1.next;
            meetNode = meetNode.next;
        }
        return node1;
    }
    //找到相遇的节点
    private ListNode getMeetNode(ListNode pHead) {

        ListNode nodeSlow = pHead;
        ListNode nodeFast = nodeSlow;
        while (nodeFast != null && nodeFast.next != null) {
            nodeSlow = nodeSlow.next;
            nodeFast = nodeFast.next.next;
            if (nodeSlow == nodeFast) {
                return nodeFast;
            }
        }
        return null;
    }
}

// 24：反转链表
class Solution24 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode node1 = null;
        ListNode node2 = head;
        ListNode node3 = head.next;
        while (node3 != null) {
            node2.next = node1;
            node1 = node2;
            node2 = node3;
            node3 = node3.next;
        }
        node2.next = node1;
        return node2;
    }
}

//面试题25. 合并两个排序的链表
class Solution25 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                newTail.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                newTail.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            newTail = newTail.next;
        }
        if (l1 == null) {
            newTail.next = l2;
        } else {
            newTail.next = l1;
        }
        return newHead.next;
    }
}

//面试题26. 树的子结构
class Solution26 {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null || B == null) {
            return false;
        }
        boolean res = false;
        if (A.val == B.val) {
            res = helper(A, B);
        }
        if (!res) {
            res = isSubStructure(A.left, B);
        }
        if (!res) {
            res = isSubStructure(A.right, B);
        }
        return res;
    }
    public boolean helper(TreeNode A, TreeNode B) {
        if (B == null) {
            return true;
        }
        if (A == null || A.val != B.val) {
            return false;
        }
        return helper(A.left, B.left) && helper(A.right, B.right);
    }
}

//面试题27. 二叉树的镜像
class Solution27 {
    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right == null && root.left == null) {
            return root;
        }
        TreeNode temp = null;
        temp = root.left;
        root.left = root.right;
        root.right = temp;
        if (root.left != null) {
            mirrorTree(root.left);
        }
        if (root.right != null) {
            mirrorTree(root.right);
        }
        return root;
    }
}

//面试题28. 对称的二叉树
//  如果一个二叉树是对称的，那么这个二叉树左序遍历（中，左，右）的值与右序遍历（中，右，左）的值对应
class Solution28 {
    public boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    public boolean helper(TreeNode node1, TreeNode node2) {
        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 == null || node2 == null) {
            return false;
        }
        if (node1.val != node2.val) {
            return false;
        }
        return helper(node1.left, node2.right) && helper(node1.right, node2.left);
    }
}

//面试题29. 顺时针打印矩阵
class Solution29 {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        int left = 0;  //左边界
        int right = matrix[0].length - 1;   //右边界
        int top = 0;  //上边界
        int below = matrix.length - 1;  //下边界
        int index = 0;
        int[] ret = new int[(right + 1) * (below + 1)];
        while (true) {
            for (int i = left; i <= right; i++) {   //由左边界开始向右打印上边界，打印完后上边界收缩
                ret[index++] = matrix[top][i];
            }
            if (++top > below) break;
            for (int i = top; i <= below; i++) {    //由上边界开始向下打印右边界，打印完后右边界收缩
                ret[index++] = matrix[i][right];
            }
            if (--right < left) break;
            for (int i = right; i >= left; i--) {   //由右边界开始向左打印下边界，打印完后下边界收缩
                ret[index++] = matrix[below][i];
            }
            if (--below < top) break;
            for (int i = below; i >= top; i--) {    //由下边界开始向上打印左边界，打印完后左边界收缩
                ret[index++] = matrix[i][left];
            }
            if (++left > right) break;
        }
        return ret;
    }
}

//面试题30. 包含min函数的栈
class MinStack {

    /** initialize your data structure here. */
    Stack<Integer> A = new Stack<>();
    Stack<Integer> B = new Stack<>();   //辅助栈

    public MinStack() {

    }

    public void push(int x) {
        A.push(x);
        if (B.size() == 0 || x < B.peek()) {
            B.push(x);
        } else {
            B.push(B.peek());
        }
    }

    public void pop() {
        A.pop();
        B.pop();
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}

//面试题31. 栈的压入、弹出序列
//    算法流程：
//        初始化： 辅助栈 stackstack ，弹出序列的索引 ii ；
//        遍历压栈序列： 各元素记为 numnum ；
//        元素 numnum 入栈；
//        循环出栈：若 stackstack 的栈顶元素 == 弹出序列元素 popped[i]popped[i] ，则执行出栈与 i++i++ ；
//        返回值： 若 stackstack 为空，则此弹出序列合法。

class Solution31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.isEmpty() && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return stack.isEmpty();
    }
}

//面试题32 - I. 从上到下打印二叉树
class Solution32 {
    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<TreeNode> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.peek();
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            list.add(queue.poll());
        }
        int[] ret = new int[list.size()];
        int index = 0;
        for (TreeNode n : list) {
            ret[index++] = n.val;
        }
        return ret;
    }
}

//面试题32 - II. 从上到下打印二叉树 II
class Solution32_2 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> list = new ArrayList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            list.add(tmp);
        }
        return list;
    }
}

//面试题32 - III. 从上到下打印二叉树 III
class Solution32_3 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return res;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if (res.size() % 2 == 0) tmp.addLast(node.val);
                else tmp.addFirst(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(tmp);
        }
        return res;
    }
}

//面试题33. 二叉搜索树的后序遍历序列
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return helper(postorder, 0, postorder.length - 1);
    }
    public boolean helper(int[] arr, int i, int j) {
        if (i >= j) {
            return true;
        }
        int root = arr[j];
        int m = i;
        while (arr[m] < root) {
            m++;
        }
        int l = m;
        while (arr[m] > root) {
            m++;
        }
        return m == j && helper(arr, i, m - 1) && helper(arr, m, j);
    }
}

//面试题34. 二叉树中和为某一值的路径
class Solution34 {
    List<List<Integer>> solutions = new ArrayList<>();
    List<Integer> solution = new ArrayList<>();
    int curSum = 0;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        if (root == null) {
            return new ArrayList<>();
        }
        backTrack(root, sum);
        return solutions;
    }

    public void backTrack(TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        solution.add(root.val);
        curSum += root.val;
        if (curSum == sum && root.right == null && root.left == null) {
            List<Integer> tmp = new ArrayList<>(solution);
            solutions.add(tmp);
        }
        backTrack(root.left, sum);
        backTrack(root.right, sum);
        solution.remove(solution.size() - 1);
        curSum -= root.val;

    }
}

//面试题35. 复杂链表的复制
//方法一：
class Solution35 {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap();
        for (Node node = head; node != null; node = node.next) {
            map.put(node, new Node(node.val));
        }
        for (Node node = head; node != null; node = node.next) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);
    }
}
//方法二：
/**
 * 原链表：node1->node2->node3->....
 * 1.新链表：node1->copyNode1->node2->copyNode2->node3->copyNode3->...
 * 2.copyNodei.random = nodei.random.next;
 * 3.奇数位置是原链表,偶数位置是新链表
 */
class Solution35_2 {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        //步骤一：
        for (Node node = head; node != null; node = node.next.next) {
            Node newNode = new Node(node.val);
            newNode.next = node.next;
            node.next = newNode;
        }
        //步骤二：
        for (Node node = head; node != null; node = node.next.next) {
            if (node.random != null) {
                node.next.random = node.random.next;
            } else {
                node.next.random = null;
            }

        }
        //步骤三：
        Node newHead = head.next;
        Node node = newHead;
        while (head != null) {
            if (node.next == null) {
                head.next = null;
                break;
            } else {
                head.next = node.next;
                node.next = head.next.next;
                head = head.next;
                node = node.next;
            }
        }
        return newHead;
    }
}

//面试题36. 二叉搜索树与双向链表

//中序遍历的结果是从小到大，每次遍历都记录下前一个遍历的节点pre，只需将当前节点与pre连接即可
//class Solution36 {
//    Node pre = null;
//    Node head = null;
//    public Node treeToDoublyList(Node root) {
//        if (root == null) {
//            return null;
//        }
//        dfs(root);
//        head.left = pre;
//        pre.right = head;
//        return head;
//    }
//
//    public void dfs(Node cur) {
//        if (cur == null) {
//            return;
//        }
//        dfs(cur.left);
//        if (pre == null) {
//            head = cur;
//            pre = head;
//        } else {
//            cur.left = pre;
//            pre.right = cur;
//            pre = cur;
//        }
//        dfs(cur.right);
//    }
//}

//面试题37. 序列化二叉树
class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder("[");
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                builder.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            } else {
                builder.append("null,");
            }
        }
        builder.setCharAt(builder.length() - 1, ']');
        return builder.toString();
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data.equals("[]")) {
            return null;
        }
        data = data.substring(1, data.length() - 1);
        String[] vals = data.split(",");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        queue.offer(root);
        int index = 1;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (!vals[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(vals[index]));
                node.left = leftNode;
                queue.offer(leftNode);
            }
            index++;
            if (!vals[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(vals[index]));
                node.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }
        return root;
    }
}

//面试题38. 字符串的排列
class Solution38 {
    Set<String> set = new HashSet<>();
    public String[] permutation(String s) {
        if (s.length() == 0) {
            return new String[0];
        }
        char[] chars = s.toCharArray();
        dfs(chars, 0);
        String[] res = new String[set.size()];
        int i = 0;
        for (String str : set) {
            res[i++] = str;
        }
        return res;
    }

    private void dfs(char[] chars, int index) {
        if (index == chars.length - 1) {
            set.add(String.valueOf(chars));
            return;
        }

        for (int i = index; i < chars.length; i++) {
            swap(chars, index, i);
            dfs(chars, index + 1);
            swap(chars, i, index);
        }
    }

    private void swap(char[] chars, int a, int b) {
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}

//面试题39. 数组中出现次数超过一半的数字
class Solution39 {
    public int majorityElement(int[] nums) {

        int x = nums[0];
        int times = 0;
        for (int num : nums) {
            if (times == 0) {
                x = num;
                times++;
            } else {
                if (num == x) {
                    times++;
                } else {
                    times--;
                }
            }
        }
        return x;
    }
}

//面试题40. 最小的k个数
//方法一：快排思想
class Solution40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        int[] res = new int[k];
        int left = 0;
        int right = arr.length - 1;
        int index = partion(arr, left, right);

        while (index != k - 1) {
            if (index > k - 1) {
                right = index - 1;
                index = partion(arr, left, right);
            } else {
                left = index + 1;
                index = partion(arr, left, right);
            }
        }
        for (int i = 0; i <= k - 1; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    private int partion(int[] arr, int left, int right) {
        int i = left;
        int j = right;
        int n = arr[left];
        while (i < j) {
            while (i < j && arr[j] >= n) {
                j--;
            }
            while (i < j && arr[i] <= n) {
                i++;
            }
            swap(arr, i, j);
        }
        swap(arr, left, i);
        return j;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
//大堆
class Solution40_2 {

    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        int[] res = new int[k];
        Queue<Integer> heap = new PriorityQueue<>((n1, n2) -> (n2 - n1));
        for (int x : arr) {
            if (heap.size() < k) {
                heap.offer(x);
            } else {
                if (x < heap.peek()) {
                    heap.poll();
                    heap.offer(x);
                }
            }
        }
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll();
        }
        return res;
    }
}

//面试题41. 数据流中的中位数
class MedianFinder {

    //小堆，存储较大分元素，堆顶总是最小的元素
    Queue<Integer> A;
    //大堆，存储较小的元素，堆顶总是最大的元素
    Queue<Integer> B;
    /** initialize your data structure here. */
    public MedianFinder() {
        A = new PriorityQueue<>();
        B = new PriorityQueue<>((x, y) -> (y - x));
    }

    public void addNum(int num) {
        //N为奇数时，A存储（N + 1） / 2, N为偶数时，存储 N / 2;
        //A中的数量与B的数量不相等，说明此时A的数量比B大1，此时给B中加元素
        if (A.size() != B.size()) {
            A.offer(num);   //此时不知num的大小，因此先加到A中，再把A中最小的加到B中
            B.offer(A.poll());
        } else {
            B.offer(num);
            A.offer(B.poll());
        }
    }

    public double findMedian() {
        return A.size() == B.size() ? ((double)(A.peek() + B.peek()) / 2) : A.peek();
    }
}

//面试题42. 连续子数组的最大和
class Solution42 {
    /*
    状态：F(i)表示以nums[i]为结尾的最大连续和
    转移方程：F(i) = F(i - 1) > 0 ? F(i - 1) + nums[i] : nums[i];
    记录下每个F(i)，最大F(i)就位最终结果
    */
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}

//面试题43. 1～n整数中1出现的次数
class Solution43 {
    public int countDigitOne(int n) {

        return f(n);
    }
    private int f(int n ) {
        if (n <= 0) {
            return 0;
        }
        String str = String.valueOf(n);
        int high = str.charAt(0) - '0';
        int pow = (int) Math.pow(10, str.length() - 1);
        int low = n - high * pow;
        if (high == 1) {
            return f(pow - 1) + low + 1 + f(low);
        } else {
            return high * f(pow - 1) + pow + f(low);
        }
    }
}

//面试题44. 数字序列中某一位的数字
class Solution44 {
//    解题思路：
//    将 101112 \cdots101112⋯ 中的每一位称为 数位 ，记为 nn ；
//    将 10, 11, 12, \cdots10,11,12,⋯ 称为 数字 ，记为 numnum ；
//    数字 1010 是一个两位数，称此数字的 位数 为 22 ，记为 digitdigit ；
//    每 digitdigit 位数的起始数字（即：1, 10, 100, \cdots1,10,100,⋯），记为 startstart 。
//    可推出各 digitdigit 下的数位数量 count 的计算公式：
//    count=9×start×digit

    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        long num = start + (n - 1) / digit; // 2.
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }

}

//面试题45. 把数组排成最小的数
//把nums转成字符串数组strs
//将strs中的元素按从小到大排序
//比较“大小”的规则：这里的大小指的是 m 和 n 拼接后的小大
//比如：m：3  n：30  3 + 30 > 30 + 3, 因此 30 < 3
//这样排序后的strs拼接后就是我们要的最小的数
class Solution45 {

    public String minNumber(int[] nums) {
        String[] strs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs, 0, strs.length - 1);
        StringBuilder builder = new StringBuilder();
        for (String s : strs) {
            builder.append(s);
        }
        return builder.toString();
    }

    public void quickSort(String[] strs, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left;
        int j = right;
        while (i < j) {
            while (i < j && (strs[j] + strs[left]).compareTo(strs[left] + strs[j]) >= 0) {
                j--;
            }
            while (i < j && (strs[i] + strs[left]).compareTo(strs[left] + strs[i]) <= 0) {
                i++;
            }
            swap(strs, i, j);
        }
        swap(strs, i, left);
        quickSort(strs, left, i - 1);
        quickSort(strs, i + 1, right);
    }

    public void swap(String[] strs, int i, int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }
}

//面试题46. 把数字翻译成字符串

/**
 * 思路：动态规划
 * 状态：F(i)：前 i 个数字可翻译的数量
 * 转移方程：1) 当 第 i - 1 和第 i 个数字可翻译成一个字母时：
 *              F(i) = F(i - 2) + F(i - 1)
 *           2) 当 第 i - 1 和第 i 个数字不能翻译成一个字母时：
 *              F(i) = F(i - 1)
 * 初始化：F(0) = 1, F(1) = 1
 * 返回值：F(num.length)
 */

class Solution46 {
    public int translateNum(int num) {
        String str = String.valueOf(num);
        int f2 = 1;
        int f1 = 1;
        int fi = 1;
        for (int i = 1; i < str.length(); i++) {
            StringBuilder builder = new StringBuilder().append(str.charAt(i - 1)).append(str.charAt(i));
            int n = Integer.valueOf(builder.toString());
            if (n >= 10 && n <= 25) {
                fi = f2 + f1;
            } else {
                fi = f1;
            }
            f2 = f1;
            f1 = fi;

        }
        return fi;
    }
}

//面试题47. 礼物的最大价值

/**
 * 状态：F(i):从 (0, 0) 到 (i, j)拿到礼物的最大价值
 * 转移方程：F(i, j) = max(F(i - 1, j), F(i, j - 1)) + grid[i][j]
 */
class Solution47 {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] maxValue = new int[m][n];
        maxValue[0][0] = grid[0][0];
        //初始化
        for (int i = 1; i < m; i++) {
            maxValue[i][0] = maxValue[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            maxValue[0][j] = maxValue[0][j - 1] + grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                maxValue[i][j] = Math.max(maxValue[i - 1][j], maxValue[i][j - 1]) + grid[i][j];
            }
        }
        return maxValue[m - 1][n - 1];
    }
}

//面试题48. 最长不含重复字符的子字符串

/**
 * 用 i 标记 s[j] 左边距离 s[j] 最近的相同的字符
 * 状态：F(j):以 s[j] 结尾的最大不含重复字符的数量
 * 转移方程：1) 当 dp[j - 1] < j - i ，说明字符 s[i]在子字符串 dp[j-1]区间之外
 *                  ，则 dp[j] = dp[j - 1] + 1；
 *           2) 当 dp[j - 1] ≥ j − i ，说明字符 s[i]在子字符串 dp[j-1] 区间之中
 *                  ，则 dp[j]m的左边界由 s[i] 决定，即 dp[j] = j - i；
 */
class Solution48 {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int tmp = 0;
        int max = 0;
        for (int j = 0; j < s.length(); j++) {
            int i = map.getOrDefault(s.charAt(j), -1);
            if (j - i > tmp) {
                tmp += 1;
            } else {
                tmp = j - i;
            }
            map.put(s.charAt(j), j);
            if (tmp > max) {
                max = tmp;
            }
        }
        return max;
    }
}

//面试题49. 丑数

/**
 * 剑指offer解法：
 * 对于每一个丑数，都是之前某一个丑数 *2, *3 或 *5 得到的
 * 假设要求 第 i - 1 个丑数 ugly[i], 只要从前往后找到第一个 ugly[a] * 2 大于 ugly[i - 1]
 * 、ugly[b] * 3 大于 ugly[i - 1]、ugly[c] * 5 大于 ugly[i - 1] 的 三个数，则 ugly = min(ugly[a], ugly[b], ugly[c])
 */
class Solution49 {
    public int nthUglyNumber(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        int i = 1;
        while (i < n) {
            ugly[i] = Math.min(ugly[index2] * 2, Math.min(ugly[index3] * 3, ugly[index5] * 5));
            while (ugly[index2] * 2 <= ugly[i]) index2++;
            while (ugly[index3] * 3 <= ugly[i]) index3++;
            while (ugly[index5] * 5 <= ugly[i]) index5++;
            i++;
        }
        return ugly[i - 1];
    }
}

//面试题50. 第一个只出现一次的字符
class Solution50 {
    public char firstUniqChar(String s) {
        int[] times = new int[26];
        for (int i = 0; i < s.length(); i++) {
            times[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (times[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }
}

//面试题51. 数组中的逆序对
class Solution51 {
    int count = 0;
    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length);
        return count;
    }

    private void mergeSort(int[] nums, int left, int right) {
        if (left >= right - 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid);
        mergeSort(nums, mid, right);
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int[] arr = new int[right - left];
        int index = 0;
        int i = left;
        int j = right;
        int m = mid;
        while (i < mid && m < j) {
            if (nums[i] <= nums[m]) {
                arr[index++] = nums[i++];
            } else {
                arr[index++] = nums[m++];
                count += (mid - i);
            }
        }
        while (i < mid) {
            arr[index++] = nums[i++];
        }
        while (m < j) {
            arr[index++] = nums[m++];
        }
        for (int x : arr) {
            nums[left++] = x;
        }
    }
}

//面试题52. 两个链表的第一个公共节点
class Solution52 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A = headA;
        ListNode B = headB;
        while (A != B) {
            if (A == null) {
                A = headA;
            } else {
                A = A.next;
            }
            if (B == null) {
                B = headB;
            } else {
                B = B.next;
            }
        }
        return A;
    }
}

//面试题53 - I. 在排序数组中查找数字 I
class Solution53 {
    public static int search(int[] nums, int target) {
        if (nums == null || nums.length <= 0) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        int index = 0;
        //用二分查找找到target
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                break;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        //没找到，返回0
        if (left > right) return 0;
        left = index;
        right = index;
        //找nums中target的左右边界
        while (left >= 0 && nums[left] == target) {
            left--;
        }
        while (right <= nums.length - 1 && nums[right] == target) {
            right++;
        }
        return right - left - 1;
    }
    public static void main(String[] args) {
        int[] arr = new int[] {1};
        System.out.println(search(arr, 1));
    }
}

//面试题53 - II. 0～n-1中缺失的数字
class Solution53_2 {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }
}

//面试题54. 二叉搜索树的第k大节点
class Solution54 {
    int res;
    int K = 0;
    public int kthLargest(TreeNode root, int k) {
        if (root == null) {
            return -1;
        }
        inorder(root, k);
        return res;
    }

    public void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.right, k);
        if (++K == k) {
            res = root.val;
        }
        inorder(root.left, k);
    }
}

//面试题55 - I. 二叉树的深度
class Solution55 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

//面试题55 - II. 平衡二叉树
class Solution55_2 {
    public boolean isBalanced(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        }
        int leftDepth = maxDepth(root.left);
        int rightDepth = maxDepth(root.right);
        if (leftDepth - rightDepth > 1 || rightDepth - leftDepth > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);

    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

//面试题56 - I. 数组中数字出现的次数
class Solution56 {
    class Solution {
        public int[] singleNumbers(int[] nums) {
            int[] res = new int[2];
            int tmp = 0;
            for (int x : nums) {
                tmp ^= x;
            }
            int times = 0;
            for (int i = 0; i < 32; i++) {
                if (((tmp >> i) & 1) == 1) {
                    times = i;
                    break;
                }
            }
            for (int x : nums) {
                if (((x >> times) & 1) == 1) {
                    res[0] ^= x;
                } else {
                    res[1] ^= x;
                }
            }
            return res;
        }
    }
}

//面试题56 - II. 数组中数字出现的次数 II
//考虑数字的二进制形式，对于出现三次的数字，各 二进制位 出现的次数都是 33 的倍数。
//因此，统计所有数字的各二进制位中 11 的出现次数，并对 33 求余，结果则为只出现一次的数字。
class Solution56_2 {
    public int singleNumber(int[] nums) {
        int[] count = new int[32];
        for (int x : nums) {
            for (int i = 0; i < 32; i++) {
                if (((x >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }
        int res = 0;
        for (int i = 0; i < count.length; i++) {
            res += ((count[i] % 3) << i);
        }
        return res;
    }
}

//面试题57. 和为s的两个数字
class Solution57 {
    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            if (nums[left] + nums[right] == target) {
                break;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                left++;
            }
        }
        res[0] = nums[left];
        res[1] = nums[right];
        return res;
    }
}

//面试题57 - II. 和为s的连续正数序列
class Solution57_2 {
    public int[][] findContinuousSequence(int target) {
        List<int[]> res = new ArrayList<>();
        int small = 1;
        int big = 2;
        int sum = 3;
        while (big <= (target + 1) / 2) {
            if (sum < target) {
                big++;
                sum += big;
            } else if(sum > target) {
                sum -= small;
                small++;
            } else {
                int[] tmp = new int[big - small + 1];
                for (int i = 0; i < tmp.length; i++) {
                    tmp[i] = small + i;
                }
                res.add(tmp);
                big++;
                sum += big;
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

//面试题58 - I. 翻转单词顺序
//可以倒序遍历字符串的每个单词
class Solution58 {
    public String reverseWords(String s) {
        StringBuilder builder = new StringBuilder(s.trim());
        String str = builder.reverse().toString();
        String[] strs = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (String string : strs) {
            StringBuilder builder1 = new StringBuilder(string);
            if (!builder1.toString().equals("")) {
                res.append(builder1.reverse()).append(" ");
            }
        }
        return res.deleteCharAt(res.length() - 1).toString();
    }
}

//面试题58 - II. 左旋转字符串
class Solution58_2 {
    public String reverseLeftWords(String s, int n) {
        String str1 = s.substring(0, n);
        return s.substring(n, s.length()) + str1;
    }
}

//面试题59 - I. 滑动窗口的最大值
class Solution59 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0) {
            return new int[0];
        }
        int[] res = new int[nums.length - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < k; i++) {   //未形成窗口
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
        }
        res[0] = deque.peekFirst();
        for (int i = k; i < nums.length; i++) {   //形成窗口
            if (nums[i - k] == deque.peekFirst()) {
                deque.removeFirst();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[i]) {
                deque.removeLast();
            }
            deque.addLast(nums[i]);
            res[i - k + 1] = deque.peekFirst();
        }
        return res;
    }
}

//面试题59 - II. 队列的最大值
class MaxQueue {
    Queue<Integer> queue;
    Deque<Integer> deque;
    public MaxQueue() {
        queue = new LinkedList<>();
        deque = new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) {
            return -1;
        }
        return deque.peekFirst();
    }

    public void push_back(int value) {
        queue.offer(value);
        while (!deque.isEmpty() && deque.peekLast() < value) {
            deque.removeLast();
        }
        deque.addLast(value);
    }

    public int pop_front() {
        if (queue.isEmpty()) {
            return -1;
        }
        if (queue.peek().equals(deque.peekFirst())) {
            deque.removeFirst();
        }
        return queue.poll();
    }
}

//面试题60. n个骰子的点数

/**
 * 状态：F(i, j): 掷完第 i 个骰子点数为 j 的次数
 *
 *  单单看第 nn 枚骰子，它的点数可能为 1 , 2, 3, ... , 61,2,3,...,6 ，因此投掷完 nn 枚骰子后点数 jj 出现的次数，
 *  可以由投掷完 n-1n−1 枚骰子后，对应点数 j-1, j-2, j-3, ... , j-6j−1,j−2,j−3,...,j−6 出现的次数之和转化过来。
 * 转移方程：F(i, j) = F(i - 1, j - 1) + F(i - 1, j - 2) + F(i - 1, j - 3) + F(i - 1, j - 4)
 *                          + F(i - 1, j - 5) + F(i - 1, j - 6)
 * 返回值：F(n, j) / 6^n (j = n, n + 1, .... , n * 6);
 *      6^n 为可能出现的所有情况
 */
class Solution60 {
    public double[] twoSum(int n) {
        int[][] dp = new int[n + 1][6 * n + 1];
        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= 6 * n; j++) {
                if (j >= i && j <= 6 * i) {
                    for (int t = 1; t <= 6; t++) {
                        if (j - t >= i - 1)
                            dp[i][j] += dp[i - 1][j - t];
                    }
                }
            }
        }
        double[] res = new double[6 * n - n + 1];
        int index  =0;
        for (int j = n; j <= 6 * n; j++) {
            res[index++] = (double)dp[n][j] / Math.pow(6, n);
        }
        return res;
    }
}

//面试题61. 扑克牌中的顺子
class Solution61 {
    //用set，如果数组中有重复元素，返回false， 记录数组中的最大值与最小值（0除外），最大值 - 最小值 < 5 则可组成顺子
    public boolean isStraight(int[] nums) {
        int max = 0;
        int min = 14;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (x == 0) continue;
            max = Math.max(max, x);
            min = Math.min(min, x);
            if (set.contains(x)) return false;  //有重复元素，不可能为顺子
            set.add(x);
        }
        return max - min < 5;
    }
    //排序
    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int index = 0;  //用来保存第一个不是 0 的元素的下标
        for (int i = 0; i < 4; i++) {
            if (nums[i] == 0) {
                index++;
                continue;
            }
            if (nums[i] == nums[i + 1]) {
                return false;
            }

        }
        return nums[4] - nums[index] < 5;
    }
}

//面试题62. 圆圈中最后剩下的数字
//递推公式：f(n, m) = 1, n == 1
//                  = f((n - 1, m) + m) % n, n >= 1
class Solution62 {
    public int lastRemaining(int n, int m) {
        //F(1, 3) = 0;
        int pos = 0;
        for (int i = 2; i <= n; i++) {
            pos = (pos + m) % i;
        }
        return pos;
    }
}
//面试题63. 股票的最大利润

/**
 * 状态: F(i): 第 i 天可获得的最大利润（i = 0, 1, 2...)
 * 状态转移方程：F(i) = max(F(i - 1), prices[i] - minPrices)   minPrices:前 i 天之前最低的股票价
 *
 */
class Solution63 {
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int minValue = prices[0];
        int maxCost = 0;
        for (int i = 1; i < prices.length; i++) {
            maxCost = Math.max(maxCost, prices[i] - minValue);
            minValue = Math.min(minValue, prices[i]);
        }
        return maxCost;
    }
}


//剑指 Offer 64. 求1+2+…+n
class Solution64 {
    public int sumNums(int n) {

        boolean falg = (n >= 1 && (n += sumNums(n - 1)) < 0);
        return n;
    }
}

// 剑指 Offer 65. 不用加减乘除做加法
//A ^ B = A + B (但没有包括进位) 1 ^ 1 = 0, 1 ^ 0 = 1, 0 ^ 0, = 0
//A & B = A + B 各位的进位   1 & 1 = 1, 1 & 0 = 0, 0 & 0 = 0
class Solution65 {
    public int add(int a, int b) {
        int xor = 0;
        int and = 0;
        while (b != 0) {    //判断是否还有进位，有进位还需再次相加
            xor = a ^ b;    //存放各位相加的结果
            and = (a & b) << 1;     //存放各位相加后，上位的进位
            a = xor;    //继续计算 a + b
            b = and;
        }
        return a;
    }
}

//   剑指 Offer 66. 构建乘积数组
class Solution66 {
    public int[] constructArr(int[] a) {
        if (a == null || a.length == 0) {
            return new int[0];
        }
        int[] b = new int[a.length];
        b[0] = 1;
        int tmp  = 1;
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }
        for (int i = a.length - 2; i >= 0; i--) {
            tmp = tmp * a[i + 1];
            b[i] *= tmp;
        }
        return b;
    }
}

// 剑指 Offer 67. 把字符串转换成整数
class Solution67 {
    public int strToInt(String str) {
        char[] chars = str.trim().toCharArray();
        //正负号，默认为 +
        int sign = 1;
        int res = 0;
        int border = Integer.MAX_VALUE / 10;
        int i = 1;
        if (chars.length == 0) return 0;
        if (chars[0] == '-') {
            sign = -1;
        } else if (chars[0] != '+') {    //如果没进到这个条件中，说明没有符号，直接从下标0来开始判断
            i = 0;
        }
        for (; i < chars.length; i++) {
            //不是数字，直接退出循环
            if (chars[i] < '0' || chars[i] > '9') {
                break;
            }
            int x = chars[i] - '0';
            //在res更新前需要判断是否会越界，
            //res更新后再判断，这时如果已经越界会的到一个随机数，无法判断
            if (res > border || (res == border && x > 7)) {   //越界
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + x;
        }
        return  res * sign;
    }
}

//  剑指 Offer 68 - I. 二叉搜索树的最近公共祖先
/**
 * root是最近公共祖先的情况：
 * 1.因为是二叉搜索树，如果 p.val < root.val && q.val > root.val,说明p和q分别在root的两侧，root为最近公共祖先
 * 2.如果root是q或p中的一个，则root为最近公共祖先
 * root不是的情况：
 * 1.p和q在root的左侧
 * 2.p和q在root的右侧
 */
class Solution68_1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;
        //根节点是最近公共祖先的情况
        if (root.val == p.val || root.val == q.val || (p.val < root.val && q.val > root.val)
                || (q.val < root.val && p.val > root.val)) {
            return root;
        }
        //p,q在root的左侧
        if (p.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        //p，q在root的右侧
        return lowestCommonAncestor(root.right, p, q);
    }
}


//  剑指 Offer 68 - II. 二叉树的最近公共祖先
class Solution68_2 {
    TreeNode loc;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        findNode(root, p, q);
        return loc;
    }
    public boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        int left = findNode(root.left, p, q) ? 1 : 0;
        int right = findNode(root.right, p, q) ? 1 : 0;
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            loc = root;
        }
        return left + right + mid >= 1;
    }
}

//    剑指 Offer 55 - I. 二叉树的深度
class Solution55_3 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}

//    剑指 Offer 09. 用两个栈实现队列
class CQueue {
    //实现入队列的逻辑
    Stack<Integer> stack1 = new Stack<>();
    //实现出队列的逻辑
    Stack<Integer> stack2 = new Stack<>();
    public CQueue() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

//    剑指 Offer 12. 矩阵中的路径
class Solution12 {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] words, int i, int j, int index) {
        int row = board.length - 1;
        int col = board[0].length - 1;
        //说明已经找到了一条路径
        if (index >= words.length) {
            return true;
        }
        //越界，或当前位置已经访问过，返回false
        if (i < 0 || i > row || j < 0 || j > col) {
            return false;
        }
        //与当前字母不匹配或者当前位置被访问过，返回false
        if (board[i][j] != words[index]) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '/';
        //当前位置满足条件，向当前位置的上下左右继续搜索
        boolean res = dfs(board, words, i + 1, j, index + 1) || dfs(board, words, i - 1, j, index + 1)
                || dfs(board, words, i, j + 1, index + 1) || dfs(board, words, i, j - 1, index + 1);
        board[i][j] = tmp;
        return res;
    }
}

//    剑指 Offer 13. 机器人的运动范围
class Solution13 {
    int[][] position = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    int res = 0;
    public int movingCount(int m, int n, int k) {
        int[][] book = new int[m][n];
        dfs(book, m, n, 0, 0, k);
        return res;
    }

    public void dfs(int[][] book, int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || book[i][j] == 1)  {
            return;
        }
        if ((i % 10 + (i / 10 % 10) + j % 10 + (j / 10 % 10)) > k) {
            return;
        }
        res++;
        book[i][j] = 1;
        for (int x = 0; x < 4; x++) {
            dfs(book, m, n, i + position[x][0], j + position[x][1], k);
        }
    }
}

//    剑指 Offer 17. 打印从1到最大的n位数
class Solution17 {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 1; i <= end; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}

//    剑指 Offer 19. 正则表达式匹配

/**
 * 动态规划：
 * 状态：F(i, j):s前i个字符与p前j个字符是否匹配
 * 转移方程：1.当 p[j - 1] 是普通字符时：若 s[i - 1] = p[j - 1], F(i, j) = F(i - 1, j -1), 否则等于 false
 *           2.当 p[j - 1] 是 '.' 时：F(i, j) = F(i - 1, j - 1)
 *           3.当 p[j - 1] 是 '*' 时：a):当 p[j - 2] != s[i - 1],即 * == 0，F(i, j) = F(i, j - 2)
 *                                    b):当 p[j - 2] == s[i - 1],即 * > 0，F(i, j) = F(i - 1, j)
 * 初始化：看 s 的第一个字母与 p 的第一个字母是否可以匹配
 * 返回值：F(m, n)
 */
//class Solution19 {
//    public boolean isMatch(String s, String p) {
//        int m = s.length();
//        int n = p.length();
//        boolean[][] dp = new boolean[m + 1][n + 1];
//        //s 的前 0 个与 p 的前 0 个可以匹配，s 的前 i 个与 p 的前 0 个不可匹配，默认为false，不用初始化
//        dp[0][0] = true;
//        for (int i = 2; i <= n; i += 2) {
//            dp[0][i] = p.charAt(i - 2) == '*' && dp[0][i - 2];
//        }
//
//        for (int i = 1; i <= m; i++) {
//            for (int j = 1; j <= n; j++) {
//                if (p.charAt(j - 1) != '*') {
//                    if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {     //情况一和二合并
//                        dp[i][j] = dp[i - 1][j - 1];
//                    }
//                } else {
//                    dp[i][j]=dp[i][j-2]||
//                            (dp[i - 1][j]&&(s.charAt(i - 1) == p.charAt(j - 2) || s.charAt(j - 2) == '.'));
//
//
//                }
//            }
//        }
//        return dp[m][n];
//    }
//}

//剑指 Offer 20. 表示数值的字符串
class Solution20 {
    public boolean isNumber(String s) {
        char[] str = s.trim().toCharArray();
        boolean numseen = false;
        boolean dotseen = false;
        boolean eseen = false;

        for (int i = 0; i < str.length; i++) {
            // '-'和'+'只能出现在开头或 e/E 之后
            if (str[i] == '-' || str[i] == '+') {
                if (i != 0 && str[i - 1] != 'e'  && str[i - 1] != 'E') {
                    return false;
                }
            } else if (str[i] >= '0' && str[i] <= '9') {
                numseen = true;
            } else if (str[i] == '.') {
                // '.' 之前不能出现 '.'
                if (dotseen || eseen) {
                    return false;
                }
                dotseen = true;
            } else if (str[i] == 'e' || str[i] == 'E') {
                //‘e’ 之前不能出现 e 并且 e之前必须是数字
                if (eseen || !numseen) {
                    return false;
                }
                eseen = true;
                //最后一个字符必须是数字或'.',其他情况必须把 numseen 置为 false
                numseen = false;
            } else {
                return false;
            }
        }
        return numseen;
    }
}

//剑指 Offer 03. 数组中重复的数字
class Solution03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                return x;
            }
            set.add(x);
        }
        return -1;
    }
}

//剑指 Offer 04. 二维数组中的查找
class Solution04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix.length == 0) {
            return false;
        }
        int i = 0;
        int j = matrix[0].length - 1;
        while (i <= matrix.length - 1 && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }
}

//剑指 Offer 05. 替换空格
class Solution05 {
    public String replaceSpace(String s) {
//        int num = 0;
//        for (int i = 0; i < s.length(); i++) {
//            if (s.charAt(i) == ' ') {
//                num++;
//            }
//        }
//        char[] chars = new char[s.length() + 2 * num];
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}

//剑指 Offer 06. 从尾到头打印链表
class Solution06 {
    public int[] reversePrint(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        for (ListNode node = head; node != null; node = node.next) {
            stack.push(node.val);
        }
        int[] res = new int[stack.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = stack.pop();
        }
        return res;
    }
}

//剑指 Offer 07. 重建二叉树
class Solution07 {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0 || inorder.length == 0) {
            return null;
        }
        TreeNode head = null;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int iLeft, int iRight) {
        if (index >= preorder.length || iLeft >= iRight) {
            return null;
        }
        int inorderIndex = getInorderIndex(inorder, preorder[index]);
        TreeNode head = new TreeNode(preorder[index++]);
        head.left = buildTreeHelper(preorder, inorder, iLeft, inorderIndex);
        head.right = buildTreeHelper(preorder, inorder, inorderIndex + 1, iRight);
        return head;
    }
    public int getInorderIndex(int[] inorder, int a) {
        int ret = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == a) {
                ret = i;
            }
        }
        return ret;
    }
}

//    剑指 Offer 09. 用两个栈实现队列
class CQueue109 {

    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    public CQueue109() {

    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack1.isEmpty() && stack2.isEmpty()) {
            return -1;
        }
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}

//    剑指 Offer 10- I. 斐波那契数列
class Solution110 {
    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i = 3; i <= n; i++) {
            c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        return c;
    }
}

//剑指 Offer 10- II. 青蛙跳台阶问题
class Solution110_2 {
    public int numWays(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int n2 = 1;
        int n1 = 1;
        int sum = 0;
        for (int i = 2; i <= n; i++) {
            sum = (n1 + n2) % 1000000007;
            n2 = n1;
            n1 = sum;
        }
        return sum;
    }
}

//剑指 Offer 11. 旋转数组的最小数字
class Solution111 {
    public int minArray(int[] numbers) {
        int i = 0;
        int j = numbers.length - 1;
        int mid = 0;
        while (i < j) {
            mid = (i + j) / 2;
            if (numbers[mid] < numbers[j]) {
                j = mid;
            } else if (numbers[mid] > numbers[j]) {
                i = mid + 1;
            } else {
                j--;
            }
        }
        return numbers[i];
    }
}

//剑指 Offer 12. 矩阵中的路径
class Solution112 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int i, int j, int k) {
        if (k >= word.length()) {
            return true;
        }
        //判断越界
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        if (board[i][j] != word.charAt(k) || board[i][j] == '*') {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '*';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1)
                || dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }
}

//    剑指 Offer 13. 机器人的运动范围
class Solution113 {
    int res = 0;
    int[][] position = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int movingCount(int m, int n, int k) {
        if (k == 0) {
            return 1;
        }
        int[][] book = new int[m][n];
        dfs(book, m, n, 0, 0, k);
        return res;
    }

    public void dfs(int[][] book, int m, int n, int i, int j, int k) {
        if (i < 0 || i >= m || j < 0 || j >= n || book[i][j] == 1) {
            return;
        }
        if (i % 10 + ((i / 10) % 10) + j % 10 + ((j / 10) % 10) > k) {
            return;
        }
        res++;
        book[i][j] = 1;
        for (int x = 0; x < 4; x++) {
            dfs(book, m, n, i + position[x][0], j + position[x][1], k);
        }
    }
}

//    剑指 Offer 14- I. 剪绳子
class Solution114 {
    //动态规划：f（n）:长度为 n 的绳子的最大长度
    //f(i) = max(f(i) * f(n - i))
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (dp[j] * dp[i - j] > dp[i]) {
                    dp[i] = dp[j] * dp[i - j];
                }
            }
        }
        return dp[n];
    }
}

//剑指 Offer 15. 二进制中1的个数
class Solution115 {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        if (n == 0) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                res++;
            }
        }
        return res;
    }
}

//剑指 Offer 16. 数值的整数次方

class Solution116 {
    public double myPow(double x, int n) {
        double res = 1;
        long b = n;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res *= x;
            }
            x *= x;
            b >>= 1;
        }
        return res;
    }
}

//剑指 Offer 17. 打印从1到最大的n位数
class Solution117 {
    public int[] printNumbers(int n) {
        int end = (int)Math.pow(10, n) - 1;
        int[] res = new int[end];
        for (int i = 1; i <= end ; i++) {
            res[i - 1] = i;
        }
        return res;
    }
}

//剑指 Offer 18. 删除链表的节点
class Solution118 {
    public ListNode deleteNode(ListNode head, int val) {
        if(head == null) {
            return null;
        }
        if (head.val == val) {
            return head.next;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.val == val) {
                prev.next = cur.next;
                return head;
            }
            prev = prev.next;
            cur = cur.next;
        }
        return head;
    }
}