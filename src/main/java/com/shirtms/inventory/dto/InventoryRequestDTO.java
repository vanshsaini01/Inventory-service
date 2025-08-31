package com.shirtms.inventory.dto;

public class InventoryRequestDTO {

    private String itemName;
    private String productType;
    private int quantity;

    public InventoryRequestDTO() {
    }

    public InventoryRequestDTO(String itemName, String productType, int quantity) {
        this.itemName = itemName;
        this.productType = productType;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
