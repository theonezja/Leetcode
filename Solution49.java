package leetcode;
import java.util.*;

public class Solution49 {

    //同一组字母异位词中的字符串具备相同点，可以使用相同点作为一组字母异位词的标志，
    //使用哈希表存储每一组字母异位词，哈希表的键为一组字母异位词的标志，哈希表的值为一组字母异位词列表。
    public List<List<String>> groupAnagrams(String[] strs){
        //排序
        Map<String, List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] array = str.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            list.add(str);
            map.put(key, list);
        }
        return new ArrayList<List<String>>(map.values());
    }
}
