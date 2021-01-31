//写一个程序，输出从 1 到 n 数字的字符串表示。 
//
// 1. 如果 n 是3的倍数，输出“Fizz”； 
//
// 2. 如果 n 是5的倍数，输出“Buzz”； 
//
// 3.如果 n 同时是3和5的倍数，输出 “FizzBuzz”。 
//
// 示例： 
//
// n = 15,
//
//返回:
//[
//    "1",
//    "2",
//    "Fizz",
//    "4",
//    "Buzz",
//    "Fizz",
//    "7",
//    "8",
//    "Fizz",
//    "Buzz",
//    "11",
//    "Fizz",
//    "13",
//    "14",
//    "FizzBuzz"
//]
// 
// 👍 81 👎 0


import java.util.AbstractList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> fizzBuzz(int n) {
        return new java.util.AbstractList<String>(){
            @Override
            public String get(int index) {
                ++index;
                int obj=index;
                boolean is3 = obj%3==0;
                boolean is5 = obj%5==0;
                if (is3&&is5){
                    return "FizzBuzz";
                }else if (is5){
                    return "Buzz";
                }else if (is3){
                    return "Fizz";
                }else {

                }
                return String.valueOf(obj);
            }

            @Override
            public int size() {
                return n;
            }
        };

    }
}
//leetcode submit region end(Prohibit modification and deletion)
