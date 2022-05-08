/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    private List<Integer> intList = new ArrayList<>();
    private int idx = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        for(NestedInteger listItem: nestedList) {
            flatten(listItem);
        }
    }
    
    private void flatten(NestedInteger listItem) {
        if(listItem.isInteger()) {
            intList.add(listItem.getInteger());
        }else {
            for(NestedInteger subListItem: listItem.getList())
                flatten(subListItem);
        }
    }

    @Override
    public Integer next() {
        return intList.get(idx++);
    }

    @Override
    public boolean hasNext() {
        return idx < intList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */