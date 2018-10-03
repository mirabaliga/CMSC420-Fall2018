package projects.phonebook;

/**
 * <p>{@link Phonebook} is an abstraction over phonebooks: databases of &lt; Full Name,
 * Phone Number&gt; pairs. It allows for <b>both</b> phone <b>and</b> name search, both in
 * <em>amortized constant</em> time. The efficiency of either search will be dependent on
 * the nature of the underlying hash table.  </p>
 */
public class Phonebook {

    private HashTable<String, String> namesToNumbers;
    private HashTable<String, String> numbersToNames;


    public String getNumberOf(String name){
            return namesToNumbers.get(name);
    }

    public String getOwnerOf(String number){
        return numbersToNames.get(number);
    }

    public void addEntry(String name, String number){
        namesToNumbers.put(name, number);
        numbersToNames.put(name, number);
    }

    public void replaceNumberOf(String name, String number){
        String oldNumber = namesToNumbers.get(name);
        namesToNumbers.put(name, number);
        numbersToNames.remove(oldNumber); // To ensure data consistency
        numbersToNames.put(number, name);
    }

    public void replaceOwnerOf(String number, String name){
        String oldOwner = numbersToNames.get(number);
        numbersToNames.put(number, name);
        namesToNumbers.remove(oldOwner); //
    }

    public void deleteEntry(String number, String name){
        namesToNumbers.remove(name);
        numbersToNames.remove(number);
    }

    public void deleteNumberOf(String name){
        String number = namesToNumbers.remove(name);
        numbersToNames.remove(number);
    }

    public void deleteOwnerOf(String number){
        String name = numbersToNames.remove(number);
        namesToNumbers.remove(name);
    }

    public int getCount(){
        assert namesToNumbers.size() == numbersToNames.size() :
                "Mismatch in internal hash counts. Names->Numbers has count: " +
                        namesToNumbers.size() + ", while Numbers->Names has count:  " +
                        numbersToNames.size() + ".";
        return namesToNumbers.size();
    }

    public boolean isEmpty(){
        return getCount() == 0;
    }

}
