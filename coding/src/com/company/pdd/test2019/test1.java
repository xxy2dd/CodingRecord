package com.company.pdd.test2019;

/**
 * @author xxy
 * @date 2019/7/28
 * @description
 * ������������A��B����������A�Ǽ����ϸ��������еģ�
 * �����Ķ�����ֻ��ı�����һ����������������ȫ�������С�
 * ��������Ǵ�A���ҵ�������飬��������B��ѡȡһ����������棬ʹ��A���ϸ��������еģ�
 * ���ҳ�B������Ҫ���������֣�������������飬�粻���������NO��
 */
import java.util.*;
public class test1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] aa = scan.nextLine().split(" ");
        String[] bb = scan.nextLine().split(" ");
        int[] a = new int[aa.length];
        int[] b = new int[bb.length];
        // ���봦��
        for (int i = 0; i < aa.length; i++) {
            a[i] = Integer.parseInt(aa[i]);
        }
        for (int i = 0; i < bb.length; i++) {
            b[i] = Integer.parseInt(bb[i]);
        }
        // ��λ������������±�
        int cur = 0;
        for (; cur < a.length - 1; cur++) {
            if (a[cur] >= a[cur + 1]) {
                break;
            }
        }
        // ������������� ͬʱ������β���
        int left1 = cur == 0 ? Integer.MIN_VALUE : a[cur - 1];
        int right1 = a[cur + 1];
        int left2 = a[cur];
        int right2 = cur == a.length - 2 ? Integer.MAX_VALUE : a[cur + 2];
        // ��b���򣬴Ӻ���ǰ��������֤��һ�����������ľ�������ֵ
        Arrays.sort(b);
        int i = b.length - 1;
        for (; i >= 0; --i) {
            if (left1 < b[i] && b[i] < right1) {
                a[cur] = b[i];
                break;
            } else if (left2 < b[i] && b[i] < right2) {
                a[cur + 1] = b[i];
                break;
            }
        }
        if (i == -1) {
            System.out.println("NO");
        } else {
            for (i = 0; i < a.length; i++) {
                System.out.print(a[i]);
                if (i != a.length - 1) {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

}


