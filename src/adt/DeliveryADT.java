/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author REPUBLIC
 */
public class DeliveryADT<T> implements DeliveryInterface<T> {

    private Node firstNode, lastNode;
    private int size;

    @Override
    public void add(T newEntry) {
        // Create new node
        Node newNode = new Node(newEntry);
        // Check if list is empty
        if (isEmpty()) {
            // Make firstNode point to the new node
            firstNode = newNode;
        } else {
            //Last node's next point to the new node
            lastNode.next = newNode;
            //New node's previous point to the last node
            newNode.previous = lastNode;
        }
        //Make lastNode point to new node
        lastNode = newNode;
        size++; //Increase size 
    }
    
     @Override
    public boolean remove(T anEntry) {
        if (!isEmpty()) {   //Check if list is empty
            if (firstNode.data.equals(anEntry)) {  
                firstNode = firstNode.next;  //Remove first node
                if (firstNode == null) {
                    lastNode = null;
                } else {
                    firstNode.previous = null;
                }
                size--; 
                return true;
            }
            Node temp = firstNode; //Assign firstNode to temporary node
            while (temp != null && !temp.data.equals(anEntry)) {
                temp = temp.next;
                if (temp != null && temp.data.equals(anEntry)) {
                    if (temp == lastNode) { //remove last node
                        lastNode = temp.previous;
                        lastNode.next = null;
                    } else {    //remove middle node
                        temp.next.previous = temp.previous;
                        temp.previous.next = temp.next;

                    }
                    size--;
                    return true;
                }
            }
        }
        return false;
    }


    @Override
    public boolean contains(T anEntry) {
        //Check if list is empty
        if (!isEmpty()) {
            //Assign firstNode to temporary node
            Node temp = firstNode;
            //while temporary node is not empty
            while (temp != null) {
                if (temp.data.equals(anEntry)) {
                    return true;
                } else {
                    temp = temp.next;
                }
            }
        }
        return false;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public T get(int index) {
        T result = null;
        Node temp = firstNode;
        if (index == 0) {
            result = firstNode.data;
        } else {
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            result = temp.data;
        }
        return result;
    }

   
    @Override
    public void set(int index, T anEntry) {
        Node temp = firstNode;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        temp.data = anEntry;
    }

    private class Node {

        T data;
        Node next, previous;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next, Node previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }
    }


}
