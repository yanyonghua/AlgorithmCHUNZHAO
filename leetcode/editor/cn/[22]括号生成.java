//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 回溯算法 
// 👍 1534 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 	解答成功:
     * 		执行耗时:1 ms,击败了95.97% 的Java用户
     * 		内存消耗:38.4 MB,击败了88.54% 的Java用户
     * 时间复杂度 ：O（n）
     * 空间复杂度 ：O（n）
     */
    public List<String> generateParenthesis(int n) {
        List<String> list =new ArrayList<>();
        generate(n,0,0,"",list);
        return list;
    }
    //形参里面用的是逗号
    private void generate (int max , int left ,int right, String str , List<String> list){
        if (max == left && max == right){
            list.add(str);
            return;
        }
        if (max > left){
            generate(max,left + 1,right,str + "(",list);
        }
        if (left> right){
            generate(max,left,right + 1,str + ")",list);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
