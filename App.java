public class App {
    public static void main(String[] args) {

        DoubleLinkedListOfInteger dlist = new DoubleLinkedListOfInteger();

        Integer [] Lista = new Integer [] {70,2,30,9,20,3,50,7,60,0,80,5,10,1,100,6,90,8,40,4};

        dlist.staticToDynamic(Lista);

        System.out.println(Lista);
    }
}
