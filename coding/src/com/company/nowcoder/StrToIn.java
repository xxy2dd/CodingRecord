package com.company.nowcoder;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class StrToIn {
    public int StrToInt(String str) {
        int res = 0,n = str.length(),symbol = 1,start = 0;
        if(str==null || n==0){
            return res;
        }
        char[] temp = str.toCharArray();
        if(temp[0]=='-'){
            symbol=-1;
            start = 1;
        }
        if(temp[0]=='+'){
            symbol=1;
            start = 1;
        }
        for(int i=start ;i<temp.length;i++){
            if(temp[i]>='0'&&temp[i]<='9'){
                continue;
            }else{
                return res;
            }
        }
        for(int i= start;i<temp.length;i++ ){
            res = (res<<1) + (res<<3) + (temp[i]& 0xf);
        }
        return res*symbol;

    }
}
