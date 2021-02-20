//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列： 
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot","lo
//g"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 
// 👍 688 👎 0


import com.sun.xml.internal.ws.api.message.saaj.SAAJFactory;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 双向广度优先
     * 	解答成功:
     * 		执行耗时:15 ms,击败了93.03% 的Java用户
     * 		内存消耗:39.5 MB,击败了71.52% 的Java用户
     * 	时间复杂度： O(N×C)
     * 	空间复杂度： O(N×C2)
     *
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {


        return 0;

    }


    /**
     * 	解答成功:
     * 		执行耗时:85 ms,击败了48.92% 的Java用户
     * 		内存消耗:41.5 MB,击败了46.66% 的Java用户
     *  时间复杂度: o(N * C2)
     *  时间复杂度: o(N * C2)
     */
  /*  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (wordSet.size() == 0 || !wordSet.contains(endWord)) return 0;
        //移除当前开始单词
        wordSet.remove(beginWord);
        LinkedList<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Set<String> visited = new HashSet<>();
        //表示被访问过了
        visited.add(beginWord);
        int step = 1;
        //广度优先遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentStr = queue.poll();
                if (changeWordEveryOneLetter(currentStr, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    //从每一个字符中替换
    private boolean changeWordEveryOneLetter(
            String currentStr, String end,
            LinkedList<String> queue, Set<String> visited, Set<String> wordSet) {
        char[] chars = currentStr.toCharArray();
        for (int i = 0; i < end.length(); i++) {
            //取出备用
            char orgin = chars[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j == orgin) continue;
                //从26个字符中选取一个替换，有就存到下一个 备用
                chars[i] = j;
                String nextWord = String.valueOf(chars);
                if (wordSet.contains(nextWord)) {
                    if (nextWord.equals(end)) {
                        return true;
                    }
                    //访问过的字符串存起来
                    if (!visited.contains(nextWord)) {
                        queue.offer(nextWord);
                        visited.add(nextWord);
                    }
                }
            }
            //还原字符数组
            chars[i] = orgin;
        }
        return false;
    }*/

}
//leetcode submit region end(Prohibit modification and deletion)
