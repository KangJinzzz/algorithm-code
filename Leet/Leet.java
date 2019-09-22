import java.util.Arrays;

public class Leet{
    public static void main(String[] args) {
        int[] arr = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit2(arr));
        
        
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



    //118.给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
    // class Solution {
    //     public List<List<Integer>> generate(int numRows) {
            
    //     }
    // }



    //121. 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    // 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
    // 注意你不能在买入股票前卖出股票。
    // 示例 1:
    // 输入: [7,1,5,3,6,4]
    // 输出: 5
    // 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    //     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

    public static int maxProfit(int[] prices) {
        // int left = 0;
        // int right = prices.length - 1;
        // int max = 0;
        // while(left < right) {
        //     while(left < right) {
        //         if ((prices[right] - prices[left]) > max) {
        //             max = prices[right] - prices[left];
        //         }
        //         right--;
        // }
        // right = prices.length - 1;
        // left++;
        // }
        // return max;
        int max = 0;
        int maxValue = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < maxValue) {
                maxValue = prices[i];
            }else if (prices[i] - maxValue > max) {
                max = prices[i] - maxValue;
            }
        }
        return max;
    }

    // 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
    // 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
    // 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
    // 示例 1:
    // 输入: [7,1,5,3,6,4]
    // 输出: 7
    // 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    //      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
  
    public static int maxProfit2(int[] prices) {
        int max = 0;
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] > prices[i - 1]) {
                max = max + prices[i] - prices[i - 1];
            }
        }
        return max;
    }


}




