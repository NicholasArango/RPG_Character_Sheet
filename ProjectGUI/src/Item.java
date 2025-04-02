/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Robert J., Ellie R.
 */
import java.lang.String;
import java.io.Serializable;
import java.util.Objects;

public class Item implements Serializable {
    private static final long serialVersionUID = 1L;
    
    // required fields
    private final String itemName;
    private final String itemDesc;
    private final float itemWeight;
    
    // optional fields
    private int quantity;
    private String itemCategory;

    // constructor with validation
    public Item(String itemName, String itemDesc, float itemWeight, int quantity1) {
        this(itemName, itemDesc, itemWeight, 1, "Miscellaneous");
    }

    // default constructor
    public Item(String itemName, String itemDesc, float itemWeight, 
                int quantity, String itemCategory) {
        if (itemWeight < 0) itemWeight = 0;
        if (quantity < 1) quantity = 1;
        
        this.itemName = Objects.requireNonNull(itemName, "Item name cannot be null");
        this.itemDesc = itemDesc;
        this.itemWeight = itemWeight;
        this.quantity = quantity;
        this.itemCategory = itemCategory;
    }

    // getters
    public String getItemName() {
        return itemName;
    }

    public String getItemDesc() {
        return itemDesc;
    }

    public float getItemWeight() {
        return itemWeight;
    }

    public int getQuantity() {
        return quantity;
    }

    // setters
    public void setQuantity(int quantity) {
        if (quantity < 0) quantity = 1;
        this.quantity = quantity;
    }


    // equals check
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return itemName.equals(item.itemName) && 
               itemCategory.equals(item.itemCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemCategory);
    }

    // override toString
    @Override
    public String toString() {
        return "Item{" +
               "name='" + itemName + '\'' +
               ", category='" + itemCategory + '\'' +
               ", weight=" + itemWeight +
               ", quantity=" + quantity +
               '}';
    }

    // Additional useful methods
    public double getTotalWeight() {
        return itemWeight * quantity;
    }

}