package com.shirtms.inventory.dto;

public class InventoryRequestDTO {

    private String itemType;
    private String itemName;
    private int quantity;

    public InventoryRequestDTO() {}

    public InventoryRequestDTO(String itemType, String itemName, int quantity) {
        this.itemType = itemType;
        this.itemName = itemName;
        this.quantity = quantity;
    }

    // Getters and Setters
    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public String getItemName() { return itemName; }
    public void setItemName(String itemName) { this.itemName = itemName; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }
}
