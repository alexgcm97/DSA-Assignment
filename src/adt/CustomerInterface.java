/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author junkit
 */
interface CustomerInterface<T> {

    void add(T newEntry);

    boolean remove(T anEntry);

    T getData(int element);

    int getSize();

    boolean contains(T anEntry);

    boolean isEmpty();

    String toStringReverse();
}
