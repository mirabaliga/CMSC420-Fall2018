package projects.phonebook;

import projects.phonebook.hashes.*;

/**
 * <p>{@link Phonebook} is an abstraction over phonebooks: databases of &lt; Full Name,
 * Phone Number&gt; pairs. It allows for <b>both</b> phone <b>and</b> name search, both in
 * <em>amortized constant</em> time. The efficiency of either search will be dependent on
 * the nature of the underlying hash table. No <tt>null</tt> entries are allowed. </p>
 *
 * <p>The Release Tests on the <a href ="https://submit.cs.umd.edu/">submit server</a> test the methods of <b>this class</b>!
 * By parameterizing {@link Phonebook} instances in all 3^2 = 9 possible ways, we can run the same tests against all of the hash
 * tables that you will have to implement. </p>
 *
 * <p><b>**** STUDY, BUT DO NOT EDIT THIS CLASS' SOURCE CODE! </b></p>
 *
 * @author <a href="mailto:jason.filippou@gmail.com">Jason Filippou</a>
 * @see HashTable
 * @see SeparateChainingHashTable
 * @see LinearProbingHashTable
 * @see QuadraticProbingHashTable
 */
public class Phonebook {

    // TODO: When you finish the testing setup for phonebooks, change the constructor to fall back to a
    // java.util.HashTable so you can test whether your implementation of PhoneBook is correct.
    private HashTable<String, String> namesToNumbers;
    private HashTable<String, String> numbersToNames;


    /**
     * Instantiates a new {@link Phonebook}. The parameters provide the collision resolution strategy
     * for lookups based on name or number, respectively.
     *
     * @param namesToNumbersHash A {@link CollisionResolver} that will govern which subtype of {@link HashTable} will be used to
     *                           create our hash table with <b>peoples' names</b> as keys.
     * @param numbersToNamesHash A {@link CollisionResolver} that will govern which subtype of {@link HashTable} will be used to
     *                           create our hash table with <b>phone numbers</b> as keys.
     * @see CollisionResolver
     */
    public Phonebook(CollisionResolver namesToNumbersHash, CollisionResolver numbersToNamesHash) {

    }

    /** Retrieves the phone number associated with the provided full name. If the name is not in the database,
     * this method returns <tt>null</tt>.
     * @param name The full name of the owner of the phone number that is being searched for.
     * @return The phone number associated with <tt>name</tt>, or <tt>null</tt> if <tt>name</tt> is null or if <tt>name</tt>
     * is not in the {@link Phonebook}.
     */
    public String getNumberOf(String name) {
        return (name == null) ? null : namesToNumbers.get(name);
    }

    /** Retrieves the full name of the owner of the provided phone number. If the phone number is not in the database,
     * this method returns <tt>null</tt>.
     * @param number The phone number whose owner is being searched for.
     * @return The full name of the owner of <tt>number</tt>, or <tt>null</tt> if <tt>number</tt> is null or if <tt>number</tt>
     * is not in the {@link Phonebook}.
     */
    public String getOwnerOf(String number) {
        return (number == null) ? null : numbersToNames.get(number);
    }

    /** Adds the tuple &lt; <tt>name</tt>, <tt>number</tt> &gt; in the {@link Phonebook}. If either <tt>name</tt> or
     * <tt>number</tt> are already in the collection
     * @param name The full name of the number's owner.
     * @param number The phone number of the person.
     * @throws IllegalArgumentException if either <tt>name</tt> or <tt>number</tt> is <tt>null</tt>.
     */
    public void addEntry(String name, String number) {
        if(name == null || number == null)
            throw new IllegalArgumentException("Provided: name=" + name + " and number= " + number);
        namesToNumbers.put(name, number);
        numbersToNames.put(number, name);
    }

    /**
     * @param number
     * @param name
     */
    public void deleteEntry(String number, String name) {
        namesToNumbers.remove(name);
        numbersToNames.remove(number);
    }

    /**
     * @param name
     */
    public void deleteNumberOf(String name) {
        String number = namesToNumbers.remove(name);
        numbersToNames.remove(number);
    }

    /**
     * @param number
     */
    public void deleteOwnerOf(String number) {
        String name = numbersToNames.remove(number);
        namesToNumbers.remove(name);
    }

    /**
     * @return
     */
    public int getCount() {
        assert namesToNumbers.size() == numbersToNames.size() :
                "Mismatch in internal hash counts. Names->Numbers has count: " +
                        namesToNumbers.size() + ", while Numbers->Names has count:  " +
                        numbersToNames.size() + ".";
        return namesToNumbers.size();
    }

    /**
     * @return
     */
    public boolean isEmpty() {
        return getCount() == 0;
    }
}
