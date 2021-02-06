//一条基因序列由一个带有8个字符的字符串表示，其中每个字符都属于 "A", "C", "G", "T"中的任意一个。 
//
// 假设我们要调查一个基因序列的变化。一次基因变化意味着这个基因序列中的一个字符发生了变化。 
//
// 例如，基因序列由"AACCGGTT" 变化至 "AACCGGTA" 即发生了一次基因变化。 
//
// 与此同时，每一次基因变化的结果，都需要是一个合法的基因串，即该结果属于一个基因库。 
//
// 现在给定3个参数 — start, end, bank，分别代表起始基因序列，目标基因序列及基因库，请找出能够使起始基因序列变化为目标基因序列所需的最少变
//化次数。如果无法实现目标变化，请返回 -1。 
//
// 注意： 
//
// 
// 起始基因序列默认是合法的，但是它并不一定会出现在基因库中。 
// 如果一个起始基因序列需要多次变化，那么它每一次变化之后的基因序列都必须是合法的。 
// 假定起始基因序列与目标基因序列是不一样的。 
// 
//
// 
//
// 示例 1： 
//
// 
//start: "AACCGGTT"
//end:   "AACCGGTA"
//bank: ["AACCGGTA"]
//
//返回值: 1
// 
//
// 示例 2： 
//
// 
//start: "AACCGGTT"
//end:   "AAACGGTA"
//bank: ["AACCGGTA", "AACCGCTA", "AAACGGTA"]
//
//返回值: 2
// 
//
// 示例 3： 
//
// 
//start: "AAAAACCC"
//end:   "AACCCCCC"
//bank: ["AAAACCCC", "AAACCCCC", "AACCCCCC"]
//
//返回值: 3
// 
// 👍 66 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // DFS 不需要记录使用过的片段

    /**
     * 解答成功:
     * 		执行耗时:0 ms,击败了100.00% 的Java用户
     * 		内存消耗:36 MB,击败了94.16% 的Java用户
     * 时间复杂度：O（n）n为bank的长度
     * 时间复杂度：O（n2）
     */
    public int minMutation(String start, String end, String[] bank) {
        //所有字符数组化
        char[][] chars =new char[bank.length][8];
        for (int i = 0; i < bank.length; i++) {
            chars[i] = bank[i].toCharArray();
        }
        minRecur(start.toCharArray(),end.toCharArray(),chars,0);
        //如果没有则返回-1
        return minCount==Integer.MAX_VALUE?-1:minCount;
    }
    int minCount =Integer.MAX_VALUE;

   private void minRecur(char[] start,char[] end,char[][] chars,int count){
       if (Arrays.equals(start,end)){
           minCount= Math.min(minCount,count);
           return;
       }
       for (int i = 0; i < chars.length; i++) {
           char[] piece =chars[i];
            if (piece ==null)continue;
            int diff=0;
           for (int j = 0; j < start.length; j++) {
               if (start[j]!=piece[j])diff++;
           }
           //取出只有一处不同的片段
           if (diff==1){
               chars[i] =null;
               //交给下一层
               minRecur(piece,end,chars,count+1);
               chars[i] =piece;
           }
       }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
