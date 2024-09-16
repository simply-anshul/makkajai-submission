package com.anshul.sales.calculator.model;

public class Item {
    private String itemName;
    private Integer quantity;
    private Double price;
    private Boolean isNonImportExemptedItem;
    private Boolean isImported;

    public Item(String itemName,
                Integer quantity,
                Double price,
                Boolean isNonImportExemptedItem,
                Boolean isImported) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
        this.isNonImportExemptedItem = isNonImportExemptedItem;
        this.isImported = isImported;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getIsNonImportExemptedItem() {
        return isNonImportExemptedItem;
    }

    public void setIsNonImportExemptedItem(Boolean nonImportExemptedItem) {
        isNonImportExemptedItem = nonImportExemptedItem;
    }

    public Boolean getIsImported() {
        return isImported;
    }

    public void setIsImported(Boolean imported) {
        isImported = imported;
    }

    @Override
    public String toString() {
        return "Item{" +
                "itemName='" + itemName + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", isNonImportExemptedItem=" + isNonImportExemptedItem +
                ", isImported=" + isImported +
                '}';
    }

}
