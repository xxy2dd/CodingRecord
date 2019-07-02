package com.company.bytedance.test19;

import java.util.*;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * Ϊ�˲����Ż��Ƽ�Ч��������ͷ��ÿ��Ҫ�洢�ʹ��������ݡ�
 * ����������һ�ֳ��������Ƕ��û��������ǵ�ע��ʱ���Ⱥ�����ţ�����һ�����£�ÿ���û����в�ͬ��ϲ��ֵ�����ǻ���֪��ĳһ��ʱ����ע����û������������һ���û����У��ж����û�����������ϲ��ֵΪk��
 * ��ΪһЩ�����ԭ�򣬲������һ����ѯ���û�������ȫ������һ����ѯ���û�����(������L1<=L2<=R2<=R1)��
 * ���룺
 * ��1��Ϊn�����û��ĸ���
 * ��2��Ϊn����������i�������û����Ϊi���û���ĳ�����µ�ϲ�ö�
 * ��3��Ϊһ��������q�����ѯ������
 * ��4�е��ڣ�3+q���У�ÿ�а���3������l,r,k����һ���ѯ�������Ϊl<=i<=r���û��ж���������ϲ��ֵΪk���û��ĸ�����
 * ���ݷ�Χn <= 300000,q<=300000 k������
 */
public class userFav {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[] userLike = new int[n];
        Map<Integer,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<n;i++){
            userLike[i] = scan.nextInt();
            int key = userLike[i];
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(key)){
                list = map.get(key);
            }
            list.add(i+1);
            map.put(key,list);
        }
        Queue<Integer> queue=new LinkedList<>();
        int m = scan.nextInt();
        for(int j = 0;j<m;j++){
            int low = scan.nextInt();
            int high = scan.nextInt();
            int v = scan.nextInt();
            List<Integer> list = map.get(v);
            int count = 0;
            if(list!=null){
                for(Integer index:list){
                    if(index>=low&&index<=high){
                        count++;
                    }
                }
            }

            queue.add(count);
        }
        for(Integer q:queue){
            System.out.println(q);
        }
    }
}
