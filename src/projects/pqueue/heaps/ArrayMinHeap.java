package projects.pqueue.heaps;

import projects.pqueue.InvalidCapacityException;

import java.util.Iterator;
/**
 * <p>Model implementation of ArrayMinHeap for the first project of
 * CMSC420: Data Structures, CS UMD, Fall 2018. </p>
 *
 * @author <a href = "mailto:jasonfil@cs.umd.edu">Jason Filippou</a>
 *
 * @see MinHeap
 * @see LinkedMinHeap
 */
public class ArrayMinHeap<T extends Comparable<T>> implements MinHeap<T> {


	/* ************************************* */
	/* YOUR PRIVATE FIELDS AND METHODS  HERE */
	/* ************************************* */

	private static final RuntimeException UNIMPL_METHOD = new RuntimeException("Implement this method!");


	/* ***************************************** */
	/* YOU MUST IMPLEMENT THE PUBLIC METHODS BELOW */
	/* ***************************************** */

	/**
	 * Default constructor initializes the data structure with the default
	 * capacity.
	 */
	public ArrayMinHeap(){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	/**
	 * Second constructor initializes the data structure with the provided capacity.
	 * @param capacity The capacity to initialize the ArrayMinHeap with.
	 * @throws InvalidCapacityException If the capacity provided is negative.
	 */
	public ArrayMinHeap(int capacity) throws InvalidCapacityException{		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	/**
	 * Copy constructor initializes the current MinHeap as a carbon
	 * copy of the parameter.
	 *
	 * @param other The MinHeap object to base construction of the current object on.
	 */
	public ArrayMinHeap(MinHeap<T> other){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	/**
	 * Standard equals() method.
	 * @return true if the current object and the parameter object
	 * are equal, with the code providing the equality contract.
	 */
	@Override
	public boolean equals(Object other){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public void insert(T element) {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public T deleteMin() throws EmptyHeapException {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public T getMin() throws EmptyHeapException {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public int size() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public boolean isEmpty() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public void clear() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public Iterator<T> iterator() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

}