/**
 *
 * When running be sure to enable assertions so that the tests are verified.
 * i.e. java -ea BasicSupermarket
 *
 */
public class BasicSupermarket {

    public static void main(String[] args) {

        new BasicSupermarket().basicSupermarketRunner();

    }

    private void basicSupermarketRunner() {

        PersonQueue queue = new BasicSupermarketQueue();

        // Make some people
        Person firstPerson = getPerson();
        Person secondPerson = getPerson();
        Person thirdPerson = getPerson();
        Person personFromQueue;

        // Test adding and retrieving a Person
        queue.insert(firstPerson);

        // Check the queue size is 1
        int size = queue.size();
        assert size == 1;

        // Ensure the person retrieved is the same as the person added
        personFromQueue = queue.retrieve();
        assert personFromQueue == firstPerson;

        // Ensure next retrieve gives us a null Person
        personFromQueue = queue.retrieve();
        assert personFromQueue == null;

        // Check the queue size is 0
        size = queue.size();
        assert size == 0;

        // Add three people and ensure we get them back in the correct order
        queue.insert(firstPerson);
        queue.insert(secondPerson);
        queue.insert(thirdPerson);

        // Check the queue size is 3
        size = queue.size();
        assert size == 3;

        personFromQueue = queue.retrieve();
        assert personFromQueue == firstPerson;

        personFromQueue = queue.retrieve();
        assert personFromQueue == secondPerson;

        personFromQueue = queue.retrieve();
        assert personFromQueue == thirdPerson;

        personFromQueue = queue.retrieve();
        assert personFromQueue == null;

        // Check the queue size is 0
        size = queue.size();
        assert size == 0;
    }

    /**
     *
     * Ignore this for he time being as we haven't covered anonymous classes yet
     * Suffice to say this creates the simplest possible Person for testing
     *
     */
    private Person getPerson() {

        return new Person() {

            @Override
            public void move(int distance) {
                // Go nowhere
            }

            @Override
            public void say(String message) {
                // Say nothing
            }
        };
    }
}
