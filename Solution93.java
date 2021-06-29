package leetcode;
import java.util.*;

public class Solution93 {
    /*
    * 给定一个只包含数字的字符串，用以表示一个 IP 地址，返回所有可能从 s 获得的 有效 IP 地址 。
    * 你可以按任何顺序返回答案。有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），
    * 整数之间用 '.' 分隔。
    * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
    * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
*/
    /*
    * 算法问题的baseline:
    * 处理特殊值和初始化
    * 算法主体
    * 返回值
    * */
    /*
    * 回溯法
    * 对所有的可能的字符串分隔方式进行搜索
    * 对于ip地址来说最大也就是向下遍历三个数字，
    * */
    int[] segments = new int[4];
    List<String> res = new ArrayList<String>();
    public List<String> restoreIpAddresses(String s){


        if(s.length()<4 || s.length()>12) return res;
        dfs(s,0,0);
        return res;
    }

    public void dfs(String s,int id, int start){
        //如果找到了4段ip地址并且遍历完了字符串，那么就是一种答案
        if(id==4){
            if (start==s.length()){
                StringBuffer ipAddr = new StringBuffer();
                for(int i=0;i<4;i++){
                    ipAddr.append(segments[i]);
                    if(i!=3){
                        ipAddr.append('.');
                    }
                }
                res.add(ipAddr.toString());

            }
            return ;
        }
        if(start==s.length()){
            return;
        }
        if(s.charAt(start)=='0'){
            segments[id] = 0;
            dfs(s,id+1,start+1);
        }
        int addr = 0;
        for(int end = start;end<s.length();end++){
            addr = addr*10 + (s.charAt(end)-'0');
            if(addr>0&&addr<0xff){
                segments[id] = addr;
                dfs(s,id+1,end+1);
            }else{
                break;
            }
        }
    }
}
