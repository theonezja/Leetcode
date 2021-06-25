package leetcode;
import java.util.*;

public class Solution454 {

    //扎破气球，排序加贪心
    public int findMinArrowShots(int[][] points) {
        if(points.length==0){
            return 0;
        }
        int ans = 0;
        //排序
        Arrays.sort(points,new Comparator<int[]>(){
            public int compare(int[] points1, int[] points2){
                if(points1[1]>points2[1]){
                    return 1;
                }else if(points1[1]<points2[1]){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        int pos = points[0][1];
        for(int[] b:points){
            if(b[0]>pos){
                pos = b[1];
                ++ans;
            }
        }

        return ans;
    }
}
