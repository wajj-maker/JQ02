package day14;

public class Solution05 {
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        if (targetCapacity > jug1Capacity + jug2Capacity) return false;
        int num = gcd(jug1Capacity, jug2Capacity);
        return targetCapacity % num == 0;
    }
}
