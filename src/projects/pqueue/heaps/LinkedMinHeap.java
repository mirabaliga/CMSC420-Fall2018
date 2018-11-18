package projects.pqueue.heaps;

import java.util.Iterator;
/**
 * <p>Model implementation of LinkedMinHeap for the first project of
 * CMSC420: Data Structures, CS UMD, Fall 2018. </p>
 *
 * @author <a href="mailto:jasonfil@cs.umd.edu">Jason Filippou</a>
 *
 */
public class LinkedMinHeap<T extends Comparable<T>> implements MinHeap<T> {

	/* ************************************* */
	/* YOUR PRIVATE FIELDS AND METHODS  HERE */
	/* ************************************* */

	private static final RuntimeException UNIMPL_METHOD = new RuntimeException("Implement this method!");


	/* ***************************************** */
	/* YOU MUST IMPLEMENT THE PUBLIC METHODS BELOW */
	/* ***************************************** */

	/**
	 *  Default constructor sets pointers to null and count to 0.
	 */
	public LinkedMinHeap(){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	/**
	 *  Second constructor creates a root node with the element provided
	 *  as the content.
	 *  @param rootElement the element to create the root with.
	 */
	public LinkedMinHeap(T rootElement){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	/**
	 * Copy constructor initializes the current MinHeap as a carbon
	 * copy of the parameter.
	 *
	 * @param other The MinHeap to copy the elements from.
	 */
	public LinkedMinHeap(MinHeap<T> other){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	/**
	 * Standard equals() method.
	 *
	 * @return true If the parameter Object and the current MinHeap
	 * are identical Objects.
	 */
	@Override
	public boolean equals(Object other){
		if(other == null || !(other instanceof MinHeap<?>))
			return false;
		MinHeap<?> oheap = null;
		try {
			oheap = (MinHeap<?>)other;
		} catch(ClassCastException cce){
			return false;
		}
		Iterator<?> itthis = iterator(), ito = oheap.iterator();
		while(itthis.hasNext())
			if(!itthis.next().equals(ito.next()))
				return false;
		return true;
	}


	@Override
	public boolean isEmpty() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
	}

	@Override
	public int size() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
	}

	@Override
	public void clear() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}


	/* To insert an element in the heap, we insert it as the last leaf, and then we move the element upward until
	 * the heap identity is maintained.
	 */
	@Override
	public void insert(T element) {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
	}

	@Override
	public T getMin() throws EmptyHeapException {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public T deleteMin() throws EmptyHeapException {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}



	@Override
	public Iterator<T> iterator(){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!
	}

} // outer class LinkedMinHeap


