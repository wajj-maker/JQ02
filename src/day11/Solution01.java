package day11;

import java.util.Iterator;

public class Solution01 {

}

class PeekingIterator implements Iterator<Integer> {
    private Iterator<Integer> iterator;
    private Integer cache;
    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;
        cache = null;
    }
    public Integer peek() {
        if (cache == null) {
            cache = iterator.next();
        }
        return cache;
    }
    @Override
    public Integer next() {
        if (cache != null) {
            Integer temp = cache;
            cache = null;
            return temp;
        }
        return iterator.next();
    }
    @Override
    public boolean hasNext() {
        return cache != null || iterator.hasNext();
    }
}
