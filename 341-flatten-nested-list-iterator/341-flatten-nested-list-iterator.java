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
    //list for containing the final list with flattened values
    private List<Integer> flattenList = new ArrayList<>();
    //iterator for our list
    private int idx = 0;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        //traverse the nested list and pass them to a helper function for flattenning
        for(NestedInteger listItem: nestedList) {
            flatten(listItem);
        }
    }
    
    private void flatten(NestedInteger listItem) {
        //if our list item is integer we just add it to the flatten list
        if(listItem.isInteger()) {
            flattenList.add(listItem.getInteger());
        }
        //otherwise, we have encounted another list inside our list item
        //pass each item of that sublist to flatten function for flattenning
        else {
            for(NestedInteger subListItem: listItem.getList())
                flatten(subListItem);
        }
    }

    @Override
    public Integer next() {
        //get the value at our current index and increment the index
        return flattenList.get(idx++);
    }

    @Override
    public boolean hasNext() {
        //if our idx < size of the list then there is a next possible.
        //otherwise, not
        return idx < flattenList.size();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */