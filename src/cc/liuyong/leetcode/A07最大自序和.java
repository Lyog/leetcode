package cc.liuyong.leetcode;

public class A07最大自序和 {
    public Integer maxSubArray(int[] nums){
        int pre = 0;
        int ans = nums[0];
        for (int num :nums){
            pre = Math.max(pre+num,num);
            ans = Math.max(ans,pre);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new A07最大自序和().maxSubArray(nums));
    }
}
