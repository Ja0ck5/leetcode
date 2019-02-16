package com.ja0ck5.leetcode;

/**
 * @author: Ja0ck5
 * @Description:
 * @Date: Created in 14:45 2019/2/16
 * @Modified By:
 */
public class RangeSumQueryImmutable {

    private int[] sum;

    public RangeSumQueryImmutable/*NumArray*/(int[] nums) {
        sum = new int[nums.length + 1];
        for(int i=0;i< nums.length;i++){
            // 记录 0 - i 项的和 nums 0-2 的和 在 sum 下标 2+1 = 3 的位置
            sum[i+1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        // num 第 0 - j 项 的和为 sum[j+1] 减去 i 之前的和，即 sum[i] 得到 sumRange(i,j)的和
        return sum[j+1] - sum[i];
    }

}
