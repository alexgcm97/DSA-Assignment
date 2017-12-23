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

    //Add newEntry to the end of the list.
    void add(T newEntry);

    //Get the element by specifying the position index of the element in the list.  
    T get(int index);

    //Remove anEntry from the list, return true if removed, false otherwise.
    boolean remove(T anEntry);

    //Check if list contains anEntry, return true if found, false otherwise.
    boolean contains(T anEntry);

    //Get the number of entries in the list.
    int getSize();

    //Determines whether the list is empty, return true if empty, false otherwise.
    boolean isEmpty();
    
    //Set anEntry to the specified index.
    void set(int index, T anEntry);
    
}
