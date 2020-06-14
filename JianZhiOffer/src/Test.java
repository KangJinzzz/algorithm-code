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

