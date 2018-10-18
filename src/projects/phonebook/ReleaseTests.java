package projects.phonebook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import projects.phonebook.hashes.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import static org.junit.Assert.*;
import static projects.phonebook.hashes.CollisionResolver.*;


/**
 * <p> {@link ReleaseTests} is a jUnit-test suite for {@link Phonebook} and {@link HashTable}.</p>
 *
 * @author <a href = "mailto:jason.filippou@gmail.com">jason.filippou@gmail.com</a>
 *
 * @see Phonebook
 * @see HashTable
 * @see SeparateChainingHashTable
 * @see LinearProbingHashTable
 * @see QuadraticProbingHashTable
 */
public class ReleaseTests {

    private Phonebook pb;
    private CollisionResolver[] resolvers = {SEPARATE_CHAINING, LINEAR_PROBING, QUADRATIC_PROBING};
    private HashMap<String, String> testingPhoneBook;
    private static final long SEED = 47;
    private Random r = new Random(SEED);

    private String format(String error, CollisionResolver namesToPhones, CollisionResolver phonesToNames){
        return error + "Collision resolvers:" + namesToPhones + ", " + phonesToNames + ".";
    }

    private String errorData(Throwable t){
        return "Received a " + t.getClass().getSimpleName() + " with message: " + t.getMessage() + ".";
    }

    @Before
    public void setUp(){
        testingPhoneBook = new HashMap<>();
        testingPhoneBook.put("Arnold", "894-59-0011");
        testingPhoneBook.put("Tiffany", "894-59-0011");
        testingPhoneBook.put("Jessie", "705-12-7500");
        testingPhoneBook.put("Mary", "888-1212-3340");
        testingPhoneBook.put("DeAndre", "367-9090-1199");
        testingPhoneBook.put("Charles", "667-093-4567");
        testingPhoneBook.put("Jacqueline", "321-990-2801");
        testingPhoneBook.put("Christine", "104-356-2111");
        testingPhoneBook.put("Paulette", "215-334-6807");
        testingPhoneBook.put("Nakeesha", "708-890-2234");
        testingPhoneBook.put("Alexander", "590-260-9001");
        testingPhoneBook.put("Aditya", "890-123-0209");
        testingPhoneBook.put("Jason", "900-701-2902");
        testingPhoneBook.put("Yi", "921-350-4314");
        testingPhoneBook.put("Helen", "810-206-9450");
        testingPhoneBook.put("Carl", "850-102-8974");
    }

    @After
    public void tearDown(){
        testingPhoneBook.clear();
    }

    @Test
    public void testPBBehaviorWhenEmpty(){
        for(CollisionResolver namesToPhones : resolvers){
            for(CollisionResolver phonesToNames: resolvers){
                pb = new Phonebook(namesToPhones, phonesToNames);
                assertTrue(format("Phonebook should be empty", namesToPhones, phonesToNames), pb.isEmpty());
                assertNull(format("Any search by name should fail in an empty phonebook.", namesToPhones, phonesToNames), pb.getNumberOf("Jessie"));
                assertNull(format("Any search by phone should fail in an empty phonebook.", namesToPhones, phonesToNames), pb.getOwnerOf("301-478-9012"));
            }
        }
    }

    @Test
    public void testPBInsertions(){
        for(CollisionResolver namesToPhones : resolvers){
            for(CollisionResolver phonesToNames: resolvers){
                pb = new Phonebook(namesToPhones, phonesToNames);
                for(Map.Entry<String, String> entry : testingPhoneBook.entrySet()){ // https://docs.oracle.com/javase/10/docs/api/java/util/Map.Entry.html
                    try {
                        pb.addEntry(entry.getKey(), entry.getValue());
                    }catch(Throwable t){
                        fail(format("Failed to add entry <" + entry.getKey() + ", " + entry.getValue() + ">.", namesToPhones, phonesToNames) + errorData(t));
                    }
                }
                assertEquals("Phonebook size was different from the one expected.", testingPhoneBook.size(), pb.size());
            }
        }
    }

    @Test
    public void testPBDeletions(){
        // For all possible pairs of CollisionResolver instances, insert all the keys and delete all the keys.
        for(CollisionResolver namesToPhones : resolvers){
            for(CollisionResolver phonesToNames: resolvers){
                pb = new Phonebook(namesToPhones, phonesToNames);

                // Insert everything contained in our library container...
                for(Map.Entry<String, String> entry : testingPhoneBook.entrySet()){
                    pb.addEntry(entry.getKey(), entry.getValue());
                }

                // Try to delete every entry and report any Throwables that come your way.
                for(Map.Entry<String, String> entry : testingPhoneBook.entrySet()){ // https://docs.oracle.com/javase/10/docs/api/java/util/Map.Entry.html
                    try {
                        pb.deleteEntry(entry.getKey(), entry.getValue());
                    }catch(Throwable t){
                        fail(format("Failed to delete entry <" + entry.getKey() + ", " + entry.getValue() + ">.", namesToPhones, phonesToNames) + errorData(t));
                    }
                }
                assertTrue(format("After deleting all of its entries, the phonebook should be empty!", namesToPhones, phonesToNames), pb.isEmpty());
            }
        }
    }

    @Test
    public void testPBGetNumberOf(){
        for(CollisionResolver namesToPhones : resolvers){
            for(CollisionResolver phonesToNames: resolvers) {
                pb = new Phonebook(namesToPhones, phonesToNames);

                // Insert everything contained in our library container...
                for (Map.Entry<String, String> entry : testingPhoneBook.entrySet()) {
                    pb.addEntry(entry.getKey(), entry.getValue());
                }

                // Check all applications of getNumberOf()...
                for (Map.Entry<String, String> entry : testingPhoneBook.entrySet()) { // https://docs.oracle.com/javase/10/docs/api/java/util/Map.Entry.html
                    try {
                        assertEquals("After inserting <" + entry.getKey() + ", " + entry.getValue() + ">" +
                                        "getNumberOf(" + "\"" + entry.getKey() + "\" returned the wrong number.", entry.getValue(),
                                       pb.getNumberOf(entry.getKey()));
                    } catch (AssertionError ae) { // Separate error logging for AssertionErrors and other Throwables.
                        throw ae;
                    } catch (Throwable t) {
                        fail(format("Failed to get the number of person:" + entry.getKey() + ".", namesToPhones, phonesToNames) + errorData(t));
                    }
                }
                assertEquals("After calling getNumberOf() on all of its contained persons, the phonebook's size should not have" +
                        "changed!", testingPhoneBook.size(), pb.size());
            }
        }

    }

    @Test
    public void testPBGetOwnerOf(){
        for(CollisionResolver namesToPhones : resolvers) {
            for (CollisionResolver phonesToNames : resolvers) {
                pb = new Phonebook(namesToPhones, phonesToNames);

                // Insert everything contained in our library container...
                for (Map.Entry<String, String> entry : testingPhoneBook.entrySet()) {
                    pb.addEntry(entry.getKey(), entry.getValue());
                }
                // Check all applications of getOwnerOf()....
                for (Map.Entry<String, String> entry : testingPhoneBook.entrySet()) { // https://docs.oracle.com/javase/10/docs/api/java/util/Map.Entry.html
                    try {
                        assertEquals("After inserting <" + entry.getKey() + ", " + entry.getValue() + ">" +
                                        "getOwnerOf(" + "\"" + entry.getValue() + "\" returned the wrong name.", entry.getKey(),
                                pb.getOwnerOf(entry.getValue()));
                    } catch (AssertionError ae) { // Separate error logging for AssertionErrors and other Throwables.
                        throw ae;
                    } catch (Throwable t) {
                        fail(format("Failed to get the owner of number:" + entry.getValue() + ".", namesToPhones, phonesToNames) + errorData(t));
                    }
                }
                assertEquals("After calling getOwnerOf() on all of its contained phone numbers, the phonebook's size should not have" +
                        "changed!", testingPhoneBook.size(), pb.size());
            }
        }
    }
}
