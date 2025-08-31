package com.shirtms.inventory.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shirtms.inventory.dto.InventoryRequestDTO;
import com.shirtms.inventory.entity.InventoryItem;
import com.shirtms.inventory.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public InventoryItem stockIn(InventoryRequestDTO request) {
        List<InventoryItem> items = inventoryRepository.findByItemName(request.getItemName());
        InventoryItem item;

        if (items.isEmpty()) {
            item = new InventoryItem();
            item.setItemName(request.getItemName());
            item.setProductType(request.getProductType());
            item.setCurrentQuantity(request.getQuantity());
        } else {
            item = items.get(0);
            item.setCurrentQuantity(item.getCurrentQuantity() + request.getQuantity());
        }

        return inventoryRepository.save(item);
    }
    


    @Override
    public InventoryItem stockOut(InventoryRequestDTO request) {
        List<InventoryItem> items = inventoryRepository.findByItemName(request.getItemName());
        if (items.isEmpty()) {
            throw new RuntimeException("Item not found in inventory: " + request.getItemName());
        }

        InventoryItem item = items.get(0);
        if (item.getCurrentQuantity() < request.getQuantity()) {
            throw new RuntimeException("Not enough stock for item: " + request.getItemName());
        }

        item.setCurrentQuantity(item.getCurrentQuantity() - request.getQuantity());
        return inventoryRepository.save(item);
    }

    @Override
    public List<InventoryItem> getLowStockItems() {
        return inventoryRepository.findAll().stream()
                .filter(item -> item.getCurrentQuantity() <= item.getMinimumThreshold())
                .toList();
    }

    @Override
    public List<InventoryItem> filterInventory(String itemName, String productType) {
        if (itemName != null && productType != null) {
            return inventoryRepository.findByItemNameAndProductType(itemName, productType);
        } else if (itemName != null) {
            return inventoryRepository.findByItemName(itemName);
        } else if (productType != null) {
            return inventoryRepository.findByProductType(productType);
        } else {
            return inventoryRepository.findAll();
        }
    }

    @Override
    public InventoryItem addInventoryItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }

   

    @Override
    public List<InventoryItem> getAllItems() {
        return inventoryRepository.findAll();
    }

}
