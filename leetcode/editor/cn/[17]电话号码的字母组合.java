//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 深度优先搜索 递归 字符串 回溯算法 
// 👍 1113 👎 0


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法一 ：回溯
     * 解答成功:
     * 		执行耗时:1 ms,击败了83.74% 的Java用户
     * 		内存消耗:37.2 MB,击败了60.55% 的Java用户
     * 时间复杂度：O(3m×4n)
     * 空间复杂度：O(m+n)，
     */
    public List<String> letterCombinations(String digits) {
        List<String> res =new ArrayList<>();
        if (digits==null||digits.length()==0)return res;
        HashMap<Character,String> map =new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        combinations(new StringBuffer(),digits,map,res,0);
        return res;
    }

    private void  combinations(StringBuffer s,String digits,HashMap<Character,String> map,
                               List<String> res,int level){
        if (level == digits.length()){
            res.add(s.toString());
            return;
        }
        //获得当前层的数字
        char ch =digits.charAt(level);
        //获得当前层的字母
        String latter=  map.get(digits.charAt(level));
        for (int i = 0; i < latter.length(); i++) {
            //添加入其中一个
            s.append(latter.charAt(i));
            combinations(s, digits, map, res, level+1);
            //回溯
            s.deleteCharAt(level);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
