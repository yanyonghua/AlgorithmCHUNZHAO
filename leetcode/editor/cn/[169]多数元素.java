//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 位运算 数组 分治算法 
// 👍 860 👎 0


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 方法五：Boyer-Moore 投票算法
     * 解答成功:
     * 		执行耗时:3 ms,击败了42.54% 的Java用户
     * 		内存消耗:44.6 MB,击败了5.01% 的Java用户
     * 	时间复杂度：O(n)。Boyer-Moore 算法只对数组进行了一次遍历。
     * 空间复杂度：O(1)。Boyer-Moore 算法只需要常数级别的额外空间。
     */
    public int majorityElement(int[] nums) {
        int count =0;
        Integer candidate =null;
        for (int num : nums) {
            // 众数 + 其他数 肯定大于 0;
            if (count ==0){
                candidate =num;
            }
            // 众数标记为1 其他数标记为-1
            count += (num == candidate ) ? 1 :-1;
        }
        return candidate;
    }

    /**
     * 排序
     * 解答成功:
     * 		执行耗时:2 ms,击败了72.33% 的Java用户
     * 		内存消耗:41.8 MB,击败了58.78% 的Java用户
     * 时间复杂度：O(n\log n)。将数组排序的时间复杂度为 O(n\log n)。
     * 空间复杂度：O(\log n)。如果使用语言自带的排序算法，需要使用 O(\log n) 的栈空间。
     * 如果自己编写堆排序，则只需要使用 O(1) 的额外空间。
     */
   /* public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }*/
    /**
     *
     * 解答成功:
     * 		执行耗时:14 ms,击败了27.78% 的Java用户
     * 		内存消耗:44 MB,击败了8.75% 的Java用户
     * 时间复杂度 ： o(N2)
     * 空间复杂度 ： o(N)
     */
   /* public int majorityElement(int[] nums) {

        HashMap<Integer,Integer> map =new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            ((HashMap) map).put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value> nums.length/2){
                return key;
            }
        }
        return 0;
    }*/


}
//leetcode submit region end(Prohibit modification and deletion)
