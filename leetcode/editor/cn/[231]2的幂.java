//给定一个整数，编写一个函数来判断它是否是 2 的幂次方。 
//
// 示例 1: 
//
// 输入: 1
//输出: true
//解释: 20 = 1 
//
// 示例 2: 
//
// 输入: 16
//输出: true
//解释: 24 = 16 
//
// 示例 3: 
//
// 输入: 218
//输出: false 
// Related Topics 位运算 数学 
// 👍 284 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了100.00% 的Java用户
     * 		内存消耗:35.4 MB,击败了71.87% 的Java用户
     * 时间复杂度：O(1)。
     * 空间复杂度：O(1)。
     */
  /*  public boolean isPowerOfTwo(int n) {
        if (n ==0)return false;
        long x =(long) n;
        //每一个2的幂次，都是只有一个1的 ，如果只有一个
        //x & (-x) 可以获得最右边的1
        return (x & (-x)) ==x;
    }*/

    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了100.00% 的Java用户
     * 		内存消耗:35.5 MB,击败了59.09% 的Java用户
     * 时间复杂度：O(1)。
     * 空间复杂度：O(1)。
     */
    public boolean isPowerOfTwo(int n) {
        if (n ==0)return false;
        long x =(long) n;
        //每一个2的幂次，都是只有一个1的 ，如果只有一个
        // x & (x -1) 2的幂次变成 0 如果 不是幂次就不会等于0
        return (x & (x -1) ) ==0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
