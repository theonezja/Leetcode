package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Solution435 {
    //无重叠区间
    //由于选出的区间互不重叠，因此我们可以将它们按照端点从小到大的顺序进行排序，
    // 并且无论我们按照左端点还是右端点进行排序，得到的结果都是唯一的。
    public int eraseOverlapIntervals(int[][] intervals){
        if(intervals.length==0){
            return 0;
        }
        //排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            public int compare(int[] interval1, int[] interval2){
                return interval1[0]-interval2[0];
            }
        });
        int n = intervals.length;
        int[] f = new int[n];
        Arrays.fill(f, 1);
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(intervals[j][1]<=intervals[i][0]){
                    f[i] = Math.max(f[i],f[j]+1);
                }
            }
        }
        return n - Arrays.stream(f).max().getAsInt();
    }
}
