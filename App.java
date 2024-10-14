public class App {
    public static void main(String[] args) {
 /*       Integer[] staticList = {70, 2, 30, 9, 20, 3, 50, 7, 60, 0, 80, 5, 10, 1, 100, 6, 90, 8, 40, 4};
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
        StackOfInteger stack = new StackOfInteger();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Topo da pilha: " + stack.top());

        System.out.println("Elemento removido: " + stack.pop());

        System.out.println("Novo topo da pilha: " + stack.top());

    }
}