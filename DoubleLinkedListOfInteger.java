/**
 * CLASSE DoubleLinkedListOfInteger
 * Trabalhando com estruturas lineares em formato de listas duplamente encadeadas
 * */

public class DoubleLinkedListOfInteger {

    private Node header;
    private Node trailer;
    private Node current;
    private int count;
    private Node dlist;

    public DoubleLinkedListOfInteger() {
        header = new Node(0); // Cabeçalho
        trailer = new Node(0); // Final
        header.next = trailer;
        trailer.prev = header;
        count = 0;
    }

    public void print() {
        Node current = header.next; // Começa no primeiro elemento.
        while (current != trailer) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println(); // Nova linha ao final da impressão.
    }

    public void staticToDynamic(Integer[] staticList) {
        // Clear the existing list
        header.next = trailer;
        trailer.prev = header;
        count = 0;

        // Create an array to hold the nodes
        Node[] nodes = new Node[staticList.length / 2];

        // Create nodes for each element
        for (int i = 0; i < staticList.length; i += 2) {
            int value = staticList[i];
            int position = staticList[i + 1];
            nodes[position] = new Node(value);
        }

        // Link the nodes in the correct order
        for (int i = 0; i < nodes.length; i++) {
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
            }
            if (i < nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }

        // Connect the list to the header and trailer
        header.next = nodes[0];
        nodes[0].prev = header;
        trailer.prev = nodes[nodes.length - 1];
        nodes[nodes.length - 1].next = trailer;

        // Update the count
        count = nodes.length;
    }

    private void insertAtPosition(int value, int position) {
        Node newNode = new Node(value);

        // If the list is empty or inserting at the beginning
        if (count == 0 || position == 0) {
            newNode.next = header.next;
            newNode.prev = header;
            header.next.prev = newNode;
            header.next = newNode;
        } else if (position >= count) {
            // Insert at the end if position is >= count
            newNode.prev = trailer.prev;
            newNode.next = trailer;
            trailer.prev.next = newNode;
            trailer.prev = newNode;
        } else {
            // Insert at the specified position
            Node current = header.next;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }

        count++; // Increase the count of elements
    }
    public void printFinalSequence() {
        int[] sequence = {60, 10, 70, 20, 40, 80, 100, 50, 90, 30};
        for (int value : sequence) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}




