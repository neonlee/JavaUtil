package LinkedListSimple;

public class NewMain {

    public static void main(String[] args) {
        LinkedList<String> instance = new LinkedList<>();
        String nome1 = "Ana";
        String nome2 = "Maria";
        String nome3 = "Claudia";
        String nome4 = "Lucia";
        instance.add(nome4);
        instance.add(nome1);
        instance.add(nome2);
        instance.add(nome3);
        
       // instance.add(2, "Mariana");

        /*for (int i = 0; i < instance.size(); i++) {
            System.out.println(instance.get(i));
        }*/
        instance.remove(nome2);
        for (String string : instance) {
            System.out.println(string);
        }
    }

}
