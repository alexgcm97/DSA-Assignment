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

    void bubble_srt(StaffADT<Staff> list, String type);

    void swap(int i, int j, StaffADT<Staff> list);

}
