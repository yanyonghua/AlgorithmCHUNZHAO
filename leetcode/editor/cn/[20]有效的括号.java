//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 注意空字符串可被认为是有效字符串。 
//
// 示例 1: 
//
// 输入: "()"
//输出: true
// 
//
// 示例 2: 
//
// 输入: "()[]{}"
//输出: true
// 
//
// 示例 3: 
//
// 输入: "(]"
//输出: false
// 
//
// 示例 4: 
//
// 输入: "([)]"
//输出: false
// 
//
// 示例 5: 
//
// 输入: "{[]}"
//输出: true 
// Related Topics 栈 字符串 
// 👍 2107 👎 0


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    //单引号 使用队列来 解决
    public static final Map<Character,Character> map =new HashMap<>(){{
        put('{','}');
        put('[',']');
        put('(',')');
        put('?','?');
    }};
    public boolean isValid(String s) {
        if (s.length()>0&& !map.containsKey(s.charAt(0)))return false;
        LinkedList<Character> queue =new LinkedList<>(){{add('?');}};
        for (Character c : s.toCharArray()) {
            if (map.containsKey(c)) queue.addLast(c);
            else if (map.get(queue.pollLast())!=c)return false;
        }
        return queue.size()==1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
