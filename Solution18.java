package leetcode;
import java.util.*;

public class Solution18 {

    //四数之和
    //排序加双指针
    public List<List<Integer>> fourSum(int[] nums, int target){
        int n = nums.length;
        List<List<Integer>> list = new ArrayList<>();
        if(n<4) return list;
        Arrays.sort(nums);
        for(int i=0;i<n-3;i++){
            if(i>0&&nums[i]==nums[i-1]){
                continue;
            }
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target){
                break;
            }
            if(nums[i]+nums[n-3]+nums[n-2]+nums[n-1]<target){
                continue;
            }
            for(int j=i+1;j<n-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]){
                    continue;
                }
                if(nums[i]+nums[j]+nums[j+1]+nums[j+2]>target){
                    break;
                }
                if(nums[i]+nums[j]+nums[j-1]+nums[j-2]<target){
                    continue;
                }
                int left = j+1, right =n-1;
                while(left<right){
                    int sum = nums[i]+nums[j]+nums[left]+nums[right];
                    if(sum==target){
                        list.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while(left<right&&nums[left]==nums[left+1]){
                            left++;
                        }
                        left++;
                        while(left<right&&nums[right]==nums[right-1]){
                            right--;
                        }
                        right--;
                    }else if(sum<target){
                        left++;
                    }else{
                        right++;
                    }
                }
            }
        }
        return list;
    }
}
