package com.company.nowcoder;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class FirstAppearingOnce {
    HashMap<Character,Integer> map = new HashMap();
    ArrayList<Character> list = new ArrayList<Character>();
    //Insert one char from stringstream
    public void Insert(char ch)
    {
        if(map.containsKey(ch)){
            map.put(ch,map.get(ch)+1);
        }else{
            map.put(ch,1);
        }
        list.add(ch);
    }
    // return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for(char c:list){
            if(map.get(c)==1){
                return c;
            }
        }
        return '#';

    }
}
