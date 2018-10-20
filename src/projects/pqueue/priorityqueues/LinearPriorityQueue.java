package projects.pqueue.priorityqueues;

import projects.pqueue.InvalidCapacityException;
import projects.pqueue.InvalidPriorityException;
import projects.pqueue.fifoqueues.*;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;

/**
 * <p> Model implementation of <tt>LinearPriorityQueue</tt> for the first project of
 *  CMSC420: Data Structures, CS UMD, Fall 2018. </p>
 *
 * @param <T> The type held by the container.
 *
 *<a href="mailto:jasonfil@cs.umd.edu">Jason Filippou</a>
 *
 * @see MinHeapPriorityQueue
 *
 */
public class LinearPriorityQueue<T> implements PriorityQueue<T> {

	/* ************************************* */
	/* YOUR PRIVATE FIELDS AND METHODS  HERE */
	/* ************************************* */

	private static final RuntimeException UNIMPL_METHOD = new RuntimeException("Implement this method!");


	/* ***************************************** */
	/* YOU MUST IMPLEMENT THE PUBLIC METHODS BELOW */
	/* ***************************************** */

	/**
	 * Default constructor initializes the data structure with
	 * a default capacity. This default capacity will be the default capacity of the
	 * underlying data structure that you will choose to use to implement this class.
	 */
	public LinearPriorityQueue(){
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	/**
	 * Non-default constructor initializes the data structure with
	 * the provided capacity. This provided capacity will need to be passed to the default capacity
	 * of the underlying data structure that you will choose to use to implement this class.
	 * @see #LinearPriorityQueue()
	 * @param capacity The initial capacity to endow your inner implementation with.
	 * @throws InvalidCapacityException if the capacity provided is negative.
	 */
	public LinearPriorityQueue(int capacity) throws InvalidCapacityException{
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public void enqueue(T element, int priority) throws InvalidPriorityException{
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public T dequeue() throws EmptyPriorityQueueException {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public T getFirst() throws EmptyPriorityQueueException {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}


	@Override
	public int size() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public boolean isEmpty(){
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