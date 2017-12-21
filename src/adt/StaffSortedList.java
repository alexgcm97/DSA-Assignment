/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Toolist | Templates
 * and open the template in the editor.
 */
package adt;

import domain.Staff;

public class StaffSortedList<T> implements StaffSortInterface<T> {

    @Override
    public void bubble_srt(StaffADT<Staff> list, String type) {
        int size = list.getSize();
        int nextIndex;
        System.out.println("Test");
        for (int m = size; m >= 0; m--) {
            for (int i = 0; i < size - 1; i++) {
                nextIndex = i + 1;
                if (type.equals("Delivery")) {
                    if (list.get(i).getNoOfDoneDelivery() < list.get(nextIndex).getNoOfDoneDelivery()) {
                        swap(i, nextIndex, (StaffADT<Staff>) list);
                    }
                } else if (type.equals("Distance")) {
                    if (list.get(i).getTotalDistance() < list.get(nextIndex).getTotalDistance()) {
                        swap(i, nextIndex, (StaffADT<Staff>) list);
                    }
                }
            }
        }
    }

    public void swap(int index, int nextIndex, StaffADT<Staff> list) {
        Staff temp = list.get(index);
        list.set(index, list.get(nextIndex));
        list.set(nextIndex, temp);
    }
}
