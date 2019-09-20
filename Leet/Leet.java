import java.util.Arrays;

public class Leet{
    public static void main(String[] args) {
        int[] nums1 = {1, 3, 5, 7};
        int[] nums2 = {2, 4, 5, 6};
        double ret = findMedianSortedArrays(nums1, nums2);
        
        System.out.println(ret);
    }



    //88. 给定两个有序整数数组 nums1 和 nums2,将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
    //
    //说明 :
    //
    //初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
    //你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
    //示例 :
    //
    //输入 :
    //	nums1 = [1, 2, 3, 0, 0, 0], m = 3
    //	nums2 = [2, 5, 6], n = 3
    //
    //输出 : [1, 2, 2, 3, 5, 6]
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n - 1;
        while(p1 >= 0 && p2 >= 0) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

    // 4.给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

    // 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

    // 你可以假设 nums1 和 nums2 不会同时为空。

    // 示例 1:

    // nums1 = [1, 3]
    // nums2 = [2]

    // 则中位数是 2.0
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int p1 = nums1.length - 1;
        int p2 = nums2.length - 1;
        int[] nums = new int[nums1.length + nums2.length] ;
        int p = nums.length - 1;
        while (p1 >= 0 && p2 >= 0) {
            nums[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        if(p1 < 0) {
            System.arraycopy(nums2, 0, nums, 0, p2 + 1);

        }else if(p2 < 0) {
            System.arraycopy(nums1, 0, nums, 0, p1 + 1);

        }
        double ret = 0;
        System.out.println(Arrays.toString(nums));
        if(nums.length % 2 == 0) {
            ret = ((double)nums[nums.length / 2] + nums[(nums.length / 2) - 1]) / 2;
            return ret;
        }
        ret = nums[nums.length / 2];
        return ret;
    }




}




