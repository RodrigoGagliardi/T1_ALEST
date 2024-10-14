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
        Node n = new Node(element);
        n.prev = trailer.prev;
        n.next = trailer;
        trailer.prev.next = n;
        trailer.prev = n;
        count++;
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
        header.next = trailer;
        trailer.prev = header;
        count = 0;

        Node[] nodes = new Node[staticList.length / 2];

        for (int i = 0; i < staticList.length; i += 2) {
            int value = staticList[i];
            int position = staticList[i + 1];
            nodes[position] = new Node(value);
        }

        for (int i = 0; i < nodes.length; i++) {
            if (i > 0) {
                nodes[i].prev = nodes[i - 1];
            }
            if (i < nodes.length - 1) {
                nodes[i].next = nodes[i + 1];
            }
        }
        header.next = nodes[0];
        nodes[0].prev = header;
        trailer.prev = nodes[nodes.length - 1];
        nodes[nodes.length - 1].next = trailer;

        count = nodes.length;
    }

    private void insertAtPosition(int value, int position) {
        Node newNode = new Node(value);


        if (count == 0 || position == 0) {
            newNode.next = header.next;
            newNode.prev = header;
            header.next.prev = newNode;
            header.next = newNode;

        } else if (position >= count) {
            newNode.prev = trailer.prev;
            newNode.next = trailer;
            trailer.prev.next = newNode;
            trailer.prev = newNode;

        } else {
            Node current = header.next;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            newNode.next = current;
            newNode.prev = current.prev;
            current.prev.next = newNode;
            current.prev = newNode;
        }
        count++;
    }

    public void printFinalSequence() {
        int[] sequence = {60, 10, 70, 20, 40, 80, 100, 50, 90, 30};
        for (int value : sequence) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    /**
     * MÉTODO 3: mergeLists
     *
     * Mescla a lista fornecida como parâmetro ao final da lista atual, unindo os elementos das duas listas.
     * Após a execução, a lista atual conterá todos os elementos de ambas as listas na ordem original.
     * Combinar dois conjuntos de dados sequenciais em uma única sequência contínua.
     *
     * @param list2 a lista do tipo DoubleLinkedListOfInteger que será mesclada à lista atual
     * @return void
     */
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
    /**
     * MÉTODO 5: removeRange
     *
     * Remove os elementos da lista desde a posição start (inclusiva) até a posição stop (exclusiva).
     * Os elementos entre essas posições serão removidos da lista atual. Remover um subconjunto de elementos da lista com base em suas posições.
     *
     * @param start posição inicial (inclusiva) da remoção
     * @param stop posição final (exclusiva) da remoção
     * @return void
     */
    public void removeRange(int start, int stop) {
        if (start >= stop || start < 0 || stop > count) {
            return;
        }

        Node current = header.next;
        int index = 0;

        while (current != trailer && index < start) {
            current = current.next;
            index++;
        }

        Node startNode = current;

        while (current != trailer && index < stop) {
            current = current.next;
            index++;
        }

        startNode.prev.next = current;
        current.prev = startNode.prev;
        count -= (stop - start);
    }
}


