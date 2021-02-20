//给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。 
//
// 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。 
//例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。两个字符串的「公共子序列」是这两个字符串所共同拥有的子序列。
// 
//
// 若这两个字符串没有公共子序列，则返回 0。 
//
// 
//
// 示例 1: 
//
// 输入：text1 = "abcde", text2 = "ace" 
//输出：3  
//解释：最长公共子序列是 "ace"，它的长度为 3。
// 
//
// 示例 2: 
//
// 输入：text1 = "abc", text2 = "abc"
//输出：3
//解释：最长公共子序列是 "abc"，它的长度为 3。
// 
//
// 示例 3: 
//
// 输入：text1 = "abc", text2 = "def"
//输出：0
//解释：两个字符串没有公共子序列，返回 0。
// 
//
// 
//
// 提示: 
//
// 
// 1 <= text1.length <= 1000 
// 1 <= text2.length <= 1000 
// 输入的字符串只含有小写英文字符。 
// 
// Related Topics 动态规划 
// 👍 362 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        //构建字符串数组长度的table
        int[][] table =new int[text1.length()+1][text2.length()+1];
        for (int col = 0; col < table[0].length; col++) {
            table[0][col] =0;
        }
        for (int row = 0; row < table.length; row++) {
            table[row][0] = 0;
        }
        for (int row = 1; row < table.length; row++) {
            char ch1 = text1.charAt(row-1);
            for (int col = 1; col < table[row].length; col++) {
                char ch2 = text2.charAt(col-1);
                if (ch2 == ch1){
                    table[row][col] = table[row-1][col-1]+1;
                }else {
                    table[row][col] =Math.max(table[row -1][col],table[row][col-1]);
                }
            }
        }
        int[] lastRow =table[table.length-1];
        return lastRow[lastRow.length-1];
    }
    /**
     * 最长公共子序列的状态方程
     *   if(ch1 == ch2) {
     *                     table[row][col] = table[row-1][col-1] + 1;
     *                 } else {
     *                     table[row][col] = Math.max(table[row-1][col], table[row][col-1]);
     *                 }
     *                 解答成功:
     * 			执行耗时:9 ms,击败了82.08% 的Java用户
     * 			内存消耗:42.4 MB,击败了30.03% 的Java用户
     *
     */
    /*public int longestCommonSubsequence(String text1, String text2) {
        //构建字符串数组长度的table
            int[][] table =new int[text1.length() +1][text2.length()+ 1];
            //第一行第一列 赋值为0
        for (int col = 0; col < table[0].length; col++) {
            table[0][col] =0;
        }
        for (int row = 0; row < table.length; row++) {
            table[row][0]=0;
        }
        //前面因为赋值了所以从1开始
        for (int row = 1; row < table.length; row++) {
            char ch1 = text1.charAt(row-1);
            for (int col = 1; col < table[row].length; col++) {
                char ch2 = text2.charAt(col-1);
                //如果两个字符串相同的话从斜上角 取值 再加1
                if (ch1 ==ch2){
                    table[row][col] = table[row-1][col-1] +1;
                } else {
                    //如果不相同就从左边和上边取较大值
                    table[row][col] =Math.max(table[row-1][col],table[row][col-1]);
                }
            }
        }
        //去最后一个数组值
       int[] lastRow= table[table.length-1];
        return lastRow[lastRow.length-1];
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
