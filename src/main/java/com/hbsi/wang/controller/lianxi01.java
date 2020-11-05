package com.hbsi.wang.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lianxi01 {
    public static void main(String[] args) {

        int[] nums = {1,1,0,1,1,1};
        int maxConsecutiveOnes = findMaxConsecutiveOnes(nums);
        System.out.println(maxConsecutiveOnes);
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max=0; int c=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                c=0;
            }else if (++c>max){
                max++;
            }
        }
        return max;
    }
}