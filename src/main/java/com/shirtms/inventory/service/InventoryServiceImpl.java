package com.shirtms.inventory.service;

import com.shirtms.inventory.dto.InventoryRequestDTO;
import com.shirtms.inventory.entity.InventoryItem;
import com.shirtms.inventory.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class InventoryServiceImpl implements InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Override
    public InventoryItem stockIn(InventoryRequestDTO request) {
        Optional<InventoryItem> itemOpt = inventoryRepository.findByItemName(request.getItemName());
        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            item.setCurrentQuantity(item.getCurrentQuantity() + request.getQuantity());
            return inventoryRepository.save(item);
        }
        throw new RuntimeException("Item not found");
    }

    @Override
    public InventoryItem stockOut(InventoryRequestDTO request) {
        Optional<InventoryItem> itemOpt = inventoryRepository.findByItemName(request.getItemName());
        if (itemOpt.isPresent()) {
            InventoryItem item = itemOpt.get();
            int newQuantity = item.getCurrentQuantity() - request.getQuantity();
            if (newQuantity < 0) throw new RuntimeException("Insufficient stock");
            item.setCurrentQuantity(newQuantity);
            return inventoryRepository.save(item);
        }
        throw new RuntimeException("Item not found");
    }

    @Override
    public List<InventoryItem> getAllInventory() {
        return inventoryRepository.findAll();
    }

    @Override
    public List<InventoryItem> getLowStockItems() {
        return inventoryRepository.findAll()
                .stream()
                .filter(item -> item.getCurrentQuantity() < item.getMinimumThreshold())
                .collect(Collectors.toList());
    }

    @Override
    public InventoryItem addInventoryItem(InventoryItem item) {
        return inventoryRepository.save(item);
    }
}
