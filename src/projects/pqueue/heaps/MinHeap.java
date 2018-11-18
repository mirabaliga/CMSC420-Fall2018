package projects.pqueue.heaps;

import java.util.Iterator;

/**
 * <p>{@link MinHeap}s are <b>complete</b> binary search projects.pqueue.trees whose nodes contents are always smaller than
 * the contents of their children nodes.
 *
 * <p>You should <b>not</b> edit this interface! It is given to you as a resource for your project.</p>
 *
 * @author  <a href="mailto:jasonfil@cs.umd.edu">Jason Filippou</a>
 *
 * @param <T> The {@link Comparable} type held by the {@link MinHeap}.
 *
 * @see projects.pqueue.trees.BinarySearchTree
 * @see LinkedMinHeap
 * @see ArrayMinHeap
 */
public interface MinHeap<T extends Comparable<T>> extends Iterable<T>{

	/**
	 * Add an element in the {@link MinHeap}.
	 * @param element The element to insert to the {@link MinHeap}.
	 */
	public void insert(T element);
	
	/**
	 * Returns <b>and removes</b> the minimum element from the {@link MinHeap}.
	 * @return The minimum element of the {@link MinHeap}.
	 * @throws EmptyHeapException if the {@link MinHeap} is empty.
	 */
	public T deleteMin() throws EmptyHeapException;

	/**
	 * Returns, <b>but does not remove</b>, the minimum element of the {@link MinHeap}.
	 * @return The minimum element of the {@link MinHeap}.
	 * @throws EmptyHeapException If the {@link MinHeap} is empty.
	 */
	public T getMin() throws EmptyHeapException;

	/**
	 * Returns the number of elements in the {@link MinHeap}.
	 * @return The number of elements in the {@link MinHeap}.
	 */
	public int size();
	
	/**
	 * Queries the {@link MinHeap} for emptiness.
	 * @return true if the {@link MinHeap} is empty, false otherwise.
	 */
	public boolean isEmpty();

	/**
	 * Clears the {@link MinHeap} of all elements.
	 */
	public void clear();
	
	/**
	 * {@link MinHeap}s are endowed with fail-fast {@link Iterator}s which return the elements
	 * in <b>ascending</b> order.
	 * @return A <b>fail-fast</b> {@link Iterator} which loops through the {@link MinHeap}'s contents in ascending
	 * order.
	 */
	public Iterator<T> iterator();
}
