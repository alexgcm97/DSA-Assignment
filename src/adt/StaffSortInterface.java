/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import domain.Staff;

/**
 *
 * @author Alex
 */
public interface StaffSortInterface<T> {

    /*Do sorting for the linked list, by passing in the linked list 
      &sort according to what type of report.
    */
    void bubble_sort(StaffADT<Staff> list, String type);

    /*Do the swapping of position between the current entry and next entry
      in the linked list.
    */
    void swap(int index, int nextIndex, StaffADT<Staff> list);

}
