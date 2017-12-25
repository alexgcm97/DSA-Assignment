/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import domain.Affiliate;
import adt.AffiliateADT;
import domain.Menu;

/**
 *
 * @author Julian
 */
public class MenuSortingADT implements MenuSortingInterface {

    @Override
    public void bubble_sortAvailability(AffiliateADT<Menu> list) {
        int size = list.getSize();
        int nextIndex;
        for (int m = size; m >= 0; m--) {
            for (int i = 0; i < size - 1; i++) {
                nextIndex = i + 1;
                if (list.getData().getStock().compareTo(list.getPositionData(nextIndex).getStock()) <= 0) {
                    swap(i, nextIndex, (AffiliateADT<Menu>) list);
                }
            }
        }
    }

    @Override
    public void bubble_sortPrice(AffiliateADT<Menu> list) {
        int size = list.getSize();
        int nextIndex;
        for (int m = size; m >= 0; m--) {
            for (int i = 0; i < size - 1; i++) {
                nextIndex = i + 1;
                if (list.getData().getPrice() < list.getPositionData(nextIndex).getPrice()) {
                    swap(i, nextIndex, (AffiliateADT<Menu>) list);
                }
            }
        }
    }

    @Override
    public void swap(int index, int nextIndex, AffiliateADT<Menu> list) {
        Menu temp = list.getPositionData(index);
        list.set(index, list.getPositionData(nextIndex));
        list.set(nextIndex, temp);
    }

}
