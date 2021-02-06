//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 819 👎 0


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * 贪心算法
 * 	解答成功:
 * 		执行耗时:2 ms,击败了96.29% 的Java用户
 * 		内存消耗:40.3 MB,击败了91.37% 的Java用户
 *时间复杂度：O(n)，其中 n 是数组长度。
 * 空间复杂度：O(1)。
 */
class Solution {
    public int jump(int[] nums) {
        int ans = 0;
        int end = 0;
        int rightmost = 0;
        for (int i = 0; i < nums.length-1; i++) {
            rightmost =Math.max(rightmost, nums[i] +i);
            if (i == end){
                end = rightmost;
                ans++;
            }
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
