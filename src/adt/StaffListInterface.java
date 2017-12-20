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
public interface StaffListInterface<T> {
    void add(T newEntry);
    boolean remove(T anEntry);
    boolean contains(T anEntry);
    int getSize();
    boolean isEmpty();
    String toStringReverse();
}
