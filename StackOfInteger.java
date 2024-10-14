public class StackOfInteger {
    private DoubleLinkedListOfInteger list;

    public StackOfInteger() {
        this.list = new DoubleLinkedListOfInteger();
    }

    public void push(int value) {
        list.add(value);

    }

    public Integer pop() {
        if (list.isEmpty()) {
            return null;
        }
        return list.removeLast();
    }

    public Integer top() {
        if (list.isEmpty()) {
            return null;
        }
        return list.getLast();
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
