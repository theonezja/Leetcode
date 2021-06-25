package leetcode;
import java.util.*;


//523题连续子数组的和
//同余定理+哈希表+前缀和
public class Solution523 {
    public boolean checkSubarraySum(int[] nums, int k){
        int n = nums.length;
        if(n<2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);
        int remainder = 0;
        for(int i=0;i<n;i++){
            remainder = (remainder+nums[i])%k;
            if(map.containsKey(remainder)){
                if(i-remainder>=2){
                    return true;
                }
            }else{
                map.put(remainder,i);
            }
        }
        return false;
    }
}
