package day14;

import java.math.BigInteger;

public class Solution09 {
    public int superPow(int a, int[] b) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < b.length; i++) {
            stringBuilder.append(b[i]);
        }
        BigInteger bigInteger1 = new BigInteger(stringBuilder.toString());
        BigInteger bigInteger2 = new BigInteger(String.valueOf(a));
        BigInteger bigInteger3 = new BigInteger("1377");
        return bigInteger2.modPow(bigInteger1, bigInteger3).intValue();
    }
}
