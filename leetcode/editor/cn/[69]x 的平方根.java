//实现 int sqrt(int x) 函数。 
//
// 计算并返回 x 的平方根，其中 x 是非负整数。 
//
// 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。 
//
// 示例 1: 
//
// 输入: 4
//输出: 2
// 
//
// 示例 2: 
//
// 输入: 8
//输出: 2
//说明: 8 的平方根是 2.82842..., 
//     由于返回类型是整数，小数部分将被舍去。
// 
// Related Topics 数学 二分查找 
// 👍 588 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 牛顿法
     * 解答成功:
     * 		执行耗时:1 ms,击败了100.00% 的Java用户
     * 		内存消耗:35.5 MB,击败了65.06% 的Java用户
     *
     */
    public int mySqrt(int x) {
        long a = x;
        while (a * a >x){
            a =( a + x /a )/2;
        }
        return (int ) a;
    }
    /**
     * 解答成功:
     * 		执行耗时:1 ms,击败了100.00% 的Java用户
     * 		内存消耗:35.9 MB,击败了5.17% 的Java用户
     * @param x
     * @return
     */
    /*public int mySqrt(int x) {
        if (x ==0) return 0;
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left =1;
        long right =x /2;
        while (left< right){
            //注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
//            long mid = left+ (right -left +1) /2;
            long mid = (left +right + 1)>>> 1;
            long square = mid * mid;
            //相乘的结果 大于原来的数
            if (square > x){
                right = mid -1;
            }else {
                left =mid;
            }
        }
        return (int ) left;
    }*/
}
//leetcode submit region end(Prohibit modification and deletion)
