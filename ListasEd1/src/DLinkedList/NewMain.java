/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DLinkedList;

import java.util.LinkedList;

/**
 *
 * @author ander
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        NodePositionList<String> instance = new NodePositionList<>();
        String nome1 = "Ana";
        String nome2 = "Maria";
        String nome3 = "Claudia";
        String nome4 = "Lucia";

        instance.add(nome1);
        instance.add(nome2);
        instance.add(nome3);
        instance.add(nome4);
        instance.add(1, "Mariana");

        Position<String> p = instance.first();
        instance.addAfter(p, "Hank");
        
        for (int i = 0; i < instance.size(); i++) {
            System.out.println(instance.get(i));
        }
        
        instance.remove(nome3);

        System.out.println("");
        for (String string : instance) {
            System.out.println(string);
        }
    }

}
