package com.shirtms.inventory.service;

import java.util.List;

import com.shirtms.inventory.dto.InventoryRequestDTO;
import com.shirtms.inventory.entity.InventoryItem;

public interface InventoryService {

    InventoryItem stockIn(InventoryRequestDTO request);

    InventoryItem stockOut(InventoryRequestDTO request);

    List<InventoryItem> getLowStockItems();

    List<InventoryItem> getAllItems();  // 👈 rename getAllInventory to getAllItems

    List<InventoryItem> filterInventory(String itemName, String productType);

    InventoryItem addInventoryItem(InventoryItem item);  // 👈 add this method
}
