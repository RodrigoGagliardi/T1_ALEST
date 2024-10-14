public class StackOfInteger {
    private DoubleLinkedListOfInteger list;

    public StackOfInteger() {
        this.list = new DoubleLinkedListOfInteger();
    }
    public void push(int value) {
        list.add(value);

    }
    public Integer pop() {
        if (list.count == 0) {
            return null;
        }

        Integer topValue = list.trailer.prev.element;
        list.trailer.prev = list.trailer.prev.prev;
        list.trailer.prev.next = list.trailer;

        list.count--;
        return topValue;
    }

    public Integer top() {
        if (list.count == 0) {
            return null;
        }

        return list.trailer.prev.element;
    }

}
