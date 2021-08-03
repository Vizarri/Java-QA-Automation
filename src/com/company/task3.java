
package com.company;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class task3 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList(Arrays.asList("Oleg", "Dima", "Masha", "Mira", "Olga", "Ignat"));
        Collection<String> list2 = new ArrayList(Arrays.asList("Oleg", "Mira", "Olga"));

        list.removeAll(list2);
        System.out.println("different " + list);
    }
}
