package day08;

public class Solution06 {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
//        int ax3 = ax1;
//        int ay3 = ay2;
//        int ax4 = ax2;
//        int ay4 = ay1;
//        int bx3 = bx1;
//        int by3 = by2;
//        int bx4 = bx2;
//        int by4 = by1;
//        if (bx1 >= ax1 && bx1 >= ax2 || ax1 >= bx1 && ax1 >= bx2 || by1 >= ay1 && by1 >= ay2 || ay1 >= by1 && ay1 >= by2) {
//            return 0;
//        }

//        return (ay2 - ay1) * (ax2 - ax1) + (by2 - by1) * (bx2 - bx1) - Math.max(ax2 - bx1, 0) * Math.max(by2 - ay1, 0);

        int x1 = Math.max(ax1, bx1);
        int y1 = Math.max(ay1, by1);
        int x2 = Math.min(ax2, bx2);
        int y2 = Math.min(ay2, by2);
        if (x1 >= x2 || y1 >= y2) {
            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1);
        } else {
            return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - (x2 - x1) * (y2 - y1);
        }


    }
}
