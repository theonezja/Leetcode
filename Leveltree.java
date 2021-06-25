package leetcode;

import java.util.*;

class TreeNode{
    TreeNode left;
    TreeNode right;
    int val;
    public TreeNode(){

    }
}
public class Leveltree {
    //从上倒下打印二叉树，桉树的层次遍历,又称二叉树的广度优先搜索（BFS）
    // 同时BFS通过队列来实现层次遍历
    public int[] level(TreeNode root){
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> res = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node = root;
            res.add(node.val);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        int[] output = new int[res.size()];
        for(int i=0;i<res.size();i++){
            output[i] = res.get(i);
        }
        return output;
    }


    //从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if (root!=null) queue.add(root);

        while(!queue.isEmpty()){
            ArrayList<Integer> tmp = new ArrayList<>();
            for(int i=res.size();i>0;i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "hifdhie jifej lejnng";
        String[] str = s.split(" ");
        System.out.print(str[str.length-1].length());
    }
}
