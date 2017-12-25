/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import domain.Menu;

/**
 *
 * @author Julian
 */
public class AffiliateADT<T extends Comparable<? super T>> implements AffiliateInterface<T> {

    private Node firstNode, lastNode;

    @Override
    public void add(T newEntry) {
        //        int i = 0;
        //        while (i < getSize() && newEntry.compareTo(list[i]) > 0) {
        //            i++;
        //        }
        Node newNode = new Node(newEntry);
        int i = 0;
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            while (i < getSize() && newNode.data.compareTo(getPositionData(i)) > 0) {
                i++;
            }
            addPosition(newEntry, i);
        }
    }

    @Override
    public String toString() {
        String str = "";
        Node temp = firstNode;
        while (temp != null) {
            str += temp.data + " ";
            temp = temp.next;
        }
        return str;
    }

    @Override
    public T remove(int index) {
        T result = null;

        if (getSize() > index) {
            Node temp = getNodeAt(index);
            result = getPositionData(index);
            
          

            if (temp == firstNode) {
                firstNode = firstNode.next;
                if (firstNode == null) {
                    lastNode = null;
                } else {
                    firstNode.previous = null;
                }
            } else if (temp == lastNode) {
                lastNode = lastNode.previous;
                if (lastNode == null) {
                    firstNode = null;
                } else {
                    lastNode.next = null;
                }
            } else {
                temp.previous.next = temp.next;
                temp.next.previous = temp.previous;
            }
        }

        return result;
    }

    @Override
    public T getData() {
        return getPositionData(0);
    }

    @Override
    public boolean contains(T anEntry) {
        if (!isEmpty()) {
            Node temp = firstNode;

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
        int i = 0;
        Node temp = firstNode;

        while (temp != null) {
            i++;
            temp = temp.next;
        }

        return i;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    @Override
    public void addPosition(T newEntry, int index) {//newEntry = 6, index = 2
        Node newNode = new Node(newEntry);//0>1>6>2>3>4>5 (6)
        if (getSize() > index) {
            Node temp = getNodeAt(index);
            
            if (index == 0) {
                firstNode = newNode;
            }
            else{
                temp.previous.next = newNode;
            }
            
            //temp = 2 , 2 infront 1, 2 back 3 >> 2 infront 6
            //newNode = 6, 6 infront 1, 6 back 2
            newNode.previous = temp.previous;
            newNode.next = temp;
            temp.previous = newNode;
            
            
        }
        else if(getSize() == index){ // 0 , 1 , 2, 3 > 4 2 > 4
            newNode.previous = lastNode;
            newNode.next = null;
            //lastNode.previous.next = newNode;
            lastNode.next = newNode;
            lastNode = newNode;
        }

    }

    @Override
    public T getPositionData(int index) {
        //0
        int i = 0;
        T result = null;

        if (index < getSize())//6
        {
            Node temp = getNodeAt(index);

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

    public Node getNodeAt(int index)
    {
        Node temp = null;
        
        if(getSize() > index)
        {
            temp = firstNode;
            
            for(int i = 0; i < index; i++)
            {
                temp = temp.next;
            }
        }
        
        return temp;
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
