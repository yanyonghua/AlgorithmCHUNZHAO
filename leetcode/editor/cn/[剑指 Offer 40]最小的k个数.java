//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 183 👎 0


import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)

class Solution {
    //方法三 暴力求解

    /**
     * 	解答成功:
     * 	执行耗时:8 ms,击败了65.37% 的Java用户
     * 	内存消耗:39.6 MB,击败了79.15% 的Java用户
     * 	时间复杂度：O（n） 这边需要 排序 sort时间复杂度是 O（n）的
     * 	空间复杂度：O（k）取决于k的大小
     */
   /* public  int[] getLeastNumbers(int[] arr, int k) {
        if(arr ==null ||arr.length==0||k==0)return new int[0];
        Arrays.sort(arr);
        //组成数组
        int[] res =new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return res;
    }*/
    //方法一 大顶堆

    /**
     * 解答成功:
     * 	执行耗时:22 ms,击败了20.81% 的Java用户
     * 内存消耗:39.7 MB,击败了65.47% 的Java用户
     * 	时间复杂度：O（n）
     * 	空间复杂度：O（k）取决于k的大小
     */
   /* public  int[] getLeastNumbers(int[] arr, int k) {
        if(arr ==null ||arr.length==0||k==0)return new int[0];
        //使用优先队列形成的大根堆 需要重写比较器（默认的是小根堆）
        Queue<Integer> pq =new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i = 0; i < arr.length; i++) {
            //当队列里面的个数小于k个的时候
            if (pq.size() < k){
                //直接塞进去
                pq.offer(arr[i]);
            }else if (arr[i] < pq.peek()){
                //当堆的头部大于当前数时。弹出压入当前树
                pq.poll();
                pq.offer(arr[i]);
            }
        }
        //组成数组
        int[] res =new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = pq.poll();
        }
        return res;
    }*/
    //方法一 快速排序

    /**
     *执行耗时:3 ms,击败了83.20% 的Java用户
     *内存消耗:39.8 MB,击败了57.75% 的Java用户
     * 时间复杂度：O（nlogn）
     * 空间复杂度 ：
     */
    public  int[] getLeastNumbers(int[] arr, int k) {
        randomizedSelected(arr,0,arr.length-1,k);
        int[] res =new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return res;
    }

    public  void randomizedSelected (int[] nums,int l,int r,int k){
        if (l >= r)return;
        int pos =randomizedPartition(nums, l , r);
        int num = pos -l + 1;
        if (k==num){
            return;
        }else if (k< num){
            randomizedSelected(nums, l, pos-1, k);
        }else {
            randomizedSelected(nums, pos+1, r, k-num);
        }
    }
    // 基于随机的划分
    private  int randomizedPartition(int[] nums,int l,int r){
        int i =new Random().nextInt(r - l+1)+l;
        swap(nums,r,i);
        return partition(nums,l,r);
    }

    private  int partition(int[] nums,int l,int r){
        int pivot =nums[r];
        int i=l-1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j]<= pivot){
                i=i+1;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,r);
        return  i+1;
    }
    private  void swap(int[] nums,int i, int j){
        int temp =nums[i];
        nums[i] =nums[j];
        nums[j] =temp;
    }
}

/*
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        randomizedSelected(arr,0,arr.length-1,k);
        int[] res =new int[k];
        for (int i = 0; i < k; ++i) {
            res[i] = arr[i];
        }
        return res;
    }

    public void randomizedSelected (int[] nums,int l,int r,int k){
        if (l >= r)return;
        int pos =randomizedPartition(nums, l , r);
        int num = pos -l + 1;
        if (k==num){
            return;
        }else if (k< num){
            randomizedSelected(nums, l, pos-1, k);
        }else {
            randomizedSelected(nums, pos+1, r, k-num);
        }
    }
    // 基于随机的划分
    private int randomizedPartition(int[] nums,int l,int r){
        int i =new Random().nextInt(r - l+1)+1;
        swap(nums,r,i);
        return partition(nums,l,r);
    }

    private int partition(int[] nums,int l,int r){
        int pivot =nums[r];
        int i=l-1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j]<= pivot){
                i=i+1;
                swap(nums,i,j);
            }
        }
        swap(nums,i+1,r);
        return  i+1;
    }
    private void swap(int[] nums,int i, int j){
        int temp =nums[i];
        nums[i] =nums[j];
        nums[j] =temp;
    }
}*/
//leetcode submit region end(Prohibit modification and deletion)
