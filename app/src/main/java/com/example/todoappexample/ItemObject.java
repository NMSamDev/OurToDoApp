package com.example.todoappexample;

import java.util.Objects;

/**
 * POJO -> Plain Old Java Objects
 *  Needs
 *      Getters
 *      Setters
 *      equals
 *      hashCode
 *      toString
 */
public class ItemObject {
    private String itemName;
    private int itemId;
    private double itemPrice;

    public ItemObject(){}

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemObject that = (ItemObject) o;
        return itemId == that.itemId && Double.compare(that.itemPrice, itemPrice) == 0 && Objects.equals(itemName, that.itemName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(itemName, itemId, itemPrice);
    }

    @Override
    public String toString() {
        return "ItemObject{" +
                "itemName='" + itemName + '\'' +
                ", itemId=" + itemId +
                ", itemPrice=" + itemPrice +
                '}';
    }
}
