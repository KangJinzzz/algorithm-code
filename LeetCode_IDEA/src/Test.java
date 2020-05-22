import javax.naming.InsufficientResourcesException;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String str = "abbAbccdddddghjzZ";
        print(str);

    }

    //给你一个有效的 IPv4 地址 address，返回这个 IP 地址的无效化版本。
    //所谓无效化 IP 地址，其实就是用 "[.]" 代替了每个 "."。
    //示例 1：
    //输入：address = "1.1.1.1"
    //输出："1[.]1[.]1[.]1"
    public static String defangIPaddr(String address) {
        //return address.replace(".", "[.]");
        String s;
        StringBuilder bulider = new StringBuilder();
        for (int i = 0; i < address.length(); i++) {
            if (address.charAt(i) == '.') {
                bulider.append("[.]");
            } else {
                bulider.append(address.charAt(i));
            }
        }
        s = bulider.toString();
        return s;
    }

    //    给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
//    水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
//    反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
//    示例 1:
//    输入: [[1,1,0],[1,0,1],[0,0,0]]
//    输出: [[1,0,0],[0,1,0],[1,1,1]]
//    解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
//    然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]
    public int[][] flipAndInvertImage(int[][] A) {
        int Col = A[0].length;
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < (Col + 1) / 2; j++) {
                A[i][j] ^= 1;
                if (j != (Col - 1 - j)) {
                    A[i][Col - j - 1] ^= 1;
                }
                int t = A[i][j];
                A[i][j] = A[i][Col - j - 1];
                A[i][Col - j - 1] = t;
            }
        }
        return A;
    }

    //    203.删除链表中等于给定值 val 的所有节点。
//    示例:
//    输入: 1->2->6->3->4->5->6, val = 6
//    输出: 1->2->3->4->5
    public ListNode removeElements(ListNode head, int val) {
        //链表为空时
        if (head == null) {
            return null;
        }
        //链表不为空，最后处理头结点
        ListNode prev = head;
        ListNode node = head.next;
        while (node != null) {
            if (node.val == val) {
                prev.next = node.next;
                node = prev.next;
            } else {
                prev = node;
                node = prev.next;
            }
        }
        if (head.val == val) {
            head = head.next;
        }
        return head;
    }

    //    206.反转一个单链表。
//    示例:
//    输入: 1->2->3->4->5->NULL
//    输出: 5->4->3->2->1->NULL
//    进阶:
//    你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode node = head;
        ListNode next = head.next;
        while (next != null) {
            node.next = prev;
            prev = node;
            node = next;
            next = next.next;
        }
        node.next = prev;
        return node;
    }

    //    876.给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//    如果有两个中间结点，则返回第二个中间结点。
//    示例 1：
//    输入：[1,2,3,4,5]
//    输出：此列表中的结点 3 (序列化形式：[3,4,5])
//    返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//    注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//    ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = fast;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //输入一个链表，输出该链表中倒数第k个结点。
    public ListNode FindKthToTail(ListNode head, int k) {
        int len = size(head);
        if (k <= 0 || k > len || head == null) {
            return null;
        }
        ListNode node = head;
        for (int i = 0; i < len - k; i++) {
            node = node.next;
        }
        return node;
    }

    public int size(ListNode head) {
        int sz = 0;
        ListNode node = head;
        while (node != null) {
            sz++;
            node = node.next;
        }
        return sz;
    }

    //    21.将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//    示例：
//    输入：1->2->4, 1->3->4
//    输出：1->1->2->3->4->4

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        if (l1 == null) {
            tail.next = l2;
            return head.next;
        }
        tail.next = l1;
        return head.next;
    }

    //    编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在大于或等于x的结点之前
    //    给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。注意：分割以后保持原来的数据顺序不变
    public ListNode partition(ListNode pHead, int x) {
        //链表为空
        if (pHead == null) {
            return null;
        }
        //只有一个结点
        if (pHead.next == null) {
            return pHead;
        }
        //链表有多个结点
        //创建两个新链表，一个存储比x大的，一个存比x小的
        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;
        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;
        while (pHead != null) {
            ListNode node = new ListNode(pHead.val);
            if (pHead.val < x) {
                smallTail.next = node;
                smallTail = smallTail.next;
            } else {
                bigTail.next = node;
                bigTail = bigTail.next;
            }
            pHead = pHead.next;
        }
        //连接两个链表
        smallTail.next = bigHead.next;
        return smallHead.next;
    }

    //    在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
//    例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null) {
            return null;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        ListNode cur = pHead;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }
                cur = cur.next;
            } else {
                newTail.next = new ListNode(cur.val);
                newTail = newTail.next;
                cur = cur.next;
            }
        }
        return newHead.next;
    }


    //    对于一个链表，请设计一个时间复杂度为O(n),额外空间复杂度为O(1)的算法，判断其是否为回文结构。
//
//    测试样例：
//            1->2->2->1
//    返回：true
    public boolean chkPalindrome(ListNode A) {
        if (A == null) {
            return true;
        }
        ListNode fast = A;
        ListNode slow = A;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode B = slow;
        ListNode prev = null;
        ListNode next = B.next;
        while (next != null) {
            B.next = prev;
            prev = B;
            B = next;
            next = next.next;
        }
        B.next = prev;
        while (B != null && A != null) {
            if (A.val != B.val) {
                return false;
            }
            A = A.next;
            B = B.next;
        }
        return true;
    }

    //    编写一个程序，找到两个单链表相交的起始节点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = size(headA);
        int lenB = size(headB);
        int steps = lenA - lenB;
        if (steps > 0) {
            while (steps > 0) {
                headA = headA.next;
                steps--;
            }
        } else {
            while (steps < 0) {
                headB = headB.next;
                steps++;
            }
        }
        while (headA != null && headB != null) {
            if (headA == headB) {
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    //    小A 和 小B 在玩猜数字。小B 每次从 1, 2, 3 中随机选择一个，小A 每次也从 1, 2, 3 中选择一个猜。他们一共进行三次这个游戏，请返回 小A 猜对了几次？
//    输入的guess数组为 小A 每次的猜测，answer数组为 小B 每次的选择。guess和answer的长度都等于3。
//    示例 1：
//    输入：guess = [1,2,3], answer = [1,2,3]
//    输出：3
//    解释：小A 每次都猜对了。
    public int game(int[] guess, int[] answer) {
        int count = 0;
        for (int i = 0; i < 3; i++) {
            if (guess[i] == answer[i]) {
                count++;
            }
        }
        return count;
    }

    //    两个整数之间的汉明距离指的是这两个数字对应二进制位不同的位置的数目。
//    给出两个整数 x 和 y，计算它们之间的汉明距离。
//    注意：
//            0 ≤ x, y < 231.
//    示例:
//    输入: x = 1, y = 4
//    输出: 2
//    解释:
//            1   (0 0 0 1)
//            4   (0 1 0 0)
//            ↑   ↑
//    上面的箭头指出了对应二进制位不同的位置。
    public int hammingDistance(int x, int y) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if (((x >> i) & 1) != ((y >> i) & 1)) {
                count++;
            }
        }
        return count;
    }

    //    在二维平面上，有一个机器人从原点 (0, 0) 开始。给出它的移动顺序，判断这个机器人在完成移动后是否在 (0, 0) 处结束。
//    移动顺序由字符串表示。字符 move[i] 表示其第 i 次移动。机器人的有效动作有 R（右），L（左），U（上）和 D（下）。如果机器人在完成所有动作后返回原点，
//    则返回 true。否则，返回 false。
//    注意：机器人“面朝”的方向无关紧要。 “R” 将始终使机器人向右移动一次，“L” 将始终向左移动等。此外，假设每次移动机器人的移动幅度相同。
//    示例 1:
//    输入: "UD"
//    输出: true
//    解释：机器人向上移动一次，然后向下移动一次。所有动作都具有相同的幅度，因此它最终回到它开始的原点。因此，我们返回 true。
    public boolean judgeCircle(String moves) {
        int row = 0;
        int col = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'R') {
                row++;
            }
            if (moves.charAt(i) == 'L') {
                row--;
            }
            if (moves.charAt(i) == 'U') {
                col++;
            }
            if (moves.charAt(i) == 'D') {
                col--;
            }
        }
        if (row == 0 && col == 0) {
            return true;
        }
        return false;
    }

    //    学校在拍年度纪念照时，一般要求学生按照 非递减 的高度顺序排列。
//    请你返回至少有多少个学生没有站在正确位置数量。该人数指的是：能让所有学生以 非递减 高度排列的必要移动人数。
//    示例：
//    输入：[1,1,4,2,1,3]
//    输出：3
//    解释：
//    高度为 4、3 和最后一个 1 的学生，没有站在正确的位置。
//    提示：
//            1 <= heights.length <= 100
//            1 <= heights[i] <= 100
    public int heightChecker(int[] heights) {
        int[] arr = new int[101];
        int count = 0;
        for (int i = 0; i < heights.length; i++) {
            arr[heights[i]]++;
        }

        for (int i = 1, j = 0; i <= 100; i++) {
            while (arr[i]-- > 0) {
                if (i != heights[j++]) {
                    count++;
                }
            }
        }
        return count;
    }

    //    给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
//    示例 1：
//    输入：[-4,-1,0,3,10]
//    输出：[0,1,9,16,100]
    public int[] sortedSquares(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int index = right;
        int[] arr = new int[A.length];
        while (left <= right) {
            if (A[left] * A[left] > A[right] * A[right]) {
                arr[index--] = A[left] * A[left];
                left++;
            } else {
                arr[index--] = A[right] * A[right];
                right--;
            }
        }
        return arr;
    }

    //    给定一个链表，判断链表中是否有环。
//    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//    示例 1：
//    输入：head = [3,2,0,-4], pos = 1
//    输出：true
//    解释：链表中有一个环，其尾部连接到第二个节点。
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    //    给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
//    为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//    说明：不允许修改给定的链表。
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        ListNode cur = fast;
        while (cur != head) {
            cur = cur.next;
            head = head.next;
        }
        return cur;
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode newHead = new ListNode(-1);
        ListNode newTail = newHead;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                newTail.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                newTail.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            newTail = newTail.next;
        }
        if (list1 == null) {
            newTail.next = list2;
        } else {
            newTail.next = list1;
        }
        return newHead.next;
    }

    public static void print(String str) {
        StringBuilder stringBuilder = new StringBuilder();

        char[] arr = str.toCharArray();
        int[] flag = new int[101];
        for (int i = 0; i < arr.length; i++) {
            flag[arr[i] - 'A'] = 1;
        }
        for (int i = 0; i < arr.length; i++) {

            if (flag[arr[i] - 'A'] == 1) {
                stringBuilder = stringBuilder.append(arr[i]);
                flag[arr[i] - 'A'] = 0;
            }
        }
        str = stringBuilder.toString();
        System.out.println(str);
    }

    //    20.给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
//    有效字符串需满足：
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    注意空字符串可被认为是有效字符串。
    public boolean isValid(String s) {
        if (s == null) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.isEmpty()) {
                return false;
            }
            if ((s.charAt(i) == '}' && stack.peek() == '{')
                    || (s.charAt(i) == ']' && stack.peek() == '[')
                    || (s.charAt(i) == ')' && stack.peek() == '(')) {
                stack.pop();
                continue;
            }
            return false;
        }
        return stack.isEmpty();
    }

    //给定一个二叉树，返回它的 前序 遍历。
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.add(root.val);
        list.addAll(preorderTraversal(root.left));
        list.addAll(preorderTraversal(root.right));
        return list;
    }

    //二叉树后序遍历
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        list.addAll(postorderTraversal(root.left));

        list.addAll(postorderTraversal(root.right));
        list.add(root.val);

        return list;
    }

    //    100.给定两个二叉树，编写一个函数来检验它们是否相同。
//    如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //两个都为空返回true
        if (q == null && p == null) {
            return true;
        }
        //一个为空一个不为空，返回false
        if (p == null || q == null) {
            return false;
        }
        //两个节点值不同返回false；
        if (p.val != q.val) {
            return false;
        }

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

    }

    //    572.给定两个非空二叉树 s 和 t，检验 s 中是否包含和 t 具有相同结构和节点值的子树。s 的一个子树包括 s 的一个节
//    点和这个节点的所有子孙。s 也可以看做它自身的一棵子树。
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // 1. 如果两个树都是空树, 直接是 true
        if (s == null && t == null) {
            return true;
        }
        // 2. 如果两个树一个是空, 一个不是空, 暂且算作不包含. false
        if (s == null || t == null) {
            return false;
        }
        // 3. 如果两个数都非空
        //  a) 比较根节点的值是不是相等, 如果相等的话,
        //     比较一下 s 和 t 是不是相同的树, 如果是相同的树 就认为是包含的.
        boolean ret = false;
        if (s.val == t.val) {
            ret = isSameTree(s, t);
        }
        //  b) 递归的判定一下, t 是否被 s 的左子树包含
        if (!ret) {
            ret = isSubtree(s.left, t);
        }
        //  c) 递归的判定一下, t 是否被 s 的右子树包含
        if (!ret) {
            ret = isSubtree(s.right, t);
        }
        return ret;
    }

    //    给定一个二叉树，找出其最大深度。
//    二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int leftDep = maxDepth(root.left);
        int rightDep = maxDepth(root.right);
        //最大深度为当前节点（1）+ 左右子树的最大深度
        return 1 + (leftDep > rightDep ? leftDep : rightDep);
    }

    //  110. 给定一个二叉树，判断它是否是高度平衡的二叉树。
//    本题中，一棵高度平衡二叉树定义为：
//    一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.right == null && root.left == null) {
            return true;
        }
        int rightDep = maxDepth(root.right);
        int leftDep = maxDepth(root.left);
        if ((rightDep - leftDep > 1) || (leftDep - rightDep > 1)) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    //  101.  给定一个二叉树，检查它是否是镜像对称的。
//    例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    public boolean isMirror(TreeNode t1, TreeNode t2) {
        // 1. 如果两个树都是空树, 应算镜像
        if (t1 == null && t2 == null) {
            return true;
        }
        // 2. 如果两个树一个空一个非空, 就不算镜像
        if (t1 == null || t2 == null) {
            return false;
        }
        // 3. 如果两个树都不为空
        //  a) 比较根节点是不是相同, 不相同就不是镜像
        if (t1.val != t2.val) {
            return false;
        }
        //  b) 递归比较子树, t1.left 和 t2.right ,
        //     t1.right 和 t2.left 是不是镜像
        return isMirror(t1.left, t2.right)
                && isMirror(t1.right, t2.left);
    }

    //102. 二叉树的层次遍历
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return result;
        }
        helper(root, 0);
        return result;
    }

    private void helper(TreeNode root, int level) {
        //level == result.size()说明是第一次来到这一层，需要先创建顺序表
        if (level == result.size()) {
            result.add(new ArrayList<>());
        }
        result.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }

    //236. 二叉树的最近公共祖先
    private TreeNode lca = null;  // 保存最终的公共祖先节点

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 1. 借助一个辅助函数, 在 root 中递归查找 p 和 q.
        //    设定辅助函数的返回值, 如果找到返回 1(找到一个或者两个都算), 没找到 返回 0
        // 2. 这个递归查找的过程进一步拆解开. 递归在左子树中查找 + 递归在右子树中查找 + 对比根节点
        // 3. 如果这三个位置中, 有两个地方找到了, 这个当前节点就是要找的最近公共祖先
        if (root == null) {
            return null;
        }
        // 辅助函数
        findNode(root, p, q);
        return lca;
    }

    private boolean findNode(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        // 递归在左子树中尝试找 p 或者 q
        int left = findNode(root.left, p, q) ? 1 : 0;
        // 递归在右子树中尝试查找 p 或者 q
        int right = findNode(root.right, p, q) ? 1 : 0;
        // 对比一下当前节点有没有找到
        int mid = (root == p || root == q) ? 1 : 0;
        if (left + right + mid >= 2) {
            // 找到 lca, 就是当前的 root
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    //105. 从前序与中序遍历序列构造二叉树
    private int index = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return buildTreeHelper(preorder, inorder, 0, inorder.length);
    }

    public TreeNode buildTreeHelper(int[] preorder, int[] inorder, int inorderLeft, int inorderRight) {
        if (inorderLeft >= inorderRight) {
            return null;
        }
        if (index >= inorder.length) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[index]);
        index++;
        int pos = find(inorder, inorderLeft, inorderRight, root.val);
        root.left = buildTreeHelper(preorder, inorder, inorderLeft, pos);
        root.right = buildTreeHelper(preorder, inorder, pos + 1, inorderRight);
        return root;

    }

    public int find(int[] inorder, int inorderLeft, int inorderRight, int val) {
        for (int i = inorderLeft; i < inorderRight; i++) {
            if (inorder[i] == val) {
                return i;
            }
        }
        return -1;
    }

    //106. 从中序与后序遍历序列构造二叉树
    public TreeNode postBuildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0) {
            return null;
        }
        return postBuildTreeHelper(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);

    }

    public TreeNode postBuildTreeHelper(int[] inorder, int inorderL, int inorderR, int[] postorder, int postorderL, int postorderR) {
        if (inorderL > inorderR || postorderL > postorderR) {
            return null;
        }

        int index = inorderL;
        while (inorder[index] != postorder[postorderR]) {
            index++;
        }
        TreeNode root = new TreeNode(postorder[postorderR]);
        root.left = postBuildTreeHelper(inorder, inorderL, index - 1, postorder,
                postorderL, postorderR - inorderR + index - 1);
        root.right = postBuildTreeHelper(inorder, index + 1, inorderR,
                postorder, postorderR - inorderR + index, postorderR - 1);
        return root;
    }

    //606. 根据二叉树创建字符串
    StringBuilder stringBuilder = new StringBuilder();

    public String tree2str(TreeNode t) {
        if (t == null) {
            return "";
        }
        tree2strHelper(t);
        stringBuilder.deleteCharAt(0);
        stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        return stringBuilder.toString();
    }

    public void tree2strHelper(TreeNode t) {
        if (t == null) {
            return;
        }
        stringBuilder.append("(");
        stringBuilder.append(t.val);
        tree2strHelper(t.left);
        if (t.left == null && t.right != null) {
            stringBuilder.append("()");
        }
        tree2strHelper(t.right);
        stringBuilder.append(")");
    }

    //144. 二叉树的前序遍历
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //创建一个栈辅助
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        //根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            //访问栈顶元素
            TreeNode cur = stack.pop();
            list.add(cur.val);
            //左节点不为空入栈
            if (cur.right != null) {
                stack.push(cur.right);
            }
            //右节点不为空入栈
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
        return list;
    }

    //144. 二叉树的中序遍历
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        //创建一个辅助栈
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return list;
        }
        TreeNode cur = root;
        while (true) {
            // 只要 cur 遇到的节点非 null, 就入栈, cur = cur.left
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //当 cur 遇到 null 的, 就出栈一个元素, 访问这个元素
            if (stack.isEmpty()) {
                // 遍历结束了
                break;
            }
            //访问栈顶元素
            TreeNode top = stack.pop();
            list.add(top.val);
            // cur 指向当前元素的右子树
            cur = top.right;
        }
        return list;
    }

    //144. 二叉树的后序遍历
    public List<Integer> postorderTraversal2(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        //创建一个辅助栈
        Stack<TreeNode> stack = new Stack<>();

        if (root == null) {
            return list;
        }
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            list.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return list;
//        if(root == null) {
//            return list;
//        }
//        TreeNode cur = root;
//        //prev永远指向上一个访问的节点
//        TreeNode prev = null;
//        while(true) {
//            // 借助 cur 循环往左找, 如果该节点不为 null, 入栈
//            while(cur != null) {
//                stack.push(cur);
//                cur = cur.left;
//            }
//            if(stack.isEmpty()) {;
//                break;
//            }
//            TreeNode top = stack.peek();
//            // 到底能不能访问栈顶元素, 有两种情况:
//            //  a) 栈顶元素没有右子树, 就可以访问
//            //  b) 栈顶元素的右子树刚刚已经访问过, 也可以访问
//            if(top.right == null || top.right == prev) {
//                stack.pop();
//                list.add(top.val);
//                prev = top;
//            } else {
//                cur = top.right;
//            }
//        }
//        return list;
    }

    //136. 只出现一次的数字
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int x : nums) {
            ret ^= x;
        }
        return ret;
    }

    //138. 复制带随机指针的链表
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        for (Node node = head; node != null; node = node.next) {
            map.put(node, new Node(node.val, null, null));
        }
        for (Node node = head; node != null; node = node.next) {
            map.get(node).next = map.get(node.next);
            map.get(node).random = map.get(node.random);
        }
        return map.get(head);
    }

    //771. 宝石与石头
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<>();
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            set.add(J.charAt(i));
        }
        for (int i = 0; i < S.length(); i++) {
            if (set.contains(S.charAt(i))) {
                count++;
            }
        }
        return count;
    }

    //692. 前K个高频单词
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            String str = words[i];
            count = map.getOrDefault(str, 0);
            map.put(str, count + 1);
        }
        List<String> list = new ArrayList<>(map.keySet());
        // 在 sort 方法的第二个参数中指定一个比较器对象
        // 来描述自定制比较规则(按出现次数来排序)
        Collections.sort(list, new MyCompare(map));
        // subList 能够返回一个 List 中的一个子区间
        // [0, k) 前闭后开区间
        return list.subList(0, k);
    }

    class MyCompare implements Comparator<String> {
        public Map<String, Integer> map = null;

        public MyCompare(Map<String, Integer> map) {
            this.map = map;
        }

        @Override
        public int compare(String o1, String o2) {
            int count1 = map.get(o1);
            int count2 = map.get(o2);
            if (count1 == count2) {
                return o1.compareTo(o2);
            }
            return count2 - count1;
        }
    }


    //709. 转换成小写字母
    public String toLowerCase(String str) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) <= 'Z' && str.charAt(i) >= 'A') {
                builder.append((char) (str.charAt(i) + 32));
            } else {
                builder.append(str.charAt(i));
            }
        }
        return builder.toString();
    }

    //    189. 旋转数组
//    给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数
    public void rotate(int[] nums, int k) {

        k = k % nums.length;

        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    //反转函数
    private void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    //    27. 移除元素
//    给定一个数组 nums 和一个值 val ，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
//    不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成
    public int removeElement(int[] nums, int val) {
        int len = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[len++] = nums[i];
            }
        }
        return len;
    }

    //    35. 搜索插入位置
//    给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它
//    将会被按顺序插入的位置,你可以假设数组中无重复元素*
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }


    //    383. 赎金信
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int[26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (arr[ransomNote.charAt(i) - 'a']-- <= 0) {
                return false;
            }
        }
        return true;
    }

    //    9. 回文数
//    判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int n = 0;
        while (x > n) {
            int y = x % 10;
            n = n * 10 + y;
            x /= 10;
        }
        return x == n || x == (n / 10);
    }

    //    58. 最后一个单词的长度
//    给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。
//    如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
//    如果不存在最后一个单词，请返回 0 。
    public int lengthOfLastWord(String s) {
        int index = -1;
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                index = i;
                break;
            }
        }
        if (index == -1) {
            return 0;
        } else {
            while (index >= 0 && s.charAt(index--) != ' ') {
                count++;
            }
        }
        return count;
    }

    //    88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] <= nums2[p2]) {
                nums1[p--] = nums2[p2--];
            } else {
                nums1[p--] = nums1[p1--];
            }
        }
        if (p1 < 0) {
            while (p >= 0) {
                nums1[p--] = nums2[p2--];
            }
        }
    }

    //    217. 存在重复元素
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            if (set.contains(x)) {
                return true;
            }
            set.add(x);
        }
        return false;
    }

    //    925. 长按键入
//    public boolean isLongPressedName(String name, String typed) {
//
//    }

    //    977. 有序数组的平方
    public int[] sortedSquares2(int[] A) {
        int left = 0;
        int right = A.length - 1;
        int[] arr = new int[A.length];
        int index = arr.length - 1;
        while (left <= right) {
            if (A[left] * A[left] < A[right] * A[right]) {
                arr[index--] = A[right] * A[right];
                right--;
            } else {
                arr[index--] = A[left] * A[left];
                left++;
            }
        }
        return arr;
    }

    //    917. 仅仅反转字母
    public String reverseOnlyLetters(String S) {
        StringBuilder builder = new StringBuilder();
        int left = 0;
        int right = S.length() - 1;
        for (; left < S.length(); left++) {
            if (Character.isLetter(S.charAt(left))) {
                while (!Character.isLetter(S.charAt(right))) {
                    right--;
                }
                builder.append(S.charAt(right--));
            } else {
                builder.append(S.charAt(left));
            }
        }
        return builder.toString();
    }

    //    905. 按奇偶排序数组
    public int[] sortArrayByParity(int[] A) {
        int temp = 0;
        int left = 0;
        int right = A.length - 1;
        while (left < right) {
            while (A[left] % 2 == 0 && left < right) {
                left++;
            }
            while (A[right] % 2 == 1 && left < right) {
                right--;
            }
            temp = A[left];
            A[left] = A[right];
            A[right] = temp;
        }
        return A;
    }

    //    724. 寻找数组的中心索引
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int x : nums) {
            sum += x;
        }
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] - leftSum == leftSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    //66. 加一
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] != 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

//    414.第三大的数
    public int thirdMax(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int num : nums) {
            set.add(num);
            if (set.size() > 3) {
                set.remove(set.first());
            }
        }
        return set.size() > 2 ? set.first() : set.last();
    }

//    1. 两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                return new int[] {map.get(n), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }

//    67. 二进制求和
    public String addBinary(String a, String b) {
        int ca = 0;
        int sum = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--,j--) {
            sum = ca;
            sum += (i >= 0 ? a.charAt(i) - '0': 0);
            sum += (j >= 0 ? b.charAt(j) - '0': 0);
            builder.append(sum % 2);
            ca = sum / 2;
        }
        builder.append(ca == 1 ? "1" : "");
        return builder.reverse().toString();
    }

//    8. 字符串转换整数 (atoi)
    public int myAtoi(String str) {
        char[] charList = str.toCharArray();
        //正负号
        int sy = 1;
        int rev = 0;
        int pop = 0;
        int i = 0;
        //找到数字的开始下标i
        for (; i < str.length(); i++) {
            if (charList[i] != ' ') {
                if (charList[i] == '+') {
                    i++;
                    break;
                }
                if (charList[i] == '-') {
                    i++;
                    sy = -1;
                    break;
                }
                if (charList[i] >= '0' && charList[i] <= '9') {
                    break;
                } else {
                    return 0; //出现的第一个字符不是数字返回0
                }
            }
        }
        if (i == str.length()) {
            return 0;
        }
        for (; i < str.length(); i++) {
            if (charList[i] >= '0' && charList[i] <= '9') {
                pop = (charList[i] - 48) * sy;
                if(rev>Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)){
                    return Integer.MAX_VALUE;
                }
                if(rev<Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)){
                    return Integer.MIN_VALUE;
                }
                rev = rev * 10 + pop;

            } else {
                break;
            }
        }
        return rev;
    }

//    34. 在排序数组中查找元素的第一个和最后一个位置
    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int[] ret = new int[] {-1, -1};
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                break;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        //跳出上面循环是因为找到target
        if (left <= right) {
            while (nums[mid] == target) {
                mid--;
                if (mid < 0) {
                    break;
                }
            }
            mid++;
            ret[0] = mid;
            while (nums[mid] == target) {
                mid++;
                if (mid > nums.length - 1) {
                    break;
                }
            }
            ret[1] = mid  - 1;
        }
        return ret;
    }

//    125. 验证回文串
    public boolean isPalindrome(String s) {
        if (s.equals("")) {
            return true;
        }
        if (s.equals("0P")) {
            return false;
        }
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if ((s.charAt(left) >= '0' && s.charAt(left) <= '9') ||
                    (s.charAt(left) >= 'a' && s.charAt(left) <= 'z') ||
                    (s.charAt(left) >= 'A' && s.charAt(left) <= 'Z')) {
                if ((s.charAt(right) >= '0' && s.charAt(right) <= '9') ||
                        (s.charAt(right) >= 'a' && s.charAt(right) <= 'z') ||
                        (s.charAt(right) >= 'A' && s.charAt(right) <= 'Z')) {
                    if (s.charAt(left) == s.charAt(right) || (s.charAt(left) + 32) == s.charAt(right) ||
                            (s.charAt(left) - 32) == s.charAt(right)) {
                        left++;
                        right--;
                    } else {
                        return false;
                    }
                } else {
                    right--;
                }
            } else {
                left++;
            }
        }
        return true;
    }

//    443. 压缩字符串
    public int compress(char[] chars) {
        //指向每个区块的开头
        int anchor = 0;
        int read = 0;
        int write = 0;
        for (; read <chars.length; read++) {
            //read指向每个区块的尾
            if (read + 1 == chars.length || chars[read] != chars[read + 1]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char x : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = x;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

//    581.最短无序连续子数组
    public int findUnsortedSubarray(int[] nums) {
        int left = 0;
        int right = 0;
        int min = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i] < nums[i - 1]) {
                right = i;
                break;
            }
        }
        min = nums[left];
        max = nums[left];
        for (; left <= right; left++) {
            if (nums[left] < min) {
                min = nums[left];
            }
            if (nums[left] > max) {
                max = nums[left];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > min) {
                left = i;
                break;
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] < max) {
                right = i;
                break;
            }
        }
        return right - left + 1;
    }

//150. 逆波兰表达式求值
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String s : tokens) {
            if (s.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (s.equals("-")) {
                stack.push(-stack.pop() + stack.pop());
            } else if (s.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (s.equals("/")) {
                int temp = stack.pop();
                stack.push(stack.pop() / temp);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return stack.pop();
    }

//    78. 子集
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        ret.add(new ArrayList<Integer>());
        for (int x : nums) {
            int size = ret.size();
            for (int i = 0; i < size; i++) {
                List<Integer> newList = new ArrayList<>(ret.get(i));
                newList.add(x);
                ret.add(newList);
            }
        }
        return ret;
    }

//    329. 矩阵中的最长递增路径
//    public int longestIncreasingPath(int[][] matrix) {
//
//    }

//    199. 二叉树的右视图
//    public List<Integer> rightSideView(TreeNode root) {
//
//    }

//    1281. 整数的各位积和之差
    public int subtractProductAndSum(int n) {
        int mul = 1;
        int sum = 0;
        while (n > 0) {
            mul *= n % 10;
            sum += n % 10;
            n /= 10;
        }
        return mul - sum;
    }

    //    1290. 二进制链表转整数
    public int getDecimalValue(ListNode head) {
        if (head == null) {
            return 0;
        }
        int count = 0;
        int sum = 0;
        for (ListNode node = head; node != null; node = node.next) {
            count++;
        }
        for (; head != null; head = head.next) {
            sum += head.val * Math.pow(2, count - 1);
            count--;
        }
        return sum;
    }

//    1313. 解压缩编码列表
    public int[] decompressRLElist(int[] nums) {
        int[] arr = new int[5000];
        int index = 0;
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                arr[index++] = nums[i + 1];
            }
        }
        return Arrays.copyOf(arr, index);
    }

//1295. 统计位数为偶数的数字
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int n = 0;
            while (nums[i] > 0) {
                n++;
                nums[i] /= 10;
            }
            if (n % 2 == 0) {
                count++;
            }
        }
        return count;
    }

//    1351. 统计有序矩阵中的负数
    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = grid[0].length - 1; j >= 0 ; j--) {
                if (grid[i][j] >= 0) {
                    break;
                }
                count++;
            }
        }
        return count;
    }

//    1221. 分割平衡字符串
    public int balancedStringSplit(String s) {
        int ret = 0;
        int num = 0;
        for (char x : s.toCharArray()) {
            if (x == 'R') {
                num++;
            } else {
                num--;
            }
            if (num == 0) {
                ret++;
            }
        }
        return ret;
    }

//买卖股票的最佳时机
public int maxProfit(int[] prices) {
    int min = Integer.MAX_VALUE;
    int max = 0;
    for (int i = 0; i < prices.length; i++) {
        if (prices[i] < min) {
            min = prices[i];
        } else if (prices[i] - min > max){
            max = prices[i] - min;
        }
    }
    return max;
}
















}




































//使用队列实现栈的下列操作：
//        push(x) -- 元素 x 入栈
//        pop() -- 移除栈顶元素
//        top() -- 获取栈顶元素
//        empty() -- 返回栈是否为空
class MyStack {
    private LinkedList<Integer> A = new LinkedList<>();
    private LinkedList<Integer> B = new LinkedList<>();

    /** Initialize your data structure here. */
    public MyStack() {

    }

    /** Push element x onto stack. */
    public void push(int x) {
        A.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if(A.isEmpty()) {
            return 0;
        }
        while(A.size() > 1) {
            int cur = A.removeFirst();
            B.add(cur);
        }
        int ret = A.removeFirst();
        swapAB();
        return ret;

    }

    /** Get the top element. */
    public int top() {
        if(A.isEmpty()) {
            return 0;
        }
        while(A.size() > 1) {
            int cur = A.removeFirst();
            B.add(cur);
        }
        int ret = A.removeFirst();
        B.offer(ret);
        swapAB();
        return ret;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return A.isEmpty();
    }

    private void swapAB() {
        LinkedList<Integer> temp = A;
        A = B;
        B = temp;
    }
}
//使用栈实现队列的下列操作：
//        push(x) -- 将一个元素放入队列的尾部。
//        pop() -- 从队列首部移除元素。
//        peek() -- 返回队列首部的元素。
//        empty() -- 返回队列是否为空。
class MyQueue {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    /** Initialize your data structure here. */
    public MyQueue() {

    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(A.isEmpty() && B.isEmpty()) {
            A.push(x);
            return;
        }
        while (!B.isEmpty()) {
            int cur = B.pop();
            A.push(cur);
        }
        A.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        while(!A.isEmpty()) {
            int cur = A.pop();
            B.push(cur);
        }
        return B.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        while(!A.isEmpty()) {
            int cur = A.pop();
            B.push(cur);
        }
        return B.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return A.isEmpty() && B.isEmpty();
    }
}

//    155.设计一个支持 push，pop，top 操作，并能在常数时间内检索到最小元素的栈。
//
//        push(x) -- 将元素 x 推入栈中。
//        pop() -- 删除栈顶的元素。
//        top() -- 获取栈顶元素。
//        getMin() -- 检索栈中的最小元素。
class MinStack {
    private Stack<Integer> A = new Stack<>();
    private Stack<Integer> B = new Stack<>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        A.push(x);
        if(B.isEmpty()) {
            B.push(x);
        } else {
            if(B.peek() < x) {
                B.push(B.peek());
            } else {
                B.push(x);
            }
        }
    }

    public void pop() {
        if(A.isEmpty()) {
            return;
        }
        A.pop();
        B.pop();

    }

    public int top() {
        return A.peek();
    }

    public int getMin() {
        return B.peek();
    }
}

//    622.设计你的循环队列实现。 循环队列是一种线性数据结构，其操作表现基于 FIFO（先进先出）
//        原则并且队尾被连接在队首之后以形成一个循环。它也被称为“环形缓冲器”。
//        循环队列的一个好处是我们可以利用这个队列之前用过的空间。在一个普通队列里，
//        一旦一个队列满了，我们就不能插入下一个元素，即使在队列前面仍有空间。但是使用循环队列，我们能使用这些空间去存储新的值。

class MyCircularQueue {
    private int[] arr;
    private int head = 0;
    private int tail = 0;
    private int size = 0;
    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        arr = new int[k];
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(size == arr.length) {
            return false;
        }
        arr[tail] = value;
        size++;
        if(tail == arr.length - 1) {
            tail = 0;
        } else {
            tail++;
        }
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(size == 0) {
            return false;
        }
        if(head == arr.length - 1) {
            head = 0;
        } else {
            head++;
        }
        size--;
        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(size == 0) {
            return -1;
        }
        return arr[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(size == 0) {
            return -1;
        }
        if(tail == 0){
            return arr[arr.length - 1];
        }
        return arr[tail - 1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size == arr.length;
    }
}

//单词拆分
/*
    状态：F(i):前i个字符是否可以分割
    转移方程： F(i) = F(0) && wordDict.contains(0, i) || F(1) && wordDict.contains(1, i) || ..... || F(j) && wordDict.contains(j, i)
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int len = s.length();
        boolean[] canBreak = new boolean[len + 1];
        canBreak[0] = true;
        for (int i = 1; i <= len; ++i) {
            for (int j = 0; j <= i; j++) {
                if (canBreak[j] && wordDict.contains(s.substring(j, i))) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[len];
    }
}


class Solution1 {
    //自顶向下
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {   //第0列只有 (i-1, 0) 能到达 (i, 0)
                    dp[i][j] = dp[i - 1][j] + triangle.get(i).get(j);
                } else if (i == j) {   // i == j 时，只有 (i-1, j-1) 能到达 (i, j)
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
                }
            }
        }
        //找出最后一行路径和最小的
        int min = dp[m - 1][0];
        for (int j = 1; j < n; j++) {
            if (dp[m - 1][j] < min) {
                min = dp[m - 1][j];
            }
        }
        return min;
    }
    //自底向上
    public int minimumTotal2(List<List<Integer>> triangle) {
        int m = triangle.size();
        int n = triangle.get(m - 1).size();
        int[][] dp = new int[m][n];
        //初始化最后一行，最后一行的距离即为对应的 triangle
        for (int i = 0; i < n; i++) {
            dp[m - 1][i] = triangle.get(m - 1).get(i);
        }
        for (int i = m - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                //F(i, j) = min ( F(i + 1, j), F(i + 1, j + 1) ) + array[i, j]
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }
}

//132. 分割回文串 II

/**
 * 状态：F(i):前i个字符分割成回文串的最小次数
 * 转移方程：j < i, j = 0, 1,....i - 1
 *          当 s[j + 1, i]是回文串，F(i) = min{F(j) + 1}, j = 0, 1, 2, .....i - 1
 * 返回值：F(s.length())
 */
class Solution2 {
    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        boolean[][] isPal = isPalindrome(s);
        int[] min = new int[len + 1];
        //初始化，长度为 n 的字符串最多都分割成单个字符，即 n - 1 种方法
        for (int i = 0; i <= len; i++) {
            min[i] = i - 1;
        }
        for (int i = 1; i <= len; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (isPal[j + 1][i]) {      // s[j + 1, i]是回文串
                    min[i] = Math.min(min[i], min[j] + 1);
                }
            }
        }
        return min[len];
    }

    //将字符串的所有子串是否是回文串保存在二维数组，用空间换时间
    /**
     * 状态：F(i, j):第 i 个字符到第 j 个字符是否是回文串
     * 转移方程：如果 s.charAt(i - 1) == s.charAt(j - 1) && F(i + 1, j - 1)则 F(i, j)为ture
     * 返回：二维数组
     */
    private boolean[][] isPalindrome(String s) {
        int len = s.length();
        boolean[][] isPal = new boolean[len + 1][len + 1];
        for (int i = len; i >= 1; i--) {
            for (int j = i; j <= len; j++) {
                if (i == j) {   //单个字符，一定是回文串
                    isPal[i][j] = true;
                } else if (i == j - 1) {    //两个字符，若这两个字符相等，则为回文串
                    if (s.charAt(i - 1) == s.charAt(j - 1))
                        isPal[i][j] = true;
                } else {
                    if (s.charAt(i - 1) == s.charAt(j - 1) && isPal[i + 1][j - 1])
                        isPal[i][j] = true;
                }
            }
        }
        return isPal;
    }
}

//690. 员工的重要性
class Solution3 {
    public int getImportance(List<Employee> employees, int id) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        return dfs(map, id);
    }
    public int dfs(HashMap<Integer, Employee> map, int id) {
        int res = 0;
        Employee employee = map.get(id);
        res += employee.importance;
        for (int eid : employee.subordinates) {
            res += dfs(map, eid);
        }
        return res;
    }
}

//733. 图像渲染
class Solution4 {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if (newColor == image[sr][sc]) {
            return image;
        }
        int oldColor = image[sr][sc];
        int[][] direction = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
        dfs(image, sr, sc, newColor, oldColor, direction);
        return image;
    }
    public void dfs(int[][] image, int x, int y, int newColor, int oldColor, int[][] direction) {
        int row = image.length;
        int col = image[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (image[x][y] == oldColor) {
            image[x][y] = newColor;
            for (int i = 0; i < 4; i++) {
                dfs(image, x + direction[i][0], y + direction[i][1], newColor, oldColor, direction);
            }
        }

    }
}

//429. N叉树的层序遍历
//class Solution5 {
//    public List<List<Integer>> levelOrder(Node root) {
//        if (root == null) {
//            return new ArrayList<>();
//        }
//        List<List<Integer>> list = new ArrayList<>();
//        Queue<Node> queue = new LinkedList<>();
//        queue.offer(root);
//        while (!queue.isEmpty()) {
//            List<Integer> tmp = new ArrayList<>();
//            int size = queue.size();
//            for (int i = 0; i < size; i++) {
//                Node node = queue.poll();
//                tmp.add(node.val);
//                for (Node n : node.children) {
//                    queue.offer(n);
//                }
//            }
//            list.add(tmp);
//        }
//        return list;
//    }
//}

//130. 被围绕的区域
class Solution6 {

    int[][] position = new int[][] {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void solve(char[][] board) {
        if (board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        int[][] flag = new int[row][col];
        for (int i = 0; i < col; i++) {
            if (board[0][i] == 'O') {
                dfs(board, flag, 0, i);
            }
            if (board[row - 1][i] == 'O') {
                dfs(board, flag, row - 1, i);
            }
        }
        for (int i = 1; i < row - 1; i++) {
            if (board[i][0] == 'O') {
                dfs(board, flag, i, 0);
            }
            if (board[i][col - 1] == 'O') {
                dfs(board, flag, i, col - 1);
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == '*') {
                    board[i][j] = 'O';
                } else {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int[][] flag, int x, int y) {
        int row = board.length;
        int col = board[0].length;
        //越界
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        //该点不等于O或已被访问过
        if (board[x][y] != 'O' || flag[x][y] == 1) {
            return;
        }
        flag[x][y] = 1;
        for (int i = 0; i < 4; i++) {
            dfs(board, flag, x + position[i][0], y + position[i][1]);
        }
    }
}

//695. 岛屿的最大面积
class Solution7 {
    int[][] position = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int ret = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    ret++;
                }
            }
        }
        return ret;
    }

    public void dfs(char[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (grid[x][y] == '0') {
            return;
        }
        grid[x][y] = '0';
        for (int i = 0; i < 4; i++) {
            dfs(grid, x + position[i][0], y + position[i][1]);
        }
    }
}

//690. 员工的重要性
//  广度优先搜索
class Solution8 {
    public int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        Queue<Employee> queue = new LinkedList<>();
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            map.put(e.id, e);
        }
        queue.offer(map.get(id));
        while (!queue.isEmpty()) {
            Employee em = queue.poll();
            sum += em.importance;
            for (Integer x : em.subordinates) {
                queue.offer(map.get(x));
            }
        }
        return sum;
    }
}

//994. 腐烂的橘子
class Solution9 {
    class Pair {
        public int x;
        public int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public void chuanran(int[][] grid, int x, int y) {
        int row = grid.length;
        int col = grid[0].length;
        if (x < 0 || x >= row || y < 0 || y >= col) {
            return;
        }
        if (grid[x][y] == 1) {
            grid[x][y] = 2;
            queue.offer(new Pair(x, y));
        }
    }

    int[][] position = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    Queue<Pair> queue = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int times = 0;
        int row = grid.length;
        int col = grid[0].length;
        boolean flag = false;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new Pair(i, j));
                }
                if (grid[i][j] == 1) {
                    flag = true;
                }
            }
        }
        if (!flag) {
            return 0;
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair pair = queue.poll();
                for (int j = 0; j < 4; j++) {
                    chuanran(grid, pair.x + position[j][0], pair.y + position[j][1]);
                }
            }
            times++;
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return times - 1;
    }
}