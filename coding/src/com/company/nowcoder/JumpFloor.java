package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        if(target==1){
            return 1;
        }
        if(target==2){
            return 2;
        }
        int f1 = 1;
        int f2 = 2;
        int f = 0;
        for(int i=3;i<=target;i++){
            f = f1+f2;
            f1 = f2;
            f2 = f;
        }
        return f;
    }
}
