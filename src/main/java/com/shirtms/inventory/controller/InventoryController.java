package com.shirtms.inventory.controller;

import com.shirtms.inventory.dto.InventoryRequestDTO;
import com.shirtms.inventory.entity.InventoryItem;
import com.shirtms.inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @PostMapping("/stock-in")
    public InventoryItem stockIn(@RequestBody InventoryRequestDTO request) {
        return inventoryService.stockIn(request);
    }

    @PostMapping("/stock-out")
    public InventoryItem stockOut(@RequestBody InventoryRequestDTO request) {
        return inventoryService.stockOut(request);
    }

    @GetMapping("/all")
    public List<InventoryItem> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    @GetMapping("/low-stock")
    public List<InventoryItem> getLowStockItems() {
        return inventoryService.getLowStockItems();
    }

    @PostMapping("/item")
    public InventoryItem addInventoryItem(@RequestBody InventoryItem item) {
        return inventoryService.addInventoryItem(item);
    }
}
