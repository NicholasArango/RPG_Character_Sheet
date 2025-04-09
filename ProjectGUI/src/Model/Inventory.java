package Model;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J., Ellie R.
 */


import java.io.Serializable;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Inventory implements Serializable {

    private static final long serialVersionUID = 1L;
    private final List<Item> items;

    public Inventory() {
        
         this.items = new ArrayList<>();
    }
       
        
        public void addItem(Item newItem) {
        Objects.requireNonNull(newItem, "Cannot add null item to inventory");


       
        items.add(new Item(
                newItem.getItemName(),
                newItem.getItemDesc(),
                newItem.getItemWeight(),
                newItem.getQuantity()
        ));
    }
        
         public void removeItem(Item itemToRemove, int quantityToRemove) {
        if (quantityToRemove < 1) {
            throw new IllegalArgumentException("Cannot remove negative items");
        }

        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item existingItem = iterator.next();
            if ((existingItem.equals(itemToRemove))) {
                if (existingItem.getQuantity() < quantityToRemove) {
                    existingItem.setQuantity(0);
                }

                int newQuantity = existingItem.getQuantity() - quantityToRemove;
                if (newQuantity > 0) {
                    existingItem.setQuantity(newQuantity);
                } else {
                    iterator.remove();
                }
                return;
            }
        }
        throw new IllegalArgumentException("Item not found");
    }
    }

