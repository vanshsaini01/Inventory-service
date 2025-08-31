package com.shirtms.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shirtms.inventory.dto.InventoryRequestDTO;
import com.shirtms.inventory.entity.InventoryItem;
import com.shirtms.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    private final InventoryService inventoryService;

    // ✅ Constructor injection (recommended instead of field injection)
    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    // ✅ Add a new inventory item
    @PostMapping("/item")
    public InventoryItem addInventoryItem(@RequestBody InventoryItem item) {
        return inventoryService.addInventoryItem(item);
    }

    // ✅ Stock in
    @PostMapping("/stock-in")
    public InventoryItem stockIn(@RequestBody InventoryRequestDTO request) {
        return inventoryService.stockIn(request);
    }

    // ✅ Stock out
    @PostMapping("/stock-out")
    public InventoryItem stockOut(@RequestBody InventoryRequestDTO request) {
        return inventoryService.stockOut(request);
    }

    // ✅ Get all inventory items
    @GetMapping("/items")
    public List<InventoryItem> getAllInventory() {
        return inventoryService.getAllItems();
    }

    // ✅ Get low-stock items
    @GetMapping("/low-stock")
    public List<InventoryItem> getLowStockItems() {
        return inventoryService.getLowStockItems();
    }

    // ✅ Filter inventory by name and/or product type
    @GetMapping("/filter")
    public List<InventoryItem> filterInventory(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String productType) {
        return inventoryService.filterInventory(name, productType);
    }
}
