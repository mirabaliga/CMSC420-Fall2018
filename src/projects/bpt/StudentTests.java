package projects.bpt;
import org.junit.Test;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * A jUnit test suite for {@link BinaryPatriciaTrie}.
 *
 * @author --- YOUR NAME HERE! ----.
 */
public class StudentTests {


    @Test public void testSimple1() {
        BinaryPatriciaTrie tree = new BinaryPatriciaTrie();

        assertTrue("Trie should be empty",tree.isEmpty());
        assertTrue("Trie size should be 0",tree.getSize() == 0);

        assertFalse("No string inserted so search should fail", tree.search("0101"));

    }

    @Test public void testSimple2() {
        BinaryPatriciaTrie tree = new BinaryPatriciaTrie();

        assertTrue("String should be inserted successfully",tree.insert("00000"));
        assertTrue("String should be inserted successfully",tree.insert("00011"));
        assertFalse("Search should fail as string does not exist",tree.search("000"));

    }


    //testing isEmpty function
    @Test public void testisEmpty() {
        BinaryPatriciaTrie tree = new BinaryPatriciaTrie();
        //Case 1: isEmpty for an empty trie
        assertTrue("Trie should be empty",tree.isEmpty());

        //Case 2: ...


        //Case 3: ...

    }
}
