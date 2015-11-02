public class BasicSupermarketQueue implements PersonQueue {

    private QueuePerson headOfQueue;

    @Override
    public void insert(Person personToInsert) {

        if (headOfQueue == null) {
            headOfQueue = new QueuePerson(personToInsert);            
        } else {
            headOfQueue.addPerson(personToInsert);
        }
    }

    @Override
    public Person retrieve() {

        if (headOfQueue == null) {
            return null;
        }        
        Person personToReturn = headOfQueue.getPerson();
        headOfQueue = headOfQueue.getNextPerson();
        return personToReturn;
    }

    @Override
    public int size() {
        return headOfQueue == null ? 0 : headOfQueue.size();
    }

    class QueuePerson {

        private final Person person;
        //
        private QueuePerson nextPerson;

        public QueuePerson(Person person) {

            this.person = person;
            nextPerson = null;

        }

        public QueuePerson getNextPerson() {
            return nextPerson;
        }

        public void setNextPerson(QueuePerson nextPerson) {
            this.nextPerson = nextPerson;
        }

        public void addPerson(Person personToAdd) {

            if (nextPerson == null) {
                nextPerson = new QueuePerson(personToAdd);
            } else {
                nextPerson.addPerson(personToAdd);
            }
        }

        public Person getPerson() {
            return person;
        }

        public int size() {
            return nextPerson == null ? 1 : nextPerson.size() + 1;
        }
    }
}

