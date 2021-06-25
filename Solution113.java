package leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution113 {
    List<List<Integer>> res = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();

    public List<List<Integer>> pathSum(TreeNode root, int target){
        dfs(root, target);
        return res;
    }
    public void dfs(TreeNode root, int sum){
        if(root==null) return;
        path.offerLast(root.val);
        sum -= root.val;
        if(root.left==null&&root.right==null&&sum==0){
            res.add(new LinkedList<Integer>(path));
        }
        dfs(root.left,sum);
        dfs(root.right,sum);
        path.pollLast();
    }
}
