package com.company.nowcoder;

import java.util.BitSet;

/**
 * @author xxy
 * @date 2019/6/30
 * @description
 */
public class FirstNotRepeatingChar {
    public int FirstNotRepeatingChar(String str) {
        BitSet bs1 = new BitSet(256);
        BitSet bs2 = new BitSet(256);
        for (char c : str.toCharArray()) {
            if (!bs1.get(c) && !bs2.get(c))
                // 0 0 -> 0 1
                bs1.set(c);
            else if (bs1.get(c) && !bs2.get(c))
                // 0 1 -> 1 1
                bs2.set(c);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            // 0 1
            if (bs1.get(c) && !bs2.get(c))
                return i;
        }
        return -1;
    }
}
