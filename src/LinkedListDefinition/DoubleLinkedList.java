package LinkedListDefinition;

import DoubleLinkedListADT.DoublyLinkedListInterface;


public class DoubleLinkedList<E> implements DoublyLinkedListInterface<E> {

    private Node<E> head = null;
    private Node<E> tail = null;
    int size =0;


    private void insertAtFirstPos(E data) {
        Node<E> n;
        if (head == null) {
            n = new Node(head, null, data);
            head = n;
            tail = n;
        }
        else {
            n = new Node(head, null, data);
            head = n;
            head.previous = n;
            tail = n;
        }
        size++;
    }

    private void insertAfterThisNode(Node<E> n, E data){
        Node<E> nextNode = n.getNext();
        if(n==null){
            Node newNode = new Node(null,n,data);
            n.next = newNode;
            tail=newNode;
        }
        else{
            Node<E> n1=new Node(n.getNext(), n,data);
            n.next = n1;
            n.next.previous=n1;
        }
        size++;

    }


    private Node<E> getNode(int index){
        Node<E> response = head;
        for(int i =0;i<index && response != null;i++){
            response=response.getNext();
        }
        return response;
    }


    private  void insertNodeAtPosition(E data,int index){
        if(index < 0 || index >  size){
            throw new IndexOutOfBoundsException(Integer.toString(index));
        }
        else if (index == 0){
            insertAtFirstPos(data);
        }
        else{
            insertAfterThisNode (getNode(index-1),data);
        }
    }

    private E removeFirstNode(){
        E response;
        Node<E> temp = head;
        if(head.getNext()==null){
            head=null;
            size--;
            response=null;
            return response;
        }
        else {
            head=head.next;
            response=temp.getData();

            head.previous=null;
            size--;
            return response;
        }
    }

    private E removeNodeAfterThisNode(Node<E> node){
        E response = null;
        Node<E> temp =node.getNext();
        response = temp.getData();
        node.next=null;
        temp.previous=null;
        return response;

    }


    private E removeNode(int index) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException(Integer.toString(index));
        else if (index == 0)
            return removeFirstNode();
        else {
            Node<E> n = getNode(index - 1);
            return removeNodeAfterThisNode(n);
        }
    }

    @Override
    public void insertNode(E data) {
        insertNodeAtPosition(data, size);
    }

    @Override
    public E removeNodeFromLastPos() {
        return removeNode(size-1);
    }


    @Override
    public int searchData(E data) {
        int response =-1;
        int index = 0;
        for(Node<E> n =head; n!=null; n=n.getNext()){
            if(n.getData() == data){
                index++;
                response =index;
                break;
            }
        }
        return response;
    }

    @Override
    public void printList() {
        System.out.print("[");
        for(Node d = head;d!=null;d=d.getNext()){
            System.out.print(d.getData()+", ");
        }
        System.out.println("]");
    }




    private static class Node<E> {
        private Node<E> next = null;
        private Node<E> previous =null;
        private E data;

        Node(E data){
            this.next=null;
            this.previous=null;
            this.data=data;
        }

        Node(Node<E> next, Node<E> previous, E data){
            this.next=next;
            this.previous=previous;
            this.data=data;
        }

        private Node<E> getNext(){
            return next;
        }

        private Node<E> getPrevious(){
            return previous;
        }

        private E getData(){
            return data;
        }
    }
}
