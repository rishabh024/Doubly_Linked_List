package DoubleLinkedListADT;

public interface DoublyLinkedListInterface<E> {
    void insertNode(E data);
    E removeNodeFromLastPos();
    int searchData(E data);
    void printList();

}
