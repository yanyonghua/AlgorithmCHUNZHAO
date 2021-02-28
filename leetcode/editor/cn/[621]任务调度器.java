//给你一个用字符数组 tasks 表示的 CPU 需要执行的任务列表。其中每个字母表示一种不同种类的任务。任务可以以任意顺序执行，并且每个任务都可以在 1 个
//单位时间内执行完。在任何一个单位时间，CPU 可以完成一个任务，或者处于待命状态。 
//
// 然而，两个 相同种类 的任务之间必须有长度为整数 n 的冷却时间，因此至少有连续 n 个单位时间内 CPU 在执行不同的任务，或者在待命状态。 
//
// 你需要计算完成所有任务所需要的 最短时间 。 
//
// 
//
// 示例 1： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 2
//输出：8
//解释：A -> B -> (待命) -> A -> B -> (待命) -> A -> B
//     在本示例中，两个相同类型任务之间必须间隔长度为 n = 2 的冷却时间，而执行一个任务只需要一个单位时间，所以中间出现了（待命）状态。 
//
// 示例 2： 
//
// 
//输入：tasks = ["A","A","A","B","B","B"], n = 0
//输出：6
//解释：在这种情况下，任何大小为 6 的排列都可以满足要求，因为 n = 0
//["A","A","A","B","B","B"]
//["A","B","A","B","A","B"]
//["B","B","B","A","A","A"]
//...
//诸如此类
// 
//
// 示例 3： 
//
// 
//输入：tasks = ["A","A","A","A","A","A","B","C","D","E","F","G"], n = 2
//输出：16
//解释：一种可能的解决方案是：
//     A -> B -> C -> A -> D -> E -> A -> F -> G -> A -> (待命) -> (待命) -> A -> (待
//命) -> (待命) -> A
// 
//
// 
//
// 提示： 
//
// 
// 1 <= task.length <= 104 
// tasks[i] 是大写英文字母 
// n 的取值范围为 [0, 100] 
// 
// Related Topics 贪心算法 队列 数组 
// 👍 585 👎 0


import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 时间复杂度：O(|\textit{task}| + |\Sigma|)O(∣task∣+∣Σ∣)，其中 |\Sigma|∣Σ∣
     * 是数组 \textit{task}task 中出现任务的种类，
     * 在本题中任务用大写字母表示，因此 |\Sigma|∣Σ∣ 不会超过 2626。
     *
     * 空间复杂度：O(|\Sigma|)O(∣Σ∣)。
     * 构造一个正方形
     */
   /* public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq = new HashMap<>();
        //最多的执行次数
        int maxExec =0;
        for (char task : tasks) {
            int exec =freq.getOrDefault(task,0)+1;
            freq.put(task,exec);
            maxExec= Math.max(maxExec,exec);
        }
        // 具有最多执行次数的任务数量
        int count =0;
        Set<Map.Entry<Character, Integer>> entries = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            int value = entry.getValue();
            if (value== maxExec){
                ++count;
            }
        }
        //构造一个正方形，长是n+1 宽是 最大执行次数-1（因为最后一行不一定是满的）
        // count 则是是所有最大执行数的个数
        return Math.max((maxExec-1)*(n+1)+ count,tasks.length);
    }*/
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> freq =new HashMap<>();
        int max =0;
        for (char task : tasks) {
          int i=  freq.getOrDefault(task,0)+1;
          freq.put(task,i);
          max = Math.max(max,i);
        }

        int count =0;

      Set<Map.Entry<Character,Integer>> entries = freq.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            int value =entry.getValue();
            if (value ==max){
                count++;
            }
        }
        return Math.max((max -1)* (n+ 1)+count,tasks.length);

    }

}
//leetcode submit region end(Prohibit modification and deletion)
