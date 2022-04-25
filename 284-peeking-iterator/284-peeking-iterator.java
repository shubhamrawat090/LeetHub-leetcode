// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

class PeekingIterator implements Iterator<Integer> {
    
    List<Integer> list;
	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    list = new LinkedList<>();
        while(iterator.hasNext()){
            list.add(iterator.next());
        }
	}
	
    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        if(list.size()>0)
            return list.get(0);
        return -1;
	}
	
	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        int num = -1;
	    if(list.size()>0)
            num = list.remove(0);
        return num;
	}
	
	@Override
	public boolean hasNext() {
	    return list.size()>0;
	}
}