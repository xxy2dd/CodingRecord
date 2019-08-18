package com.company.leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * @author xxy
 * @date 2019/7/1
 * @description
 * ����һ������ LinkedHasgMap ʵ��
 * ���������Զ���˫������Node + HashMap
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
        // �ж�node�Ƿ���ͷ���
        if(pre!=null){
            pre.next = next;
        }else{
            head = node.next;
        }
        // �ж�node�Ƿ���β�ڵ�
        if(next!=null){
            next.pre = pre;
        }else{
            tail = node.pre;
        }
    }
    public void setHead(Node node){
        node.next = head;
        node.pre = null;
        // �ж�ͷ����Ƿ�Ϊ��
        if(head!=null){
            head.pre = node;
        }
        // ���ͷ���Ϊ�գ���headָ��node
        head = node;
        // ���β�ڵ�Ϊ�գ���tailҲָ��node
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

