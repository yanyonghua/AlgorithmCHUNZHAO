//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 2.00000, n = 10
//输出：1024.00000
// 
//
// 示例 2： 
//
// 
//输入：x = 2.10000, n = 3
//输出：9.26100
// 
//
// 示例 3： 
//
// 
//输入：x = 2.00000, n = -2
//输出：0.25000
//解释：2-2 = 1/22 = 1/4 = 0.25
// 
//
// 
//
// 提示： 
//
// 
// -100.0 < x < 100.0 
// -231 <= n <= 231-1 
// -104 <= xn <= 104 
// 
// Related Topics 数学 二分查找 
// 👍 572 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *	解答成功:
     * 		执行耗时:1 ms,击败了98.28% 的Java用户
     * 		内存消耗:37.9 MB,击败了22.03% 的Java用户
     * 时间复杂度：O(\log n)，即为递归的层数。
     * 空间复杂度：O(\log n)，即为递归的层数。这是由于递归的函数调用会使用栈空间。
     *
     */
    private double quick(double x, long n){
        //recursion terminator
        if (n ==0)return 1.0;
        //conquer subproblems
        double result = quick(x,n / 2);
        //return final result
        return n % 2 == 1 ? result * result *x : result * result;
    }
    public double myPow(double x, int n) {
        long N = n;
        //如果 n<0 需要 被1除 并且 取绝对值
        return N >= 0? quick(x, N): 1.0/quick(x, -N);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
