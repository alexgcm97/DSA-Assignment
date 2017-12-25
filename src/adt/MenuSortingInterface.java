/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import domain.Affiliate;
import domain.Menu;

/**
 *
 * @author Julian
 */
public interface MenuSortingInterface {

    public void bubble_sortAvailability(AffiliateADT<Menu> list);

    public void bubble_sortPrice(AffiliateADT<Menu> list);

    public void swap(int index, int nextIndex, AffiliateADT<Menu> list);
}
