//给定一个非空的整数数组，返回其中出现频率前 k 高的元素。 
//
// 
//
// 示例 1: 
//
// 输入: nums = [1,1,1,2,2,3], k = 2
//输出: [1,2]
// 
//
// 示例 2: 
//
// 输入: nums = [1], k = 1
//输出: [1] 
//
// 
//
// 提示： 
//
// 
// 你可以假设给定的 k 总是合理的，且 1 ≤ k ≤ 数组中不相同的元素的个数。 
// 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。 
// 题目数据保证答案唯一，换句话说，数组中前 k 个高频元素的集合是唯一的。 
// 你可以按任意顺序返回答案。 
// 
// Related Topics 堆 哈希表 
// 👍 621 👎 0


import sun.misc.Queue;

import java.text.Collator;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     *解答成功:
     * 		执行耗时:14 ms,击败了86.05% 的Java用户
     * 		内存消耗:41.2 MB,击败了25.77% 的Java用户
     * 	时间复杂度 ：O（n）
     * 	空间复杂度 ：O（k）
     */
    public int[] topKFrequent(int[] nums, int k) {
      Map<Integer,Integer> map=  new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //此处使用PriorityQueue ，不要使用Queue
        // 0 表示值 ，下标 1 表示出现的次数
        PriorityQueue<int[]> queue =new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 左减右 小数在上（小数堆） ，反之则是大树堆
                return o1[1]-o2[1];
            }
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int num = entry.getKey(); int count = entry.getValue();
            if (queue.size() < k){
                queue.offer(new int[]{num,count});
            }else if (count >  queue.peek()[1]){
                queue.poll();
                queue.offer(new int[]{num,count} );
            }
        }

       int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll()[0];
        }
      return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
