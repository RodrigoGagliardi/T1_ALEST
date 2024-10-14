public class App {
    public static void main(String[] args) {
        // Lista de arranjo estática com valores e posições
        Integer[] staticList = {
                70, 2, 30, 9, 20, 3, 50, 7, 60, 0,
                80, 5, 10, 1, 100, 6, 90, 8, 40, 4
        };

        DoubleLinkedListOfInteger dynamicList = new DoubleLinkedListOfInteger();
        dynamicList.staticToDynamic(staticList); // Converte para lista duplamente encadeada
        dynamicList.print(); // Deve exibir: 60 10 70 20 40 80 100 50 90 30
        dynamicList.printFinalSequence();
    }
}