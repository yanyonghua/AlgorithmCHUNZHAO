//给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。 
//
// 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。 
//
// 
//
// 示例 1： 
//
// 输入："abc"
//输出：3
//解释：三个回文子串: "a", "b", "c"
// 
//
// 示例 2： 
//
// 输入："aaa"
//输出：6
//解释：6个回文子串: "a", "a", "a", "aa", "aa", "aaa" 
//
// 
//
// 提示： 
//
// 
// 输入的字符串长度不会超过 1000 。 
// 
// Related Topics 字符串 动态规划 
// 👍 485 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 			执行耗时:4 ms,击败了77.40% 的Java用户
     * 			内存消耗:36.5 MB,击败了84.43% 的Java用户
     * 时间复杂度：O(n^2)。
     * 空间复杂度：O(1)。
     */
   /* public int countSubstrings(String s) {
        //方法一
        int n =s.length(),ans=0;
         //2*n -1 是为了让所有的 n都能轮一遍 while循环里面做了限制
        for (int i = 0; i < 2 * n - 1; ++i) {
            //l为当前左边界 ，r为当前位置的有边界
            int l =i/2,r= i/2 + i%2;
            while (l>=0 &&r < n &&s.charAt(l)==s.charAt(r)){
                //往两边扩散
                --l;
                ++r;
                ++ans;
            }

        }
        return ans;
    }*/


    public int countSubstrings(String s) {
        //方法二
        int n =s.length();
        StringBuffer t =new StringBuffer("$#");
        for (int i = 0; i < n; ++i) {
            t.append(s.charAt(i));
            t.append('#');
        }
        n =t.length();
        t.append('!');
        int[] f =new int[n];
        int iMax = 0,rMax =0,ans =0;
        for (int i = 1; i < n; ++i) {
            //初始化
            f[i] = i<rMax ?Math.min(rMax-i+1,f[2* iMax -1]):1;
            //从中心拓展
            while (t.charAt(i+f[i]) == t.charAt(i- f[i])){
                ++f[i];
            }
            //动态维护rMax ，iMax
            if (i +f[i] -1 >rMax){
                iMax =i;
                rMax =i+f[i] -1;
            }
            // 统计答案, 当前贡献为 (f[i] - 1) / 2 上取整
            ans += f[i] /2;
        }

        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
