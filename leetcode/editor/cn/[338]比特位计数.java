//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。 
//
// 示例 1: 
//
// 输入: 2
//输出: [0,1,1] 
//
// 示例 2: 
//
// 输入: 5
//输出: [0,1,1,2,1,2] 
//
// 进阶: 
//
// 
// 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？ 
// 要求算法的空间复杂度为O(n)。 
// 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。 
// 
// Related Topics 位运算 动态规划 
// 👍 511 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 解答成功:
     * 		执行耗时:2 ms,击败了60.27% 的Java用户
     * 		内存消耗:42.5 MB,击败了66.38% 的Java用户
     *时间复杂度：O(nk)。对于每个整数 x，我们需要 O(k) 次操作，其中 k 是 x 的位数。
     * 空间复杂度：O(n)。 我们需要 O(n) 的空间来存储计数结果。如果排除这一点，就只需要常数空间。

     */
    public int[] countBits(int num) {
        int[] ans =new int[num +1];
        for (int i = 0; i <= num; ++i) {
            ans[i] = popcount(i);
        }
        return ans;
    }
    private int popcount(int n){
        int count ;
        for ( count = 0; n !=0 ; ++count) {
            n &= n -1;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
