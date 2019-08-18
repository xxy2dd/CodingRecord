package com.company.zoom;

/**
 * @author xxy
 * @date 2019/8/17
 * @description
 */
import java.util.Scanner;
public class test19 {

        public static void main(String[] args) {
//            Scanner scan = new Scanner(System.in);
//            String s = scan.next();
//            String[] c = s.split(",");
//            Float[] array = new Float[c.length];
//            for(int i = 0;i<c.length;i++){
//                array[i] = Float.parseFloat(c[i]);
//            }
//            float res = maxSubArray2(array);
//            System.out.println(res);
            Scanner sc = new Scanner(System.in);
            int res = -1;
            int n = sc.nextInt();
            int L = sc.nextInt();
            for(int i=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = Math.abs(a-b);
                res = Math.max(res,c);
            }
            System.out.println(res);

        }
        public static Float maxSubArray2(Float[] nums) {
            float sum = 0;
            float max = nums[0];
            for(float n:nums){
                sum = sum<=0?n:n*sum;
                max = Math.max(max,sum);
            }
            return max;
        }
}
