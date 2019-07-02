package com.company.bytedance.others;

import java.util.Random;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class rand {
    public int rand5(){
        Random random = new Random();
        return random.nextInt(5);
    }
    public  int rand7(){
        int v = rand5()*5+rand5();
        if(v<21){
            return v%7;
        }
        return rand7();

    }

}
