package day11;

public class Solution03 {
    public boolean canWinNim(int n) {
        return n < 4 || n % 4 != 0;
    }
}
