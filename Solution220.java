package leetcode;
import java.util.*;

public class Solution220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t){
        TreeSet<Long> set = new TreeSet<>();
        for(int i=0;i<nums.length;i++){
            Long ceiling = set.ceiling((long)nums[i] - (long)t);
            if(ceiling!=null&&ceiling<=(long)nums[i]+(long)t){
                return true;
            }
            set.add((long) nums[i]);

            if(i>=k){
                set.remove((long)nums[i-k]);
            }
        }
        return false;
    }
}
