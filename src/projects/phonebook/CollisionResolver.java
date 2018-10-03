package projects.phonebook;

/**
 * <p>{@link CollisionResolver} is an <tt>enum</tt> which provides named constants for
 * three of the most widely used collision resolution techniques in hash tables: </p>
 * <ol>
 *     <li><i>Separate Chaining</i>, a simple collision resolver which allocates </li>
 * </ol>
 */
public enum CollisionResolver {
    SEPARATE_CHAINING,
    LINEAR_PROBING,
    QUADRATIC_PROBING
}
