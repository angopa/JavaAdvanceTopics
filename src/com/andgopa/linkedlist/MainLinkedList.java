package com.andgopa.linkedlist;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

//      Created by Andres Gonzalez 10/30/17
public class MainLinkedList {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Los Angeles");
        addInOrder(placesToVisit, "Detroit");
        addInOrder(placesToVisit, "Atlanta");
        addInOrder(placesToVisit, "Houston");
        addInOrder(placesToVisit, "Toronto");
        printList(placesToVisit);
        visit(placesToVisit);
    }

    private static void printList(LinkedList<String> placesToVisit) {
        Iterator<String> i = placesToVisit.iterator();
        while(i.hasNext()) {
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("=================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while(stringListIterator.hasNext()) {
            int comparation = stringListIterator.next().compareTo(newCity);
            if (comparation == 0) {
                // equal, do not add
                System.out.println(newCity + "is already inserted into the list");
                return false;
            } else if(comparation > 0) {
                //new city should appear before this one
                //
                stringListIterator.previous();
                stringListIterator.add(newCity);
                return true;
            } else if (comparation < 0){

            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        ListIterator<String> listIterator = cities.listIterator();
        boolean goingForward = true;
        if (cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("now visiting " + listIterator.next());
            printMenu();
        }

        while(!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday vacations over");
                    quit  = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext()) {
                            listIterator.next();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visiting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list ");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now visiting " + listIterator.previous());
                    } else {
                        System.out.println("We are at the start of the list ");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available options: \npress");
        System.out.println("0 - to quit\n" +
        "1 - Visit next place \n" +
        "2 - visit previous city ");

    }
}
