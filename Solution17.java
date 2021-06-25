package leetcode;
import java.util.ArrayList;
import java.util.List;
import java.util.*;

public class Solution17 {
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if(digits.length()==0){
            return res;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>(){{
            put('2',"abc");
            put('3', "def");
            put('4',"ghi");
            put('6',"mno");
            put('7',"pqrs");
            put('8',"tuv");
            put('9',"wxyz");
        }};
        dfs(res,phoneMap,digits,0,new StringBuffer());
        return res;
    }
    
    private void dfs(List<String> res, Map<Character, String> phoneMap,String digits, int index, StringBuffer com){
        if(index == digits.length()){
            res.add(com.toString());
        }else{
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for(int i=0; i<lettersCount;i++){
                com.append(letters.charAt(i));
                dfs(res,phoneMap,digits,index+1,com);
                com.deleteCharAt(index);
            }
        }
    }
}
