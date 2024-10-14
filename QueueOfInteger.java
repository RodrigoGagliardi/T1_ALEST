public class QueueOfInteger {

    private DoubleLinkedListOfInteger list;

    public QueueOfInteger() {
        this.list = new DoubleLinkedListOfInteger();
    }

    /**
     * Retorna o elemento que está no início da fila sem removê-lo.
     * @return Integer o valor do elemento no início da fila.
     */
    public Integer head() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getFirst();
    }

    public Integer dequeue() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeFirst();
    }

    public void enqueue(Integer value) {
        list.add(value);
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
