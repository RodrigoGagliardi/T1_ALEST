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
        Node current = header.next;
        while (current != trailer) {
            System.out.print(current.element + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void staticToDynamic(Integer[] staticList) {
        for (int i = 0; i < staticList.length; i += 2) {
            int value = staticList[i];     // O primeiro valor
            int position = staticList[i + 1];  // O segundo valor, que é a posição
            insertAtPosition(value, position);
        }
    }

    private void insertAtPosition(int value, int position) {
        Node newNode = new Node(value);

        // Caso a posição seja zero, inserimos logo após o header
        if (position == 0) {
            newNode.next = header.next;
            newNode.prev = header;
            header.next.prev = newNode;
            header.next = newNode;
        } else {
            Node current = header.next; // Começa após o cabeçalho
            int index = 0;

            // Avança até a posição correta ou até o final da lista
            while (current != trailer && index < position) {
                current = current.next;
                index++;
            }

            // Caso seja trailer (fim da lista), insere no final
            if (current == trailer) {
                newNode.prev = trailer.prev;
                trailer.prev.next = newNode;
                newNode.next = trailer;
                trailer.prev = newNode;
            } else {
                // Insere o novo nó antes da posição atual
                newNode.next = current;
                newNode.prev = current.prev;
                current.prev.next = newNode;
                current.prev = newNode;
            }
        }

        // Atualiza o contador de elementos
        count++;
    }



    public void printFinalSequence() {
        int[] sequence = {60, 10, 70, 20, 40, 80, 100, 50, 90, 30};
        for (int value : sequence) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
