package projects.phonebook.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import java.util.Random;

/**
 * <p>A jUnit testing framework for {@link PrimeGenerator}.</p>
 *
 * <p><b>YOU DO NOT HAVE TO EDIT THIS CLASS! IT HAS BEEN PROVIDED AS A HELPFUL RESOURCE.</b></p>
 *
 * @see PrimeGenerator
 * @author <a href="mailto:jason.filippou@gmail.com">Jason Filippou</a>
 */
public class PrimeGeneratorTests {

    /* ********************************* */
    /* Private data fields  and methods  */
    /* ********************************* */

    private PrimeGenerator pg;

    private static String format(Throwable t){
        return "Caught a " + t.getClass().getSimpleName()+ " with message: " + t.getMessage() + ".";
    }


    /* *************/
    /* Unit tests  */
    /* *************/

    /**
     * Instantiates the {@link PrimeGenerator} instance that will be tested. This @Before - annotated methood
     * runs before every @Test-annotated method.
     */
    @Before
    public void setUp(){
        pg = new PrimeGenerator();
    }

    /**
     * Throws away the {@link PrimeGenerator} instance tested.
     */
    @After
    public void tearDown(){
        pg = null; // Can be garbage - collected.
    }
    /**
     * Tests the <b>default</b> behavior of {@link PrimeGenerator#getCurrPrime()}, which should be returning 13.
     */

    @Test
    public void testCurrentPrimeDefault() {
        assertEquals("Expected 13 by default.", 13, pg.getCurrPrime());
    }

    /**
     * Tests the behavior of {@link PrimeGenerator#getNextPrime()}.
     */
    @Test
    public void testGetNextPrime() {
        assertEquals("Expected 29 after first call to getNextPrime().", 29, pg.getNextPrime());
        assertEquals("Expected 29 to be returned by this method after a successful call to getNextPrime().",
                29, pg.getCurrPrime());
        assertEquals("Expected 59 after second call to getNextPrime().", 59, pg.getNextPrime());
        assertEquals("Expected 59 to be returned by this method after a successful second call to getNextPrime().",
                59, pg.getCurrPrime());
    }


    /**
     * Tests the behavior of {@link PrimeGenerator#getPreviousPrime()}.
     */
    @Test
    public void testGetPreviousPrime() {
        assertEquals("Expected 5 after first call to getPreviousPrime().", 5, pg.getPreviousPrime());
        assertEquals("Expected 5 to be returned by this method after a successful call to getPreviousPrime().",
                5, pg.getCurrPrime());
        assertEquals("Expected 2 after second call to getPreviousPrime().", 2, pg.getPreviousPrime());
        assertEquals("Expected 2 to be returned by this method after a successful second call to getPreviousPrime().",
                2, pg.getCurrPrime());
    }

    /**
     * Tests whether the {@link PrimeGenerator} instance points to 13 after a call to
     * {@link PrimeGenerator#getNextPrime()} followed by a call to {@link PrimeGenerator#getPreviousPrime()}.
     */
    @Test
    public void testGetNextAndThenPreviousPrime(){
        pg.getNextPrime();
        pg.getPreviousPrime();
        assertEquals("Expected getCurrPrime() to return  13 after a call to getNextPrime() and a call to " +
                "getPreviousPrime().", 13, pg.getCurrPrime());
    }


    /**
     * Tests whether the {@link PrimeGenerator} instance points to 11 after a call to
     * {@link PrimeGenerator#getPreviousPrime()} followed by a call to {@link PrimeGenerator#getNextPrime()}.
     */
    @Test
    public void testgetPreviousAndThenNextPrime(){
        pg.getPreviousPrime();
        pg.getNextPrime();
        assertEquals("Expected getCurrPrime() to return  13 after a call to getPreviousPrime() and a call to " +
                "getNextPrime().", 11, pg.getCurrPrime());
    }

    /** Tests for edge cases of {@link PrimeGenerator} which <b>should</b> be throwing {@link NoMorePrimesException}
     * instances.
     */
    @Test
    public void testExceptionsThrown(){
        pg.getPreviousPrime();
        pg.getPreviousPrime();
        try {
            pg.getPreviousPrime();
        } catch(NoMorePrimesException ignored){
            // Good, test succeeded
        } catch(Throwable t) { // Otherwise, test failed. Make sure an assertion error is propagated to the top.
            fail(format(t));
        }

        // The biggest prime number we store is 7907. We start making calls to getNextPrime() which will *more than double*
        // the current prime number every time. 2^12 = 4096 and 2^13 = 8192. Without even looking at my list of primes
        // I know that in at most 12 calls to getNextPrime() (the first one gives me 4) I am reaching a number that is definitely
        // beyond my list of current primes.

        for(int i = 0; i < 12; i++){
            // Embedding the try block inside the for loop makes the loop very slow, but allows for the index 'i' to be
            // visible to the scope of the catch-blocks. This in turn allows us to throw an AssertionError with information
            // about exactly *which* iteration failed.
            try {
                pg.getNextPrime();
            } catch(NoMorePrimesException ignored){
                // Good
            } catch(Throwable t){
                fail("Call to getNextPrime() #" + (i + 1) + ": " + format(t) );
            }
        }
    }

    /**
     * Tests the behavior of {@link PrimeGenerator#reset()}.
     */
    @Test
    public void testReset(){

        // Initial test
        pg.reset();
        assertEquals("Expected getCurrPrime() to return  13 after a call to reset()", 13, pg.getCurrPrime());

        // Make a small, yet random number of calls to getNextPrime() and getPreviousPrime(),
        // then call reset(), see whether it behaves as advertised.

        Random r = new Random(47);
        int callsToGetNextPrime = r.nextInt(3) + 6; // At least 6 calls (you'll see why later).
        for(int ignored = 0; ignored < callsToGetNextPrime; ignored++)
            pg.getNextPrime();

        // Give me up to 6 calls to getPrevPrime().
        int callsToGetPrevPrime = r.nextInt(6);
        for(int ignored = 0; ignored < callsToGetPrevPrime; ignored++)
            pg.getPreviousPrime();

        pg.reset();
        assertEquals("After " + callsToGetNextPrime + " calls to getNextPrime() and " + callsToGetPrevPrime +
                " calls to getPreviousPrime() and one call to reset(), we did not get 13 as the current prime number.",
                13, pg.getCurrPrime());
    }
}
