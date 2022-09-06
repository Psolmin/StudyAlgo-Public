import java.math.BigInteger;  

class Solution {
    public long solution(int w, int h) {
        long gcd = BigInteger.valueOf(w).gcd(BigInteger.valueOf(h)).longValue();
        System.out.println(gcd);
        return (long) w * (long) h - ((long) w + (long) h - gcd);
    }
}