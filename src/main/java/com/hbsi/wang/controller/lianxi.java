package com.hbsi.wang.controller;

public class lianxi {
    public static void main(String[] args) {
        int [] nums={1,0,1,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }
    public static int findMaxConsecutiveOnes(int[] nums) {
        int x=0; int max=0;
        for (int i=0;i<nums.length;i++) {
            if (nums[i]==0){
                x=0;
            }else if (++x>max){
                max=x;
            }
        }
        return max;
    }
}
