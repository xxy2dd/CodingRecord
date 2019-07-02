package com.company.bytedance.test19;

import java.util.Scanner;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 * �ҽ����󴸣���һ�ҳ�����ı༭���Ҹ���У��Ͷ������Ӣ�ĸ������ݹ����ǳ����ˣ���Ϊÿ�춼Ҫȥ����������ƴд����
 * ���ǣ��������������ƽ���Ĺ����з��������ҷ���һ������ƴд����Ľݾ���
 * 1. ����ͬ������ĸ����һ��һ����ƴд����ȥ��һ���ľͺ��������� helllo -> hello
 * 2. ����һ������ĸ��AABB�ͣ�����һ��һ����ƴд����ȥ���ڶ��Ե�һ����ĸ�ͺ��������� helloo -> hello
 * 3. ����Ĺ������ȡ������ҡ�ƥ�䣬�������AABBCC����ȻAABB��BBCC���Ǵ���ƴд��Ӧ�����ȿ����޸�AABB�����ΪAABCC
 * �������Ǹ���ţ���������ѧ���ھ���ͳ�����ƣ��������ԭ��д��һ���Զ�У����������Ч�ʴӴ���ɡ�
 * �ò��˶�ã��Ҿͻ����CEO�����϶��³���ӭȢ�׸��������������۷壬���붼�е�С�����أ�����
 * ����û�뵽���ұ������ˣ�����ʱ�ϰ����˵�� ����������Ҫ����ҵҵ�����ڿҿҡ������ַ֣���Ҫ���У���һ����һ�С�һ���������У�Ҫ�ǲ��У���һ�в���һ�У�һ�в������в��С��� �����������˺����л��㱵ġ���
 * �����⣺��ʵ�ִ󴸵��Զ�У�Գ���
 */
public class correctStr {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        for(int i = 0;i<n;i++){
            String s = scan.next();
            String s_correct = correct(s);
            System.out.println(s_correct);
        }
    }
    public static String correct(String str){
        StringBuilder builder = new StringBuilder(str);
        int index = 0, size;
        while ((size = builder.length()) > index) {
            if (index + 1 < size && builder.charAt(index) == builder.charAt(index + 1)) {
                if (index + 2 < size && builder.charAt(index) == builder.charAt(index + 2)) {
                    builder.deleteCharAt(index);
                } else if (index - 2 >= 0 && builder.charAt(index - 1) == builder.charAt(index - 2)) {
                    builder.deleteCharAt(index);
                } else {
                    index++;
                }
            } else {
                index++;
            }
        }
        return builder.toString();
    }
}
