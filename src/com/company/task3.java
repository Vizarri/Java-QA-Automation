  
package com.company;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList(Arrays.asList("Oleg", "Dima", "Masha", "Mira", "Olga","Ignat"));
        Collection<String> list2 = new ArrayList(Arrays.asList("Oleg", "Mira", "Olga"));

        list.removeAll(list2);
        System.out.println("different " + list);
    }
}
