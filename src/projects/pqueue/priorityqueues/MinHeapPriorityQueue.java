package projects.pqueue.priorityqueues; // ******* <---  DO NOT ERASE THIS LINE!!!! *******


import projects.pqueue.InvalidPriorityException;
import projects.pqueue.heaps.*;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *<p> Model implementation of <tt>MinHeapPriorityQueue</tt> for the first project of
 *   CMSC420: Data Structures, CS UMD, Fall 2018. </p>
 *
 * <a href="mailto:jasonfil@cs.umd.edu">Jason Filippou</a>
 *
 * @param <T> The Type held by the container.
 *
 * @see LinearPriorityQueue
 * @see MinHeap
 */
public class MinHeapPriorityQueue<T> implements PriorityQueue<T> {

	/* ************************************* */
	/* YOUR PRIVATE FIELDS AND METHODS  HERE */
	/* ************************************* */

	private static final RuntimeException UNIMPL_METHOD = new RuntimeException("Implement this method!");


	/* ***************************************** */
	/* YOU MUST IMPLEMENT THE PUBLIC METHODS BELOW */
	/* ***************************************** */

	/**
	 * Simple default constructor.
	 */
	public MinHeapPriorityQueue() {
		throw UNIMPL_METHOD; // <--- ERASE THIS LINE WHEN YOU IMPLEMENT THE METHOD!

	}

	@Override
	public void enqueue(T element, int priority) throws InvalidPriorityException {
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

	public Iterator<T> iterator() {
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
}
