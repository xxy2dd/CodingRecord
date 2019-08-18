package com.company.pdd.test19;

import java.util.*;

/**
 * @author xxy
 * @date 2019/7/28
 * @description
 * 给定一个字符串数组（字符串长度和数组长度均大于1且小于1024），所有字符均为大写字母。
 * 请问，给定的字符串数组是否能通过更换数组中元素的顺序，从而首尾相连，形成一个环。
 */
public class test2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] a = scan.nextLine().split(" ");
        List<Character> head = new ArrayList<Character>();
        List<Character> tail = new ArrayList<Character>();
        for(int i = 0;i<a.length;i++){
            head.add(a[i].charAt(0));
            tail.add(a[i].charAt(a[i].length()-1));
        }
        Collections.sort(head);
        Collections.sort(tail);
        for(int i =0;i<head.size();i++){
            if(!head.get(i).equals(tail.get(i))){
                System.out.println("false");
            }
        }
        System.out.println("true");

    }
}
