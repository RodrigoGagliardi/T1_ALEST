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

    public void add(Integer element) {
        // Primeiro cria o nodo
        Node n = new Node(element);
        // Conecta o nodo criado na lista
        n.prev = trailer.prev;
        n.next = trailer;
        // Atualiza os encadeamentos
        trailer.prev.next = n;
        trailer.prev = n;
        // Atualiza count
        count++;
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

    //aaaaaaaaa

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

    public void mergeList(DoubleLinkedListOfInteger list2) {

        list2.add(70);
        list2.add(30);
        list2.add(20);
        list2.add(50);
        list2.add(60);
        list2.add(80);
        list2.add(10);
        list2.add(100);
        list2.add(90);
        list2.add(40);

        Node ultimo = this.trailer.prev;
        Node primeiroList2 = list2.header.next;

        ultimo.next = primeiroList2;
        primeiroList2.prev = ultimo;

        this.trailer.prev = list2.trailer.prev;
        list2.trailer.prev.next = this.trailer;

        this.count += list2.count;
    }
}