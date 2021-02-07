//假设你是一位很棒的家长，想要给你的孩子们一些小饼干。但是，每个孩子最多只能给一块饼干。 
//
// 对每个孩子 i，都有一个胃口值 g[i]，这是能让孩子们满足胃口的饼干的最小尺寸；并且每块饼干 j，都有一个尺寸 s[j] 。如果 s[j] >= g[i
//]，我们可以将这个饼干 j 分配给孩子 i ，这个孩子会得到满足。你的目标是尽可能满足越多数量的孩子，并输出这个最大数值。 
// 
//
// 示例 1: 
//
// 
//输入: g = [1,2,3], s = [1,1]
//输出: 1
//解释: 
//你有三个孩子和两块小饼干，3个孩子的胃口值分别是：1,2,3。
//虽然你有两块小饼干，由于他们的尺寸都是1，你只能让胃口值是1的孩子满足。
//所以你应该输出1。
// 
//
// 示例 2: 
//
// 
//输入: g = [1,2], s = [1,2,3]
//输出: 2
//解释: 
//你有两个孩子和三块小饼干，2个孩子的胃口值分别是1,2。
//你拥有的饼干数量和尺寸都足以让所有孩子满足。
//所以你应该输出2.
// 
//
// 
//
// 提示： 
//
// 
// 1 <= g.length <= 3 * 104 
// 0 <= s.length <= 3 * 104 
// 1 <= g[i], s[j] <= 231 - 1 
// 
// Related Topics 贪心算法 
// 👍 299 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 排序+ 贪心算法
     * 解答成功:
     * 		执行耗时:8 ms,击败了86.66% 的Java用户
     * 		内存消耗:39.3 MB,击败了36.49% 的Java用户
     *
     * 	时间复杂度：O(mlogm+nlogn)，其中 m 和 n 分别是数组 g 和 s 的长度。
     * 	对两个数组排序的时间复杂度是 O(mlogm+nlogn)，遍历数组的时间复杂度是 O(m+n)，
     * 	因此总时间复杂度是O(mlogm+nlogn)。
     *
     * 空间复杂度：O(logm+logn)，其中 m 和 n 分别是数组 g 和 s 的长度。
     * 空间复杂度主要是排序的额外空间开销。
     *
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int numOfChildren = g.length,numOfCookies = s.length;
        int count =0;
        for (int i = 0,j= 0; i < numOfChildren && j < numOfCookies ;j++, i++) {
            // 胃口大于饼干的单位的时候 跳过 此时j++ 优于 外层循环的j++
            while (j < numOfCookies && g[i] > s[j]){
                j++;
            }
            //如果此时 当前饼干下标没有越界说明可以分发给小朋友
            if (j < numOfCookies){
                count++;
            }
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
