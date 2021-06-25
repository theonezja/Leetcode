package leetcode;

public class Knapsack01 {
    int [][] arr;
    public int knapsack(int[] w, int[] v, int C){

        int n = w.length;
        arr = new int[n][C+1];
        for(int i=0;i<n;i++){
            for(int j=0;j<C+1;j++){
                arr[i][j] = -1;
            }
        }
        return beastValue(w,v,n-1,C);
    }

    //用[0...index]的物品，填充容积为C的背包的最大价值
    private int beastValue(int[] w, int[] v, int index, int C){
        if(index<0||C<=0) return 0;
        if(arr[index][C]!=-1) return arr[index][C];
        int res = beastValue(w,v,index-1,C);
        if (C>=w[index]){
            res = Math.max(res ,v[index] + beastValue(w,v,index-1,C-w[index]));
        }
        arr[index][C] = res;
        return res;
    }


    public int knaspack(int[] w,int[] v, int C){
        int n = w.length;
        if(n==0||C==0) return 0;
        int [][] dp = new int[2][C+1];

        for(int i=0;i<n;i++){
            for(int j=0;j<C+1;j++){
                dp[i][j] = -1;
            }
        }
        for(int j=0;j<C+1;j++){
            dp[0][j] = (j>=w[0]?v[0]:0);
        }
        for(int i =1;i<n;i++){
            for(int j=0;j<C+1;j++){
                dp[i%2][j] = dp[(i-1)%2][j];
                if(j>=w[i])
                    dp[i%2][j] = Math.max(dp[i%2][j], v[i]+dp[(i-1)%2][j-w[i]]);
            }
        }
        return dp[(n-1)%2][C];
    }

    public int knaspack1(int[] w,int[] v, int C){
        int n = w.length;
        if(n==0||C==0) return 0;
        int [] dp = new int[C+1];

        for(int i=0;i<n;i++){
            dp[i] = -1;
        }
        for(int j=0;j<C+1;j++){
            dp[j] = (j>=w[0]?v[0]:0);
        }
        for(int i =1;i<n;i++){
            for(int j=0;j>=w[i];j--){

                    dp[j] = Math.max(dp[j], v[i]+dp[j-w[i]]);
            }
        }
        return dp[C];
    }
}
