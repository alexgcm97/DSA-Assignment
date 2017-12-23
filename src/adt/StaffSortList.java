/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Toolist | Templates
 * and open the template in the editor.
 */
package adt;

import domain.Staff;

public class StaffSortList<T> implements StaffSortInterface<T> {

    @Override
    public void bubble_sort(StaffADT<Staff> list, String type) {
        int size = list.getSize();
        int nextIndex;
        //For loop to loop through the whole linked list
        for (int m = size; m >= 0; m--) {
            for (int i = 0; i < size - 1; i++) {
                nextIndex = i + 1;
                //Sorting for report type of total deliveries completed
                if (type.equals("Delivery")) {
                    //Compare current entry with next entry, if next entry having higher value, swap position.
                    if (list.get(i).getNoOfDoneDelivery() < list.get(nextIndex).getNoOfDoneDelivery()) {
                        swap(i, nextIndex, (StaffADT<Staff>) list);
                    }
                    //Sorting for report type of total distance travelled
                } else if (type.equals("Distance")) {
                    //Compare current entry with next entry, if next entry having higher value, swap position.
                    if (list.get(i).getTotalDistance() < list.get(nextIndex).getTotalDistance()) {
                        swap(i, nextIndex, (StaffADT<Staff>) list);
                    }
                }
            }
        }
    }

    public void swap(int index, int nextIndex, StaffADT<Staff> list) {
        //Store the current entry with a temporary object
        Staff temp = list.get(index);
        //Set the current position index with next entry
        list.set(index, list.get(nextIndex));
        //Set the next position index with the stored temporary current entry
        list.set(nextIndex, temp);
    }
}
