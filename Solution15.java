package leetcode;
import java.util.*;


//题目是三数之和，利用排序后双指针去遍历，然后找到答案。
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums){
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(int first=0;first<n;first++){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            int third = n-1;
            int target = -nums[first];
            for(int second=first+1;second<n;second++){
                if(second>first+1&&nums[second]==nums[second-1]){
                    continue;
                }
                while(second<third&&nums[second]+nums[third]>target){
                    third--;
                }

                if(second==third){
                    break;
                }

                if(nums[second]+nums[third]==target){
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);

                }
            }
        }
        return ans;
    }

    //利用查找表
    //两层for循环就可以确定 a 和b 的数值了，可以使用哈希法来确定 0-(a+b) 是否在 数组里出现过，其实这个思路是正确的
}
