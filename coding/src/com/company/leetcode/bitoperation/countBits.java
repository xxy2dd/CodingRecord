package com.company.leetcode.bitoperation;

/**
 * @author xxy
 * @date 2019/7/25
 * @description
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。
 * 但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 我的思路：根据 1的个数 那题的思路，加一层for循环，但是这样时间复杂度会很高
 *
 */
public class countBits {
    public int[] countBits(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
            // i&(i-1) 去掉最右边的1，所以最后要加上1
            res[i] = res[i&(i-1)]+1;
        }
        return res;
    }
    public int[] countBits2(int num) {
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
            // i/2=i>>2   i%2=i&1
            // i>>1 表示右移一位，i&1 表示最后一位是否为1
            res[i] = res[i>>1]+(i&1);
        }
        return res;
    }

    public int[] countBits3(int num){
        int[] res = new int[num+1];
        res[0] = 0;
        for(int i=1;i<=num;i++){
           if(i%2==1){
               // 奇数比前面的偶数多一个1
               res[i] = res[i-1]+1;
           }else{
               // 偶数中1的个数和除以2之后的那个数一样多，因为最低位是0
               // 除以2 相当于右移一位，抹掉了最低位的0
               res[i] = res[i>>1];
           }
        }
        return res;
    }
}
