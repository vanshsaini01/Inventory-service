package com.shirtms.inventory.service;

import com.shirtms.inventory.dto.InventoryRequestDTO;
import com.shirtms.inventory.entity.InventoryItem;

import java.util.List;

public interface InventoryService {
    InventoryItem stockIn(InventoryRequestDTO request);
    InventoryItem stockOut(InventoryRequestDTO request);
    List<InventoryItem> getAllInventory();
    List<InventoryItem> getLowStockItems();
    InventoryItem addInventoryItem(InventoryItem item);
}
