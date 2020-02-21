package Execution;

import LinkedListDefinition.DoubleLinkedList;

public class MainClass {
    public static void main(String[] args) {

        DoubleLinkedList<Integer> dl = new DoubleLinkedList<>();
        dl.insertNode(3);
        dl.printList();
        dl.insertNode(7);
        dl.printList();
        dl.insertNode(6);
        dl.printList();
        dl.insertNode(4);
        dl.printList();
        int a=dl.searchData(4);
        if(a!=-1)
            System.out.println("ur data exists");
        else
            System.out.println("ur data does not exists");
        dl.removeNodeFromLastPos();
        dl.printList();
    }
}

