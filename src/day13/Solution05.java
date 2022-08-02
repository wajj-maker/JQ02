package day13;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution05 {

}

interface NestedInteger {

              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();

              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();

              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }

  class NestedIterator implements Iterator<Integer> {
    private List<Integer> list = new ArrayList<>();
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        getList(list, nestedList);
    }
    public void getList(List<Integer> list, List<NestedInteger> nestedIntegers) {
        for (NestedInteger nestedInteger : nestedIntegers) {
            if (nestedInteger.isInteger()) {
                list.add(nestedInteger.getInteger());
            } else {
                getList(list, nestedInteger.getList());
            }
        }
    }
    @Override
    public Integer next() {
        return list.get(index++);
    }
    @Override
    public boolean hasNext() {
        return index < list.size();
    }
}
