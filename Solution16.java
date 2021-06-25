package leetcode;
import java.util.*;
public class Solution16 {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int min = Integer.MIN_VALUE;
        int n = nums.length;
        int ans = 0;

        for(int first=0;first<n;first++){
            if(nums[first]>0){
                break;
            }
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int seconed = first+1;
            int third = n-1;
            while(seconed<third){
                int value = nums[first] + nums[seconed] + nums[third];
                if(value==target){
                    return value;
                }
                if(Math.abs(value-target)<min){
                    min = Math.abs(value-target);
                    ans = value;
                }
                if (value > target) {
                    // 如果和大于 target，移动 c 对应的指针
                    int k0 = third - 1;
                    // 移动到下一个不相等的元素
                    while (seconed < k0 && nums[k0] == nums[third]) {
                        --k0;
                    }
                    third = k0;
                } else {
                    // 如果和小于 target，移动 b 对应的指针
                    int j0 = seconed + 1;
                    // 移动到下一个不相等的元素
                    while (j0 < third && nums[j0] == nums[seconed]) {
                        ++j0;
                    }
                    seconed = j0;
                }

            }

        }
        return ans;
    }

}
