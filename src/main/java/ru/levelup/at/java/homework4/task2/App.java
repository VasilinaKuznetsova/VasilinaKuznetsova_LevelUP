package ru.levelup.at.java.homework4.task2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        App collectionsApp = new App();
        collectionsApp.start();
    }

    public void start() {
        ArrayList<Integer> sortedList = new ArrayList();

        for (int i = 0; i < 100000; i++) {
            sortedList.add(i);
        }

        System.out.println("Sorted List (for example 100 items):");
        for (int i = 0; i < 100; i++) {
            System.out.print(sortedList.get(i) + " ");
        }
        System.out.println();

        ArrayList<Integer> unsortedList = new ArrayList(sortedList);
        Collections.shuffle(unsortedList);

        System.out.println();
        System.out.println("Unsorted List (for example 100 items):");
        for (int i = 0; i < 100; i++) {
            System.out.print(unsortedList.get(i) + " ");
        }
        System.out.println();

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < unsortedList.size(); i++) {
            set.add(unsortedList.get(i));
        }

        System.out.println();
        System.out.println("All elements of the Unsorted List are unique: "
            + (unsortedList.size() == set.size()));

        Map<Integer, ArrayList<Integer>> divSortedList = new HashMap<>();
        ArrayList<Integer> list2 = new ArrayList();
        ArrayList<Integer> list3 = new ArrayList();
        ArrayList<Integer> list5 = new ArrayList();
        ArrayList<Integer> list7 = new ArrayList();
        for (Integer integer : unsortedList) {
            if (integer % 2 == 0) {
                list2.add(integer);
            } else if (integer % 3 == 0) {
                list3.add(integer);
            } else if (integer % 5 == 0) {
                list5.add(integer);
            } else if (integer % 7 == 0) {
                list7.add(integer);
            }
        }

        divSortedList.put(2, list2);
        divSortedList.put(3, list3);
        divSortedList.put(5, list5);
        divSortedList.put(7, list7);

        System.out.println();
        System.out.println("Group Unsorted List by dividers:");
        System.out.println("Divider 2:");
        System.out.println(divSortedList.get(2));
        System.out.println("Divider 3:");
        System.out.println(divSortedList.get(3));
        System.out.println("Divider 5:");
        System.out.println(divSortedList.get(5));
        System.out.println("Divider 7:");
        System.out.println(divSortedList.get(7));

    }
}
