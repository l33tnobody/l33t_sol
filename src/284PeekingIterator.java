// Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
class PeekingIterator implements Iterator<Integer> {
    private Integer cache = null;
    private Iterator<Integer> it;

	public PeekingIterator(Iterator<Integer> iterator) {
	    // initialize any member here.
	    it = iterator; // check null if you will
	    if (it.hasNext()) cache = it.next();  // one ahead
	}

    // Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
        return cache;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
        Integer ret = cache;
	    cache = it.hasNext() ? it.next() : null;
	    return ret;
	}

	@Override
	public boolean hasNext() {
	    return cache != null;
	}
}
