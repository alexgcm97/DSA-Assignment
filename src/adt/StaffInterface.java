/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Student
 */
public interface StaffInterface<T> {

    void add(T newEntry);

    T get(int index);

    boolean remove(T anEntry);

    boolean contains(T anEntry);

    int getSize();

    boolean isEmpty();
    
    void set(int index, T anEntry);
    
}
