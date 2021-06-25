package leetcode;
import java.util.*;
public class Solution447 {
    public int numberOfBoomerangs(int[][] points){
        int ans=0;

        for(int i=0;i<points.length;i++){
            Map<Integer,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(j!=i){
                    int dx = points[i][0] - points[j][0];
                    int dy = points[i][1] - points[j][1];
                    int dis = dx*dx + dy*dy;
                    map.put(dis, map.getOrDefault(dis,0)+1);
                }
            }
            for(int val:map.values()){
                ans+=val*(val-1);
            }
        }
        return ans;
    }
}
