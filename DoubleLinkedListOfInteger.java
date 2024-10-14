/**
 * CLASSE DoubleLinkedListOfInteger
 * Trabalhando com estruturas lineares em formato de listas duplamente encadeadas
 * */

public class DoubleLinkedListOfInteger {

    private Node header;
    Node trailer;
    private Node current;
    int count;
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
        Node novoNode = new Node(value);


        if (count == 0 || position == 0) {
            novoNode.next = header.next;
            novoNode.prev = header;
            header.next.prev = novoNode;
            header.next = novoNode;

        } else if (position >= count) {
            novoNode.prev = trailer.prev;
            novoNode.next = trailer;
            trailer.prev.next = novoNode;
            trailer.prev = novoNode;

        } else {
            Node current = header.next;
            for (int i = 0; i < position; i++) {
                current = current.next;
            }
            novoNode.next = current;
            novoNode.prev = current.prev;
            current.prev.next = novoNode;
            current.prev = novoNode;
        }
        count++;
    }

    public void printFinalSequence() {
        int[] sequencia = {60, 10, 70, 20, 40, 80, 100, 50, 90, 30};
        for (int value : sequencia) {
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
    /**
     * MÉTODO 7: removeLowerThan
     *
     * Remove da lista todos os elementos cujo valor seja menor que o valor especificado.
     * Este método modifica a lista atual, eliminando os elementos que atendem ao critério.
     * Limpar da lista todos os valores que não atendem a um critério mínimo.
     *
     * @param value valor de referência; elementos menores que este valor serão removidos
     * @return void
     */
    public void removeLowerThan(int value) {
        Node current = header.next;

        while (current != trailer) {
            if (current.element < value) {
                current.prev.next = current.next;
                current.next.prev = current.prev;

                count--;
            }
            current = current.next;
        }
    }


}


