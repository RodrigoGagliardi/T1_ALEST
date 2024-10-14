public class App {
    public static void main(String[] args) {
 /*     Integer[] staticList = {70, 2, 30, 9, 20, 3, 50, 7, 60, 0, 80, 5, 10, 1, 100, 6, 90, 8, 40, 4};
        DoubleLinkedListOfInteger list2 = new DoubleLinkedListOfInteger();

        DoubleLinkedListOfInteger dynamicList = new DoubleLinkedListOfInteger();
        System.out.println("A1: Alocação estática para alocação dinâmica com estruturas lineares");
        dynamicList.staticToDynamic(staticList);
        dynamicList.print();
        System.out.println("-----------------------------------------");
        System.out.println("A2: Implementação de métodos auxiliares:");
        System.out.println("-----------------------------------------");
        System.out.println("MÉTODO 3: mergeLists:");
        dynamicList.mergeList(list2);
        dynamicList.print();
        System.out.println("-----------------------------------------");
        System.out.println("MÉTODO 5: removeRange: 2 até 5");
        dynamicList.removeRange(2, 5);
        dynamicList.print();
        System.out.println("-----------------------------------------");
        System.out.println("MÉTODO 7: removeLowerThan: menores que 50");
        dynamicList.removeLowerThan(50);
        dynamicList.print();

*/        System.out.println("----------------------------------------");
        Integer[] list = {20, 30, 50, 80, 30, 10, 90, 20};
        StackOfInteger s = new StackOfInteger();
        QueueOfInteger q = new QueueOfInteger();

        System.out.println("Inicializando pilha e fila:");
        for (int i = 0; i < 4; i++) {
            s.push(list[i]);
            System.out.println("Empilhado na pilha: " + list[i]);
        }
        for (int i = 4; i < 8; i++) {
            q.enqueue(list[i]);
            System.out.println("Enfileirado na fila: " + list[i]);
        }

        System.out.println("\nTeste inicial:");
        System.out.println("Topo da pilha: " + s.top());
        System.out.println("Frente da fila: " + q.head());

        // Op 1
        int op1Result = s.top() - q.dequeue();
        s.push(op1Result);
        System.out.println("\nApós operação 1 (s.push(s.top() - q.dequeue())):");
        System.out.println("Empilhado na pilha: " + op1Result);
        System.out.println("Topo da pilha: " + s.top());
        System.out.println("Frente da fila: " + q.head());

        // Op 2
        int op2Result = q.dequeue() + s.pop();
        q.enqueue(op2Result);
        System.out.println("\nApós operação 2 (q.enqueue(q.dequeue() + s.pop())):");
        System.out.println("Enfileirado na fila: " + op2Result);
        System.out.println("Topo da pilha: " + s.top());
        System.out.println("Frente da fila: " + q.head());

        // Op 3
        int op3Result = q.head() - s.top();
        q.enqueue(op3Result);
        System.out.println("\nApós operação 3 (q.enqueue(q.head() - s.top())):");
        System.out.println("Enfileirado na fila: " + op3Result);
        System.out.println("Topo da pilha: " + s.top());
        System.out.println("Frente da fila: " + q.head());

        // Op 4
        int op4Result = q.dequeue() - s.top();
        s.push(op4Result);
        System.out.println("\nApós operação 4 (s.push(q.dequeue() - s.top())):");
        System.out.println("Empilhado na pilha: " + op4Result);
        System.out.println("Topo da pilha: " + s.top());
        System.out.println("Frente da fila: " + q.head());
    }
}




