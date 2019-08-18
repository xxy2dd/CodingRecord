package com.company.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author xxy
 * @date 2019/7/1
 * @description
 * 方法一：利用 LinkedHasgMap 实现
 * 方法二：自定义双向链表Node + HashMap
 */
public class LRUCache {
    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    int capacity;
    HashMap<Integer,Node> map;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            setHead(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node old = map.get(key);
            old.value = value;
            remove(old);
            setHead(old);
        }else{
            Node node = new Node(key,value);
            if(map.size()>=capacity){
                map.remove(tail.key);
                remove(tail);
            }
            setHead(node);
            map.put(key,node);
        }

    }
    public void remove(Node node){
        Node next = node.next;
        Node pre = node.pre;
        // 判断node是否是头结点
        if(pre!=null){
            pre.next = next;
        }else{
            head = node.next;
        }
        // 判断node是否是尾节点
        if(next!=null){
            next.pre = pre;
        }else{
            tail = node.pre;
        }
    }
    public void setHead(Node node){
        node.next = head;
        node.pre = null;
        // 判断头结点是否为空
        if(head!=null){
            head.pre = node;
        }
        // 如果头结点为空，则将head指向node
        head = node;
        // 如果尾节点为空，则tail也指向node
        if(tail==null){
            tail = head;
        }

    }

}
class LRUCacheByLinkedHashMap {
    int capacity;
    LinkedHashMap<Integer,Integer> map;

    public  LRUCacheByLinkedHashMap(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<>(capacity,0.75f,true);
    }

    public int get(int key) {
        return map.get(key)==null?-1:map.get(key);
    }

    public void put(int key, int value) {
        if(map.size()>=capacity&&!map.containsKey(key)){
            map.remove(map.keySet().iterator().next());
        }
        map.put(key,value);
    }
}

