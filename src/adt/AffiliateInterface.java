/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

/**
 *
 * @author Julian
 */
public interface AffiliateInterface<T> {
    public void add(T newEntry);
    
    public void addPosition(T newEntry, int index);

    public T remove(int index);

    public T getData();
    
    public T getPositionData(int index);
    
    public void set(int index, T anEntry);

    public int getSize();

    public boolean contains(T anEntry);

    public boolean isEmpty();
}
